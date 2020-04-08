/* select upper (user_name) from app_user order by Upper (user_name);

drop table match_up;
drop table player;
drop table team_tournament;
drop table team;
drop table tournament;
drop table app_user;
drop table game_type;  */

BEGIN;

DROP TABLE IF EXISTS match_up;
Create Table match_up (
match_up_id serial primary key,
tournament_id integer,
game_id integer,
team_id_1 integer,
team_id_2 integer,
location varchar (100),
date date,
time varchar (30),
winner_id integer default '0',
loser_id integer default '0'
);


DROP TABLE IF EXISTS player;
Create Table player (
Player_id integer,
team_id integer,
ranking integer,
points_scored integer
);


DROP TABLE IF EXISTS team_tournament;
Create Table team_tournament (
tournament_id integer,
team_id integer,
ranking integer,
wins integer,
losses integer
);


DROP TABLE IF EXISTS team;
Create Table team (
team_id serial primary key,
team_name varchar (50),
captain_id integer
);


DROP TABLE IF EXISTS tournament;
Create Table tournament (
tournament_id serial primary key,
tournament_name varchar (50),
organizer_id integer,
game_id integer,
tournament_type varchar (30) default 'single',
description varchar (5000)
);


DROP TABLE IF EXISTS app_user;
Create Table  app_user (
id serial Primary Key, 
user_name varchar (50),
password varchar (50),
email varchar (50),
role varchar (2),
salt varchar (255)
);


DROP TABLE IF EXISTS game_type;
Create Table game_type (
game_id serial primary key,
game_type varchar (30),
min_team_size integer,
max_team_size integer
);


alter table player
add constraint teamID_to_teamteamID foreign key (team_id) references team (team_id);


alter table player
add constraint playerID_appuserID foreign key (player_id) references app_user (id);


alter table team
add constraint captainID_appuserID foreign key (captain_id) references app_user (id);


alter table tournament
add constraint organizerID_appuserID foreign key (organizer_id) references app_user (id);


Alter table tournament
add constraint gameID_gametypeGameID foreign key (game_id) references game_type (game_id);


alter table match_up
add constraint gameID_gametypegameID foreign key (game_id) references game_type (game_id);


Alter table match_up
add constraint tournamentID_tournamentTournmentID foreign key (tournament_id) references tournament (tournament_id);


alter table team_tournament
add constraint tournamentID_tournamentTournamentID foreign key (tournament_id) references tournament (tournament_id);


alter table team_tournament
add constraint teamID_teamTeamID foreign key (team_id) references team (team_id);


COMMIT;






















