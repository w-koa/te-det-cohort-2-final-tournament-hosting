/* select upper (user_name) from app_user order by Upper (user_name);

drop table match_up;
drop table player;
drop table team_tournament;
drop table team;
drop table tournament;
drop table app_user;
drop table game_type;  */

Create Table  app_user (
id serial Primary Key, 
user_name varchar (50),
password varchar (50),
email varchar (50),
role integer,
salt varchar (255)
);

Create Table player (
Player_id integer primary key,
team_id integer,
ranking integer,
points_scored integer
);

Create Table team_tournament (
tournament_id integer primary key,
team_id integer,
ranking integer,
wins integer,
losses integer
);

Create Table team (
team_id serial primary key,
team_name varchar (50),
captain_id integer
);

Create Table tournament (
tournament_id serial primary key,
tournament_name varchar (50),
organizer_id integer,
game_id integer,
tournament_type varchar (30),
description varchar (2000)
);

Create Table match_up (
match_up_id serial primary key,
tournament_id integer,
game_id integer,
team_id_1 integer,
team_id_2 integer,
location varchar (100),
date date,
time integer,
winner_id integer,
loser_id integer
);

Create Table game_type (
game_id serial primary key,
game_type varchar (30),
min_team_size integer,
max_team_size integer
);




alter table player
add constraint teamID_to_teamteamID foreign key (team_id) references team (team_id);

alter table team
add constraint captainID_appuserID foreign key (captain_id) references app_user (id);

alter table tournament
add constraint organizerID_appuserID foreign key (organizer_id) references app_user (id);

alter table tournament
add constraint gameID_gametypeGameID foreign key (game_id) references game_type (game_id);

alter table match_up
add constraint gameID_gametypegameID foreign key (game_id) references game_type (game_id);

Alter table match_up
add constraint tournamentID_tournamentTournmentID foreign key (tournament_id) references tournament (tournament_id);

alter table team_tournament
add constraint tournamentID_tournamentTournamentID foreign key (tournament_id) references tournament (tournament_id);

alter table team_tournament
add constraint teamID_teamTeamID foreign key (team_id) references team (team_id);




insert into player (ranking, points_scored) values (6, 45);
insert into player (ranking, points_scored) values (5, 45);
insert into player (ranking, points_scored) values (13, 43);
insert into player (ranking, points_scored) values (12, 39);
insert into player (ranking, points_scored) values (9, 37);
insert into player (ranking, points_scored) values (19, 3);
insert into player (ranking, points_scored) values (7, 29);
insert into player (ranking, points_scored) values (9, 48);
insert into player (ranking, points_scored) values (2, 32);
insert into player (ranking, points_scored) values (7, 43);
insert into player (ranking, points_scored) values (19, 25);
insert into player (ranking, points_scored) values (18, 9);
insert into player (ranking, points_scored) values (12, 20);
insert into player (ranking, points_scored) values (13, 9);
insert into player (ranking, points_scored) values (19, 10);
insert into player (ranking, points_scored) values (14, 6);
insert into player (ranking, points_scored) values (13, 39);
insert into player (ranking, points_scored) values (20, 1);
insert into player (ranking, points_scored) values (15, 30);
insert into player (ranking, points_scored) values (16, 43);
insert into player (ranking, points_scored) values (4, 17);
insert into player (ranking, points_scored) values (7, 37);
insert into player (ranking, points_scored) values (18, 49);
insert into player (ranking, points_scored) values (18, 39);
insert into player (ranking, points_scored) values (20, 29);
insert into player (ranking, points_scored) values (7, 8);
insert into player (ranking, points_scored) values (5, 1);
insert into player (ranking, points_scored) values (15, 6);
insert into player (ranking, points_scored) values (17, 17);
insert into player (ranking, points_scored) values (16, 37);
insert into player (ranking, points_scored) values (14, 19);
insert into player (ranking, points_scored) values (1, 29);
insert into player (ranking, points_scored) values (16, 47);
insert into player (ranking, points_scored) values (4, 39);
insert into player (ranking, points_scored) values (2, 25);
insert into player (ranking, points_scored) values (7, 7);
insert into player (ranking, points_scored) values (4, 25);
insert into player (ranking, points_scored) values (15, 23);
insert into player (ranking, points_scored) values (18, 10);
insert into player (ranking, points_scored) values (15, 13);
insert into player (ranking, points_scored) values (4, 35);
insert into player (ranking, points_scored) values (7, 24);
insert into player (ranking, points_scored) values (5, 32);
insert into player (ranking, points_scored) values (8, 42);
insert into player (ranking, points_scored) values (17, 3);
insert into player (ranking, points_scored) values (7, 22);
insert into player (ranking, points_scored) values (7, 9);
insert into player (ranking, points_scored) values (19, 49);
insert into player (ranking, points_scored) values (13, 10);
insert into player (ranking, points_scored) values (9, 17);
insert into player (ranking, points_scored) values (8, 4);
insert into player (ranking, points_scored) values (19, 20);
insert into player (ranking, points_scored) values (20, 1);
insert into player (ranking, points_scored) values (9, 22);
insert into player (ranking, points_scored) values (20, 22);
insert into player (ranking, points_scored) values (18, 2);
insert into player (ranking, points_scored) values (14, 37);
insert into player (ranking, points_scored) values (5, 6);
insert into player (ranking, points_scored) values (19, 36);
insert into player (ranking, points_scored) values (10, 33);
insert into player (ranking, points_scored) values (20, 49);
insert into player (ranking, points_scored) values (20, 48);
insert into player (ranking, points_scored) values (6, 37);
insert into player (ranking, points_scored) values (8, 48);
insert into player (ranking, points_scored) values (7, 26);
insert into player (ranking, points_scored) values (15, 31);
insert into player (ranking, points_scored) values (7, 50);
insert into player (ranking, points_scored) values (4, 17);
insert into player (ranking, points_scored) values (11, 50);
insert into player (ranking, points_scored) values (9, 11);

















