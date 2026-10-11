ALTER TABLE dbo.albums
    ADD CONSTRAINT pk_albums
    PRIMARY KEY (id);

ALTER TABLE dbo.artists
    ADD CONSTRAINT pk_artist
    PRIMARY KEY (id);

ALTER TABLE dbo.audio_features
    ADD CONSTRAINT pk_audio_features
    PRIMARY KEY (id);

ALTER TABLE dbo.genres
    ADD CONSTRAINT pk_genres
    PRIMARY KEY (name);

ALTER TABLE dbo.tracks
    ADD CONSTRAINT pk_tracks
    PRIMARY KEY (id);

ALTER TABLE dbo.r_albums_artists
    ADD CONSTRAINT fk_r_albums_artists
            FOREIGN KEY (album_id) REFERENCES dbo.albums (id),
        CONSTRAINT fk_r_albums_artists2
            FOREIGN KEY (artist_id) REFERENCES dbo.artists (id);

ALTER TABLE dbo.r_albums_tracks
    ADD CONSTRAINT fk_r_albums_tracks
            FOREIGN KEY (album_id) REFERENCES dbo.albums (id),
        CONSTRAINT fk_r_albums_tracks2
            FOREIGN KEY (track_id) REFERENCES dbo.tracks (id);

ALTER TABLE dbo.r_artist_genre
    ADD CONSTRAINT fk_r_artist_genre
            FOREIGN KEY (genre_name) REFERENCES dbo.genres (name),
        CONSTRAINT fk_r_artist_genre2
            FOREIGN KEY (artist_id) REFERENCES dbo.artists (id);

ALTER TABLE dbo.r_track_artist
    ADD CONSTRAINT fk_r_track_artist
            FOREIGN KEY (track_id) REFERENCES dbo.tracks (id),
        CONSTRAINT fk_r_track_artist2
            FOREIGN KEY (artist_id) REFERENCES dbo.artists (id);

ALTER TABLE dbo.audio_features
    ADD CONSTRAINT fk_audio_features
        FOREIGN KEY (id) REFERENCES dbo.tracks (id);