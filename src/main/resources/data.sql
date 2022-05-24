CREATE TABLE player(
                       id              BIGINT NOT NULL AUTO_INCREMENT,
                       player_Name      varchar(255) NOT NULL,
                       player_Password  varchar(255) NOT NULL,
                       lvl      INT,
                       exp INT,
                       PRIMARY KEY (id)
);

CREATE TABLE pokemon(
                        id              BIGINT NOT NULL AUTO_INCREMENT,
                        player_ID        BIGINT NOT NULL,
                        pokemon_ID       INT NOT NULL,
                        owned           BOOL,
                        seen            BOOL,
                        PRIMARY KEY (id)
);

ALTER TABLE pokemon
        ADD CONSTRAINT pokemon_player_id
        FOREIGN KEY (player_ID) REFERENCES player(id);



INSERT INTO PLAYER( exp, lvl, player_Name, player_Password)VALUES (0, 1, 'tester', 'tester' );
INSERT INTO PLAYER( exp, lvl, player_Name, player_Password)VALUES (0, 1, 'player1', 'player1' );

INSERT INTO pokemon( player_ID, pokemon_ID, owned, seen)VALUES (1, 25, TRUE, TRUE );
INSERT INTO pokemon( player_ID, pokemon_ID, owned, seen)VALUES (2, 36, FALSE, TRUE );
INSERT INTO pokemon( player_ID, pokemon_ID, owned, seen)VALUES (1, 5, TRUE, TRUE );
INSERT INTO pokemon( player_ID, pokemon_ID, owned, seen)VALUES (1, 28, FALSE, TRUE );
