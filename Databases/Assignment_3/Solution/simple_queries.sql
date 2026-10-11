/*
1: Εμφάνισε τα τραγούδια με τη μεγαλύτερη και μικρότερη χρονική διάρκεια, μαζί με το όνομα του καλιτέχνη και τη δημοσιότητα τους.
Output: 10 rows
*/

SELECT tracks.name AS Track_Name, tracks.duration AS Song_Duration, artists.name AS Artist_Name, tracks.popularity AS Popularity
FROM tracks JOIN r_track_artist AS rta
    ON tracks.id = rta.track_id JOIN artists
    ON rta.artist_id = artists.id
WHERE tracks.duration IN (SELECT  MAX(duration) FROM tracks) OR
      tracks.duration IN (SELECT MIN(duration) FROM tracks)

/*
2: Εμφάνισε τα album που έχουν  από 5 εως 10 τραγούδια
Output: 436 rows
*/

SELECT al.name AS Album_Name, COUNT(tracks.id) AS Total_Songs
FROM albums AS al JOIN r_albums_tracks AS alt
    ON al.id = alt.album_id JOIN tracks
    ON tracks.id = alt.track_id
GROUP BY al.id, al.name  HAVING COUNT(DISTINCT tracks.id) BETWEEN 5 AND 10;

/*
3: Εμφάνισε τους καλλιτέχνες μαζί με τη δημοσιότητά τους, που δεν έχουν κανένα τραγούδι
Output: 35 rows
*/

SELECT a.name AS Name, a.popularity AS Popularity
FROM artists AS a LEFT OUTER JOIN r_track_artist AS rta
    ON a.id = rta.artist_id
WHERE rta.artist_id IS NULL

/*
4: Όλα τα τραγούδια του 2Pac
Output: 33 Rows
*/

SELECt t.name AS Playlist_2Pac
FROM artists AS a JOIN r_track_artist AS rta
    ON a.id = rta.artist_id JOIN tracks AS t 
    ON rta.track_id = t.id
WHERE a.name LIKE '2Pac';

/* 
5: Όλα τα album που δεν περιέχουν κανένα τραγούδι
Output: 8309 rows
*/

SELECT albums.name
FROM albums LEFT OUTER JOIN r_albums_tracks
    ON albums.id = r_albums_tracks.album_id
WHERE r_albums_tracks.album_id IS NULL;


/*
6: Το πλήθος των καλλιτεχνών που ανήκουν στο κάθε είδος μουσικής σε φθίνουσα σειρά
Output: 1753 rows
*/

SELECT genres.name AS Genre_Name, COUNT(DISTINCT artists.id) AS Total_Artists
FROM artists RIGHT OUTER JOIN r_artist_genre AS rag
    ON artists.id = rag.artist_id RIGHT OUTER JOIN genres
    ON genres.name = rag.genre_name
GROUP BY genres.name 
ORDER BY Total_Artists DESC;


/*
7: Όλοι οι καλλιτέχνες που ανήκουν σε τουλάχιστον 2 είδη μουσικής
Output: 637 rows
*/

/* Distinct is needed since r_arist_genre has not pk yet*/

SELECT artists.name AS Artist_Name, COUNT(DISTINCT genre_name) AS Total_Number_Of_Genres
FROM artists JOIN r_artist_genre
    ON artists.id = r_artist_genre.artist_id 
GROUP BY artists.id, artists.name HAVING COUNT(DISTINCT genre_name) >= 2;


/*SELECT artists.id, artists.name, genre_name
FROM artists JOIN r_artist_genre
    ON artists.id = r_artist_genre.artist_id 
WHERE artists.name = 'Espinoza Paz'*/

/* 
8: Εμφάνισε τον πιο διάσημο ράπερ, αν κάποιοι άλλοι είναι εξίσου διάσημοι συμπεριλαμβάνουμε και αυτούς.
Ouput: 2 rows
*/

SELECT DISTINCT artists.name AS Name, artists.popularity AS Popularity
FROM artists JOIN r_artist_genre AS rag
    ON artists.id = rag.artist_id JOIN genres
    ON rag.genre_name = genres.name
WHERE genres.name LIKE '%hip_hop%' AND artists.popularity >= (
    SELECT MAX(artists2.popularity)
    FROM artists AS artists2 JOIN r_artist_genre AS rag2
        ON artists2.id = rag2.artist_id JOIN genres AS genres2
        ON rag2.genre_name = genres2.name 
    WHERE genres2.name Like '%hip_hop%'
);


/*
9: Συνολική χρονική διάρκεια τραγουδιών ανα άλμπουμ -μαζί με τα album που δεν έχουν τραγούδια, θα πρέπει ο συνολικός χρόνος να είναι 0
Output: 9995
*/

SELECT a.id, a.name AS ALBUM_NAME, SUM(t.duration) AS TOTAL_TIME
FROM albums AS a JOIN r_albums_tracks AS rat
    ON a.id = rat.album_id JOIN tracks AS t
    ON rat.track_id = t.id 
GROUP BY a.id, a.name
UNION 
SELECT a.id, a.name AS ALBUM_NAME, 0 AS TOTAL_TIME
FROM albums AS a LEFT OUTER JOIN r_albums_tracks AS rat
    ON a.id = rat.album_id
WHERE rat.album_id IS NULL
ORDER BY TOTAL_TIME ASC;


/*
10: Τους 20 καλλιτέχνες με το περισσότερα  τραγούδια
Output: 20
*/

SELECT TOP 20 a.name, COUNT(DISTINCT t.id) AS total_songs
FROM artists AS a JOIN r_track_artist AS rta
    ON a.id = rta.artist_id JOIN tracks AS t
    ON t.id = rta.track_id 
GROUP BY a.id, a.name 
ORDER BY total_songs DESC;

/*
11: Ανάκτηση των καλλιτεχνών που έχουν περισσότερη δημοσιότητα (popularity) από το μέσο όρο.
Output: 696 rows
*/

SELECT artists.name AS Artist_Name, artists.popularity AS Popularity
FROM artists
WHERE artists.popularity >= (SELECT AVG(a.popularity) FROM artists AS a)
ORDER BY artists.popularity;

/*
12: Βρές το πλήθος των καλλιτεχνών που έχουν δημιουργήσει κάποιο άλμουμ
Output: 1 row
*/

SELECT COUNT(DISTINCT artists.name) AS Total_Artists_With_Albums
FROM artists JOIN r_albums_artists 
    ON artists.id = r_albums_artists.artist_id;

