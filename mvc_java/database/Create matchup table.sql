create table match_up(
match_up_id serial primary key,
tournament_id integer,
game_id integer,
team_id_1 integer,
team_id_2 integer,
location varchar (50),
date date,
time integer,
winner_id integer default '0',
loser_id integer default '0'
);