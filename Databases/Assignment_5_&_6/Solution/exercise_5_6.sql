-- Ορισμός ξένου κλειδιού στον πίνακα ratings

ALTER TABLE ratings ADD CONSTRAINT fk_album_id
    FOREIGN KEY(album_id) 
        REFERENCES albums(id);

-- 1: Γράψτε την SQL δήλωση για την προσθήκη της στήλης AVG_Rating στον πίνακα albums, καθορίζοντας τον κατάλληλο τύπο δεδομένων.

ALTER TABLE albums ADD AVG_Rating DECIMAL(3, 2);

-- 2: Γράψτε την SQL δήλωση που υπολογίζει και ενημερώνει τη μέση βαθμολογία (AVG_Rating) στον πίνακα albums, βάσει των δεδομένων του πίνακα Ratings.

WITH tmp(album_id, avg_rating) 
    AS(
        SELECT album_id, AVG(CAST(rating AS FLOAT)) AS avg_rating 
        FROM ratings
        GROUP BY album_id
    )
UPDATE dbo.albums
SET AVG_RATING = tmp.avg_rating 
FROM tmp
WHERE id = tmp.album_id;

-- Testing
-- select id from albums where id not in (select album_id from ratings) order by id;
-- SELECT album_id, cast(avg(cast(rating as float)) as decimal(3, 2)) as avg_rating from ratings group by album_id order by album_id
-- SELECT id, AVG_RATING FROM albums
-- select * from albums left outer join (SELECT album_id, cast(avg(cast(rating as float)) as decimal(3, 2)) as avg_rating from ratings group by album_id) t on albums.id = t.album_id
 
/* 
-- 3: Γράψτε την SQL δήλωση για τη δημιουργία ενός trigger που θα ενημερώνει αυτόματα τη στήλη AVG_Rating μετά από κάθε εισαγωγή, τροποποίηση ή διαγραφή στον πίνακα
    Ratings, ενημερώνοντας μόνο τα σχετικά άλμπουμ 
*/

GO

CREATE TRIGGER avg_ratings_trigger ON dbo.ratings 
AFTER INSERT, UPDATE, DELETE
AS
WITH tmp(album_id) 
    AS(
        SELECT album_id
        FROM Inserted
        UNION 
        SELECT album_id
        FROM Deleted
    )
UPDATE dbo.albums
SET AVG_RATING = (
    SELECT AVG(CAST(rating AS FLOAT))
    FROM ratings 
    WHERE album_id = id
    GROUP BY album_id
)
WHERE id IN (SELECT * FROM tmp);

GO

-- TESTING 
--drop trigger avg_ratings_trigger;
--insert into ratings values (1, 3, 5);
--select * from albums where id = 3; /* AVG_Rating expected 5.00 */
--insert into ratings values (2, 3, 5), (3, 3, 3)
--update ratings set rating = 2 where album_id = 3 and user_id = 3;
--select * from albums where id = 3; /* AVG_Rating expected 4.00*/
--delete from ratings where album_id = 3;
--select * from albums where id = 3; /* AVG_Rating expected NULL*/


-- 4: Γράψτε την SQL δήλωση για τη δημιουργία ευρετηρίου που θα βελτιστοποιήσει την απόδοση του trigger

CREATE INDEX ratings_album_id_indx ON ratings(album_id);

-- 5: Αριθμός των albums ανά έτος για albums με δημοφιλία (popularity) μεγαλύτερη από 40 (year, albums_per_year)

SELECT YEAR(release_date) AS [Year], COUNT(*) AS Albums_Per_Year
FROM albums
WHERE popularity > 40
GROUP BY YEAR(release_date)

-- 6: Αριθμός των albums ανά έτος για albums που είτε έχουν δημοφιλία (popularity) μεγαλύτερη από 40 είτε είναι τύπου 'single' (year, albums_per_year)

SELECT YEAR(release_date) AS [Year], COUNT(*) AS Albums_Per_Year
FROM albums
WHERE popularity > 40 OR album_type LIKE 'single'
GROUP BY YEAR(release_date)

-- 7: Αριθμός των albums ανά τύπο (album_type) και ανά έτος (album_type, year, albums_per_type_year)

SELECT album_type AS Album_Type, Year(release_date) AS [Year], COUNT(*) AS Albums_Per_Type_Year
FROM albums
GROUP BY YEAR(release_date), album_type
ORDER BY [YEAR] DESC, Album_Type;

-- 8: Για τον καλλιτέχνη 'Various Artists', επιστρέψτε τον αριθμό των albums στα οποία έχει συμμετάσχει ανά έτος (artist, year, albums_per_year)

SELECT artists.name AS Artist, YEAR(release_date) AS [Year], COUNT(*) AS Albums_Per_Year
FROM artists JOIN r_albums_artists AS raa 
    ON artists.id = raa.artist_id JOIN albums
    ON raa.album_id = albums.id
WHERE artists.name LIKE 'Various Artists' 
GROUP BY artists.name, YEAR(release_date)
ORDER BY [Year] DESC;

-- 9: Το album με τη μεγαλύτερη δημοφιλία (popularity) ανά έτος, όταν η δημοφιλία δεν είναι μηδενική (year, max_popularity)

SELECT YEAR(release_date) AS [Year], MAX(popularity) AS max_popularity
FROM albums
GROUP BY YEAR(release_date) HAVING MAX(popularity) > 0
ORDER BY [Year] DESC;

-- 10: Τα ονόματα των καλλιτεχνών που έχουν συμμετάσχει σε περισσότερα από 1 albums

SELECT artists.name AS Artist, COUNT(*) AS Albums_Per_Artist
FROM artists JOIN r_albums_artists AS raa
    ON artists.id = raa.artist_id
GROUP BY artists.name HAVING COUNT(*) > 1;

/*
-- 11: Για κάθε χρήστη του πίνακα Ratings,να δημιουργηθεί μία όψη (view) που να περιέχει τη μέση βαθμολογία του 
    και τον αριθμό των βαθμολογιών του (user_id, avg_rating, rating_count)
*/

GO

CREATE VIEW UserRatings(user_id, avg_rating, rating_count) 
AS
    SELECT user_id, CAST(AVG(CAST(rating AS FLOAT)) AS DECIMAL(3, 2)) AS avg_rating, COUNT(*) AS rating_count
    FROM ratings
    GROUP BY user_id;

GO

SELECT * FROM UserRatings;

-- DROP VIEW UserRatings;

/*
-- 12: Τα 10 albums με τη μεγαλύτερη δημοφιλία (popularity). Αν υπάρχουν ισοβαθμίες στην 10η θέση, 
    να επιστραφεί μόνο ένα από αυτά. (album_title, popularity)
*/

SELECT TOP(10) [name] AS album_title, popularity
FROM albums
ORDER BY popularity DESC

/*
-- 13: Να επιστραφούν τα ονόματα των albums που έχουν τη μέγιστη δημοφιλία (popularity)
    ανά έτος, χρησιμοποιώντας εμφωλευμένο ερώτημα. Το αποτέλεσμα να περιλαμβάνει τα
    πεδία (year, most_popular_album), ταξινομημένα κατά έτος και όνομα album
*/

/* Εδώ προσθέσαμε τον επιπλέον περιορισμό να έχουν popularity μεγαλύτερο του 0 */

SELECT Year(release_date) AS [Year], [name] AS Most_Popular_Album
FROM albums AS ext
WHERE popularity > 0 AND popularity >= ALL (
    SELECT popularity 
    FROM albums intr
    WHERE Year(intr.release_date) = Year(ext.release_date)
)
ORDER BY [Year] DESC, Most_Popular_Album


/*
-- 14: Να επιστραφούν οι καλλιτέχνες (name) που έχουν τουλάχιστον μία συμμετοχή σε είδος
    Rock και μία συμμετοχή σε είδος Blues, αλλά δεν έχουν συμμετάσχει σε κανένα άλλο
    είδος. (Υπόδειξη: Χρήση των τελεστών EXISTS και NOT EXISTS)
*/

SELECT a.name AS Artist
FROM artists a
WHERE 
    EXISTS (
        SELECT 1 
        FROM r_artist_genre AS rag1
        WHERE a.id = rag1.artist_id AND rag1.genre_name LIKE '%rock%'
    )
AND EXISTS (
        SELECT 1 
        FROM r_artist_genre AS rag2
        WHERE a.id = rag2.artist_id AND rag2.genre_name LIKE '%blue%'
)
AND NOT EXISTS (
        SElect 1 
        FROM r_artist_genre AS rag3
        WHERE a.id = rag3.artist_id 
            AND rag3.genre_name NOT LIKE '%rock%'
            AND rag3.genre_name NOT LIKE '%blues%' 
);

/*
-- 15: Να απαντηθεί το προηγούμενο ερώτημα χρησιμοποιώντας τελεστές για σύνολα UNION,
        INTERSECT, EXCEPT
*/

SELECT a.name
FROM artists AS a JOIN (
    ((
        SELECT rag1.artist_id 
        FROM r_artist_genre AS rag1
        WHERE rag1.genre_name LIKE '%rock%'
    )
    INTERSECT
    (
        SELECT rag2.artist_id 
        FROM r_artist_genre AS rag2
        WHERE rag2.genre_name LIKE '%blues%'
    ))
    EXCEPT
    (
        SELECT rag3.artist_id
        FROM r_artist_genre AS rag3
        WHERE rag3.genre_name NOT LIKE '%rock%'
            AND rag3.genre_name NOT LIKE '%blues%'
    )
) AS t ON a.id = t.artist_id


/*
-- 16: Να βρεθούν όλα τα ζεύγη χρηστών που έχουν αξιολογήσει τουλάχιστον 4 κοινά albums
    με την ίδια βαθμολογία (δηλαδή και οι δύο χρήστες έβαλαν την ίδια τιμή βαθμολογίας
    στο ίδιο album)
*/

SELECT r1.user_id AS User1, r2.user_id AS User2
FROM ratings r1 JOIN ratings r2 
    ON r1.album_id = r2.album_id AND r1.rating = r2.rating 
        AND r1.user_id < r2.user_id
GROUP BY r1.user_id, r2.user_id HAVING COUNT(*) >= 4
ORDER BY User1, User2
