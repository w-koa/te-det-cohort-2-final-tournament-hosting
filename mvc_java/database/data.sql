/*
data has to go in
app_user
game_type
team
tournament
match_up
player - player gives a null execption for the primary key it shares with app_user
team_tournament - both fields should be derived from other tables
*/


BEGIN;

insert into app_user (id, user_name, email, password, role, salt) values (1, 'Timtheorganizer',	'0qsE4UcPgn5PKop2chJfDQ==', 'tim@tim.com', 3, '9eKxUk/KrrxZQVKS10g5m1IlQcEWHmY0TaEybpR+rS09DSQTVesCt0vNdArYr7wooLxidul721StsX3i5mG6Ub1OSMP0GCVM/xQipuun3XTvpFzIxmM12OcYNwosfGFLj9GUua/QTfT5lkPIv1yxNjXbwpO1yHDPpcEx/T6bneM=');
insert into app_user (id, user_name, email, password, role, salt) values (2,	'Andytheorganizer',	'jEYG2Ge1yJ0bMgD9cg1Sog==',	'Andy@andy.com',	3,	'FTIVR22eyOAf06ABYQPdZA1P9LgpCbcac93Zk8n4uaI8sMDttnurGNrq9FdFqhkgva3y1/VLUH/A1zjF3rI3OQBJ+QpahGejNuYeUnXkuZ3Khl+yoGbHBCPNJE3JNxNfhs9wVBU7b8kKjVjUYLNnfKfhRfYf0BGysxLfZno4qgg=');
insert into app_user (id, user_name, email, password, role, salt) values (3,	'Miketheorganizer',	'sxKGNKwOlCiyYlrEi11edA==',	'mike@mike.com',	3,	'FTzop4s6Pws3cF6Lsmsary0WJs58FL4HxTmVLLZnkYsTQq8kXmwsCoYF6jZAO0fNq2JDeaWGJWTtvPo1dpxGOE07cilLVmWT1RGNlwGLFUJ7eHt2Y/o/FLmfNQHf5ioMw0Wcw2zNvcBs5lLB7R4muk6xMmKDCpv+NuZhLI1oGSE=');
insert into app_user (id, user_name, email, password, role, salt) values (4,	'Willistheorganizer',	'187+x13uIZ+jpxP6lDuwWg==',	'Willis@willis.com',	3,	'pBQZjm99GDvZ0Wc5zODTGNRyOLqIikrI/RFZU2XHSSSl/4g9xs2QCKD+sK7s8z7TKaRT9PSbQRz8mjrW9+1JVnt6cJxjf6hsCLlYNm6w7eA9q4bDaJumbAA1XiYO7ROrNUajODzBJfgO1UcM3Vpl1Yr3KInwKM1DOQuKGN8kGn8=');
insert into app_user (id, user_name, email, password, role, salt) values (5,	'bob',	'utmUtgyKT+daYfmcsKoJmw==',	'bob@bob',	2,	'YQbti6cacZU7KbluG+mZSeEC1xDExRfQ/uuKpNOTs+06UDxV7ykRhY0OVlHZvwkxj9/wnrNevPgWZ5GD14SZqRcz/n9wefgf/ZP+gu3cpyjTDBgUzXkzx26J8Q/wfxh9GTSfgWud1YFCMSGC2qtpBdw60C1gTETiWGyOqlMbqSg=');
insert into app_user (id, user_name, email, password, role, salt) values (6,	'liam',	'tpwaCt6QiGMgv4lWv3KWlw==',	'liam@liam.com',	2,	'dNgUUcJvuqCbSQPC4sv7YBqTjiQk/eGnRdAbPgxWucQiCWqXcj/e+cQ6PB6+ymwAaudtUAVDWJV/1hAnsyvsNs7HXuxoUC2e6SwrPNBsVI7lpT40Apye/24U55wEYObEkpl7z7X5OcH7rX/gPCS1eKutYG0qXq7fwinABg2adXI=');
insert into app_user (id, user_name, email, password, role, salt) values (7,	'noah',	'MNeL8rsMJr4gKI3vpmYx5Q==',	'noah@noah.com',	2,	'3Wfq+x5esRk/1zwxYacBn+qExDq0V46EE9C5nZ2rAVqCkveK7FIdrYj2ryLj5csy27zqRmrGjOqTcR89sHlihvxsa/nyRga9WhOtTP68xpEhZP0D6n1AAYfRG7DFR7rPUvaFBiaA+5AIslMVnnIaqArA8kpukg9YcR7DIfPgl0A=');
insert into app_user (id, user_name, email, password, role, salt) values (8,	'williiam',	'D5WTGPcyxsIvq6TmvOF9mg==',	'william@william',	2,	'NEPHqbHNmVXIYaFTE1uqzEHxcFOC5VJg7KOxy+Lrpe2ztLpwldirGsYLwNb9MhmAkUTdqy2MJNX6RYQSAqiZgrDfBft2TRncu1kVUuFMKN3cmSeiuYbgXsq2S09dsn3QQysIPM2+t6tnciwucml29uOw+ZegAiaJKB1wwAhH/D8=');
insert into app_user (id, user_name, email, password, role, salt) values (9,	'olivia',	'SDtcLFWDMCN+xVsMl1QNBQ==',	'olivia@olivia.com',	2,	'rfyTyAjUQeEiG7pUh+DQ1RBFJ5zwYteDmSciU3efi09U4WFEi29aG8EsLlmngxgBw74BiP4SNGFsfmNkGppU3gVG3rKDkFp7rhUdo27alk7UlmttrO0AG1/sU1Ya79opYjEJmElcCo/cikcjVNGGhlPYcRVo3ggmY8ZOU4/Sh2g=');
insert into app_user (id, user_name, email, password, role, salt) values (10,	'ava',	'pdykS3BbD+TaKkgJLbAD2g==',	'ava@ava.com',	2,	'MhhLZ6d0uXns9a2x1pvtpRugVbFSkj+xy/VEkQ/roTnEFrVaxiJW2SU8/S1cLlmHkyAOGpZcgn64MVPsyEK3VijPfgGpU5vGvGty0SXGHZkqfJUPXA3KZI8rhZ95uFP1tGoq/jlQgfiWjJzwBHqNJVxqKAVqX9lvYt5FnDOcTmY=');
insert into app_user (id, user_name, email, password, role, salt) values (11,	'ella',	'pitb+NntTYWpPTs7WC4OpQ==',	'ella@ella.com',	2,	'Q0eUCEHTpXSDxLMkMSFIvKPgV1AOQxMw7eesAvF9aDMFBgPRtYitO/1Q4Lu1EhcV0n/X6P+QSMYHqnMw5MTAmLtURgVXEVv61WkWJY5tzXfgNJyBJ0ARUooQHHcvo8vJDOtAApFfgG+xF7m9bLYaZkx0Zo63znCVILFa522IaRI=');
insert into app_user (id, user_name, email, password, role, salt) values (12,	'isabel',	'rO6UQkuLjkOi9ANT9zZ6oQ==',	'isabel@isabel.com',	2,	'IQdJeMAlnVRCTyqdjM60ydpYDEgp8MdQZTdwFxJQFJJkwjUtyLC8RBTpAJC/Ohz4IqockEaAIUVe/cL+Zk85GOZYmYnF2iD8N2la8oANMfVIEJxbvDYEtnnaCxP0oVHoX8+XLGuC1u2QmWMJjEph1bDz2rsmQnzYmwqO/DibuL0=');
insert into app_user (id, user_name, email, password, role, salt) values (13,	'sophia',	'drdOCBrQUT9vmOYg+sZnKA==',	'sophia@sophia',	2,	'XA9GPopbmtyQ69UDSvAQtWwNMMcrWngolFi2OPgXLKCgIjj4Lw/RvYA4plYjoTSEAjyr9KOeqxhexlI7JEyavnDaX4nHI+7zvAmTjULuqNXiaa1uGie6ANblaOfH5XNuOqRGxZ5tZISUwlI2NBXycV/DqLEc/BdE2pg+lZIFKqk=');
insert into app_user (id, user_name, email, password, role, salt) values (14,	'luna',	'38g6vmj50GC/wKzRC2N0lw==',	'luna@luna.com',	2,	'fBZ8NdxbnhJSuA3zzzjKpRdR6Cfaygoa5ovIDUi4GPvYfgaHtQFIq4GX8pP8x7KWZ9Y2YncXBnXjWrB7auvgymmPdeOFYsPDG2Yli1/f14rh5xADeCdF3wWcdLVHqV3aGOURQnE8IGRBOm9FSFrSj4TlYFab3WT1+LngansV6qU=');
insert into app_user (id, user_name, email, password, role, salt) values (15,	'lily',	'RAeasbDsY9O9yJ77PahylA==',	'lily@lily.com',	2,	'x0KjDaph2kBuGsIOmTf3eZGsoDjrUJKQLQeG/sDbmVLZ8H9sDWh3RyCKd3chQllnL9jUJcE+fKK6jTR4FhyovHjutB0dbsoBkyD5MYnHrMo4OjbHuBiWTzSXAX1il1Ig63iLgtMbwQJGOnfwb7p0jnB10utl1hM+Mc3Gq+SYntY=');
insert into app_user (id, user_name, email, password, role, salt) values (16,	'grace',	'd4xTgYZBzxb4MLFUjA77Pw==',	'grace@grace.com',	2,	'eVG22yuv8s8thv1PJGz282qr2quOkmGtlYn88ll6WLWNuMaebCXvcF/n5fFPAZsWcxzuskSTIC4ZiYYlv9mWH5oueWKtmA5UJ1z/6k0g1rK08SH891rAoW0eE29w7KIpbzF/Fexkw9/BzsqxkpqXYkb4oshMfqpg1vpRG6xEXmc=');
insert into app_user (id, user_name, email, password, role, salt) values (17,	'Mila',	'zwChdSPwWaw9BorU6VAbUg==',	'Mila@mila.com',	2,	'uCoMSeC6AVbplKFq8VTYLt+o5EldUY083Mk3TNbg+U0eoCDxMIoPW/jjQV1Yskp5LdO4+Rfaniofi41f3uXdFQJFOXuNSg0Ah1bMwLp7S07kBYvvPs6fXGpWOX+u6YkW2tZLeQpyEXpvqDTQBTX0yMf/whAwBTJ2JNwTHHCJLtE=');
insert into app_user (id, user_name, email, password, role, salt) values (18,	'Chloe',	'rqroruQM3yRIk8AjqDSD/A==',	'Chloe@chloe.com',	2,	'ew4J2C57rMMA5ToYP9Y+DrcWbu7bh5i9nh5pZ8jjy73TMA+q3eRHhByImouY2Kv4xjjh8XihS7KPipJXmXfUWgOurLQzRDd1ggAu8eXKspESHwtiNIOiLN8shnkY/5DRQc1sJ9yFE7CvNUB5V0l5dA9HqOlMW5ThNpIySK6Xnx8=');
insert into app_user (id, user_name, email, password, role, salt) values (19,	'layla',	'M1Ci6LL9ll2R1vxe3o1mXg==',	'Layla@layla.com',	2,	'ELXbl1tUJkF6HGuWUhZXFWqBs5QQK8IMzJWW4MtwU5fJX/iSAwTeNnMnVhxXKCDTN36VaK4JNAwwP9N3mu6SCVDHeYJoM6F5m9KMhOau5/IsZeYFmYVQO06xwJQNyEkBZR+RLlO2Fv0Woh2h3+wc0q58gZBSnsiAVY8UpYRIOiY=');
insert into app_user (id, user_name, email, password, role, salt) values (20,	'zoe',	'VQeQgLoxUvh/Me9lu2YQQg==',	'zoe@zoe.com',	2,	'Ie1UNYmJCfGdMcD/prsgbriNzTJzQgpXL35/YaYSgDCgsrF/W1gqCvGmNqYoxS8l8oQaCU6JZAHeF0SZHyirh2w4qTtg76JsnLKqJt7zmSVhjcQETMcv3wwFDECMs0FI6AiJsInJGxl04jMOXSqeIDquCvlUOYxOcRabkY1qx8Y=');
insert into app_user (id, user_name, email, password, role, salt) values (21,	'lucas',	'uCUtw07Ic3ffWgewpMEnFQ==',	'lucas@lucas.com',	1,	'q9jxd92VrUhzUrXrtmnaC3kZ2y5o+9DeXaZRy5S7JIoawWnmSQ5Ja9O94llkNaUcgqCuoveKHlZMCfgHH9w3G780yECiU6Bgo3ZdOlXj9ZldxAOuW3tDGEMB1xA8fueU+72XR5xvxobKj3UQSTZeVUc0XklBma2IDLfwnQaKiiQ=');
insert into app_user (id, user_name, email, password, role, salt) values (22,	'james',	'4pv+2x5eLPSKocVq176eZQ==',	'james@james.com',	1,	'j3SJtWdWH+zy5GOB9mmrMdhGVC4lzo+frDgkqIw5T3kWMVQt+UpS2voITHiboLTSqa+HN3L1RCwoDZNPWws1ueYjaxOatFPBPdLmrgT0G9PcbFm7uMZrgYf753o6wYNAAkwZxX+KFDFHX+bcGDfFf65NqUBtcn1EmdbRi4i8/6I=');
insert into app_user (id, user_name, email, password, role, salt) values (23,	'mia',	'hj3ZrN9yMGNQhiIaJbhcaQ==',	'mia@mia.com',	1,	'kxHgsp5L2qWQ/HCjBe8Fa4eY98579s7HhWxGTylO0HtZJokN6WBqXulJbGiAHajTmypByglOV8Bufj3gSkjPmMat2TJSNap/ofYfBZUHfHyOUBhETFhQCF058s9YlLe6uYP910bq8Vs8IQhIG22Yc57VpUvkF0j5afG4r7sMpZE=');
insert into app_user (id, user_name, email, password, role, salt) values (24,	'ethan',	'qy2vxLlS3Gb0vg14Zgablg==',	'ethan@ethan.com',	1,	'Qb7p60I1h6m17Tx1kVV/PGumpsP6vZx6RBRYBOW2h7Gl1pzefcupp34sNIzsRrIP/3LFfCDVnAZL0zXDNlvPAZoZhBN1EjpS0bzudRUaVuM5D1juBhIoi8b1+a1vosZW8UzWUO9TXdf287A9AN13JCcm9fMa0mU+N+4KurC9E4Y=');
insert into app_user (id, user_name, email, password, role, salt) values (25,	'sam',	'B9XMWnLjrCasHCNqOovyTg==',	'sam@sam.com',	1,	'FnrpP6t/xvQTwychJaFzRdUXIv40tVKerd4vb6Rbmmj7iqF00tpV+sJ/pEgQrORkZiV8ikFbRNmpDWOi4Cd5HSkc/lPm35mrnK5iyF3hoPCO3X+nKdTSGhFZFNlvGPd/2iMoRWn8CWhNvq+RxFPNN6peRjMyfgEUVxPh6eQq9sY=');
insert into app_user (id, user_name, email, password, role, salt) values (26,	'jack',	'b0VO5ldwUKKrwSjFhM/3sg==',	'jack@jack.com',	1,	'v69lMRcUhF9wom3I49t7Kzp4Z0KqCX2IsSIrEm8+pA05TSsV2WypBuxqsgrtbDhoFjDQCE4mpmQeZemo4+cdj6XU6mwVfyX2T4sgg3X+efJkzvwoRdxwrMFjD5b4sD2o7diwWhpzurg5L6PEAXa3bPxHuH/pMQHkmvcmy4+eKUI=');
insert into app_user (id, user_name, email, password, role, salt) values (27,	'dave',	'R8jTTwMBBPbDunEFKsZ1sA==',	'dave@dave.com',	1,	'Q1wtrzuN9LJ9HNSjWiW/YyNFNXxiUAwdPHhVQlYafRm3UdePUHdtC/J1S06QMsxUEgwUSQjvw0izS06tuucw3xpftZe/VhjHJ/yz6GpzVbpBJ6EVPkppnQ6d/wbnV445KZfxlS92Id5v5ETngvh+O+cNeAnVCIjQ75NHxy3WhaI=');
insert into app_user (id, user_name, email, password, role, salt) values (28,	'john',	'UMErrIR9HZwurmAUpyyBGg==',	'john@john.com',	1,	'ySfomxISgxj85FMmoyMlLTi31z/s+nLNaF3atcnOE+8T1vlxv9u0tX9WpPLryXak+pL9Tl1JGnZMfGH9Y/DwwsXTg12St6oP61iYtW/WNk1KdEp59dhqBqzMi18JLkhHc4Mv/vrCzT7n6+mCCMEKAvHGhnc+0hdQ4wpgZflu5qI=');
insert into app_user (id, user_name, email, password, role, salt) values (29,	'oliver',	'+wLzp4FynGBLxPRJGWWasg==',	'oliver@oliver.com',	1,	'BQ1aqBNPjiYJ8ogO537AXB96npMdh7BUWb+ejsj43ERSQwbidd0KmU58UgVxUnyiY1xAJH0WWlowNpQzqv3LtrEKBA+Go2tEkWdduxSk9N5rYk9Cdd9bzN6PlHl1SwZK0HMelorSjbLVCnM332PaxvT2T9pWdsLb5kp9f8fCXno=');
insert into app_user (id, user_name, email, password, role, salt) values (30,	'mason',	'aBPv5bEjyMQCgtH8+1fHEg==',	'mason@mason.com',	1,	'm8w3LUPceHoIEYkIlfr02lDn95E9qqKb7ITGb2qUR81fMrx447CKwq44AYm42x6zYD5mvpX3daO+kyv/ViKmiLAaFjy4vM45zhaflM0ASXoTg9eHOcFEpJmVWRAGfO+kGqSutySKJPXoAFO/GMwb9RZNDOKkPNtaMaagIra/yaI=');
insert into app_user (id, user_name, email, password, role, salt) values (31,	'amelia',	'tI1mTIQqXXOWtRu4w52umA==',	'amelia@amelia.com',	1,	'lHwswu0j/3FsqHUitzQBq/WlrDhNMMCKjLaeaDuD5nrbgubVxdNdwZg5nC+MFPOkbnJCvd5F32n3JcEd5R5dl2Iao1kv22GDDCbqM2mP98n4IO9rLbvBQz9RLHpBL/oLv0Jq8CsT6aC3l1lIp8A2iLojcY532wYVmYM6eCc50xE=');
insert into app_user (id, user_name, email, password, role, salt) values (32,	'chuck',	'gtrdTe5rw0XML8cpXbWqWg==',	'chuck@chuck.com',	1,	'b8oaw3Eh/l6Hl1A6UMZf0SW0P+FXFvTVsSGkH5SeCv+q59LsLfLyR4+F1V4QGYpxxE7YlfNSnwIMRnDsTq9toUMaNcjsBwxliSPkNuxOY8bPFMQLKUj99Zx9CQOUoDLR9Q2zeTtcRMmesz1Wn/OxWmPzYhRwKOqqw19PRlJxxpw=');
insert into app_user (id, user_name, email, password, role, salt) values (33,	'nora',	't8LDPGleoe52LSp56v+QCQ==',	'nora@nora.com',	1,	'Lh1W00mtels4XfLG6s8gBU4kSeT3lx69LSjd89RcgbPB38F/ztAtc/P2VF1dLl+fRC/Ggy+K+5aSL1os8rlz7lBtSVJ2GaS6QfLpnG1AfWJfzVMOiI+/XGxNSTSzFgD2tTxAOgc/Dmz2GPn6/GsETw8HBo6FMuhb5T0PG1PDKc0=');
insert into app_user (id, user_name, email, password, role, salt) values (34,	'hannah',	'jP0JxEcjzAOKaWfoanIeDw==',	'hannah@hannah.com',	1,	'wapaXwJdo1SWhXD9PGknuRFhKocGnPIugWS/NrWSPR0gUEmkUfLUb9ipibz03HzTZSkDZ7B1/p8tzrgad0QjkKMaCTvjkGOzr44IBXkJhc7nTp2tNwD52N1OAYDZA2NwP8Pri+secn3zXiYFEjCuuniVLi1KOGlGx1NnywoodSg=');
insert into app_user (id, user_name, email, password, role, salt) values (35,	'henry',	'mSE73elp0TrAoD6CtaAIKQ==',	'henry@henry.com',	1,	'5hVMArHxXifbetRN/uw//eXZzSzV6u06xyZYBGVxGTF7ipzpPl6RqoSWEAovrm2I5jTmaP+yfDBhgAVlLGvv2NNvpOO5PTLwrioW5N/70IXWzPJxx0HIhIobwSRhV4gil6JXH1fdaTty+rdfgl03ypDqK8EK3w35DS1pKQ2dImI=');
insert into app_user (id, user_name, email, password, role, salt) values (36,	'zoe',	'BmykHQd2UcxzMMQzF6Rgiw==',	'zoe@zoe.com',	1,	'chOVVhCFy5/SEqY6lhORNzVueu+xKDiqZklMd27K6ZOo/YkQ/dqjpa52aBqBFARhXnEAk0xEsCI5Wu9SkfZTya2Rca2rmjQjAaqdK8GGAH3zI3UiDjWNOMw+5nJHh7WKipd7vXX/Fxcqce7TvL9+CzVbxOZjGYrKkV1An1wYdkk=');
insert into app_user (id, user_name, email, password, role, salt) values (37,	'ben',	'8QzLt2C+WmoklhmPaYJpZg==',	'ben@ben.com',	1,	'84ua7VFvzybGcVQ/c3aotfoM06QIndnxQ8n5NiZ4/1ARmWGWndeHBKspBc1As/OL1cokmu8DhOLz+JShlV0SrA9e0XqKTtZx41hs1YY/T0zSQBHyEAbSlaDCD1HJT0CTscTowwQmvkRk22TPiHuvvUfYlJ+rMQq6nJHjIXgyLR8=');
insert into app_user (id, user_name, email, password, role, salt) values (38,	'logan',	'iZQgP7oG8H4i8qw/QioOPA==',	'logan@logan.com',	1,	'cH2u+BbRKgPyJ4og5HZRl4Lxddr5N5ReocnYXB6OpmqeqDqeX/8NXqfsdGHwMeHbwaogJrSZQyLWTPBHfw7M0T5SH+XFZ1SU7bMtoXdna3XMJFO78mpFZ3VgK76fbKNDdGxLWbzWMcr7GGllNSCAKzdRKdfKmkcXzYLTHod8WVA=');
insert into app_user (id, user_name, email, password, role, salt) values (39,	'harper',	'bAbNOMp8p5bMzoHHVKoDwQ==',	'harper@harper.com',	1,	'9jtl5XnwLg/BVhsa2CLQgUZtsYfc5Xc5q+L0LESHbjy6BeeT3lLUg+otQyT5rC21pY8M4ve3TWwb9quVdDGYmKKYhIfjv1xrKh8ypS8IaWYgfcPCvE7W7db69ofYHBcFYTlY/mcfZ4FJxQklrNkmLrHduslhnz1SeAJGWelCQ5Y=');
insert into app_user (id, user_name, email, password, role, salt) values (40,	'charles',	'gkUWYZHbot2HHel/xYqTeA==',	'charles@charles.com',	1,	'cE54MoicQ5WDwmfL4eWZ45qmV2j0JP5Urcu+ZzL5N/yJXVdGDC0gxMu0mHL71w767Gvq8XSqTX+nn7/FR0PHc5WILytDOXehnhzmeJ4Gx/igYJfR3fSmFXSAC+GD5QbTnYtDdlEPX+5O8dZEPzrtZikQIZdYObK3RUBj/Pap9lc=');
insert into app_user (id, user_name, email, password, role, salt) values (41,	'owen',	'fRecA/TdhkPN+kQd2nMVAQ==',	'owen@owen.com',	1,	'pLTFUA6u2939h8IQZLR4xwEF2xBXUvwRD3cAnNEA4x9ptZTY5mZFKkxhkkoBenRCAwwN+PA7yCeDag0eZryTqRfVhn9LgOr4dIIC69N8hS8oZcZcIttJD0Ge4qyEHee0T1Xjn1mQkZzWU5e/R3idiqVX4gy3lVqUt3/z8CZUvgo=');
insert into app_user (id, user_name, email, password, role, salt) values (42,	'luke',	'8GOj3MIlmNiwTPqlQMhrRw==',	'luke@luke.com',	1,	'0E6bYx+kejZUNVXM6bU3VD6Ra4kUPsqB+2+1xjpbQLOsLWA759SZ0je+YeZlZSocGcIVHduYCrvNQtG69C6HF4PgV8w8bvkoyk1svXu/u08vMW0hzL9GrxDwRQmt93Omca9kbP6MaBt5syyNq9jvl3eKwV65vyo+uRIx+RgjkVE=');
insert into app_user (id, user_name, email, password, role, salt) values (43,	'amy',	'7rBr2FGuWbKidJkM/ltsYQ==',	'amy@amy.com',	1,	'/hkMIw9DwH6XJbyasSz0gQyfY2+K4pLOkPjHhTx82TFipNsZpcT14zyevrgdO3epsqkENydgiMaTCjKcDURNaH0Ne61Q+LJuNWjeE4RrQmiewgVEw1qqf5sl+3yv0Z0yNYyW560LG8W0SK9qxaXEVyEvc5TrlN33tDr/MUwgUCg=');
insert into app_user (id, user_name, email, password, role, salt) values (44,	'leah',	'dsDhO83LK19p3B5m8VT8dg==',	'leah@leah.com',	1,	'YoUVCNrMgzP1QR11hpVLIWhpLVi2CMnM+AwWiz4W1Ru/b5ItFwYJv6VCPiPC7NCYdeVwqcAZJiaT95G7dDhSjO8UTwdjTZNRO58dIw95r0NQCoZL6lT5HpjuvzW9sv61RMAbEY67xAOIkdsTg4Toae5e18kt0SdT3FEkxeNmSSY=');
insert into app_user (id, user_name, email, password, role, salt) values (45,	'eli',	'YSDHtraOeOGMYaEcgsQDmQ==',	'eli@eli.com',	1,	'qz93CTaB7nthsTEdO06io4JyGsMDSI2tEJVKvHQM/eSaubxjRhw4edKAgc5oJlTWqnZGkQsHQeA8nSW1bYwxy/s2mL57c5rh4ND64GAUap1PUc5pOJz3eAdWur2gyg75kzMguPYzbFb8cjbs+oGi7bgw/3+1Ok04Rpxe/q0AoD4=');
insert into app_user (id, user_name, email, password, role, salt) values (46,	'emma',	'XXxQ6bmGMTVHG0pC8m58hw==',	'emma@emma.com',	1,	'oDdbUk2Q/SqHra7DW+00DOfL+IJz6wBBXm2Ynf9DX7bONCO5qYOmtJBgtRm5R+R8KZ+0C3P4OIiJQU14EdcH+3Ff0h+4BhYv6E61q7fapPngoN/NrQYfs5+uRYbwSAMJZ677RqBOgeIXJy2IU+8PTeVcr5pUxmC8tkM1TZAn0YA=');
insert into app_user (id, user_name, email, password, role, salt) values (47,	'eve',	'A91RYWwKGzP89Ty6tIjj1w==',	'eve@eve.com',	1,	'hi1BrX6+cXmC//bzs51K5npuxHAIsozrwFGq9WD8O8MbhO6mFqWlGggSZSoMxGzBWmyp/E0QcZfi+ktp//KpNFqLVm51W9ceNctciWOGrfVIubaSwqzF9tAzht3FTPjco+3NlarktQbnNGdlb7y36a+lnqf1EYL1xSlA3md8ASg=');
insert into app_user (id, user_name, email, password, role, salt) values (48,	'atlas',	'/p74aPIIA7752UMktSAJ3Q==',	'atlas@atlas.com',	1,	'TRnqy+Bzpjof5c5AisVwDS1b6u7u1kcSXcod6S34uZdhki6UsOh9Y6JSQtccJCTkBs8/3ByHytoO4fE0HMcM3LCxUiwHPU5Ddg+aVSBHVmUn+vnhx9Frhk/OVm53Gl/zRTczRN/bhvs47U+m07njWzcty6kqlMwQGv4JoAoVTLU=');
insert into app_user (id, user_name, email, password, role, salt) values (49,	'wyatt',	'UQZ4gQj3zg73pTPRyWuwCQ==',	'wyatt@wyatt.com',	1,	'pN4fuQTI0wrWA1qVr9IJE9GcgMKow9o4ib+LA7PeG6t/mg6Yx8TfwKlt0kSqLcAmoOka1IR39yhKsorzpaggkJQcNNlvh84VLIU6Yv1ZlQ4JoQrWy3f32zesVSjAuEuDH0y2pbWuQR5TwnPtnJQEaN58xDENXHP/69amNlvlRJY=');
insert into app_user (id, user_name, email, password, role, salt) values (50,	'levi',	'Qyk5CO2P/TVxGLuq+JDBeA==',	'levi@levi.com',	1,	'N79dF+DXe9L7Zphd0YV9poOK6lPTyC/uwt471lIKXYR9G9XSLKwqAnIvPqtrb6SsogWqjW3a4RnUmXeqSCDvaih8QPF9WS0jIoZ7lisz5EL7KL0dDXucA7znUXaGRPe/FfiqpfnmtOUr86MCqOLoCRMLq3A2dvpaIx/dwUkNeeU=');
insert into app_user (id, user_name, email, password, role, salt) values (51,	'deb',	'J9j7YQznDfBwitR9QZzJag==',	'deb@deb.com',	1,	'c3CpkxZ9JsaeQxqLNlePvAL4mJUx500hShKoJMWNOGN2VltTuJi07HZYqAypYgaMtf0GmwVNzStZNuPmaUze4m6pTgVRm15bENmtaN46Z9zCS+kGV+Z8D4ORa8ZPD54vnQqtQNkZzsED5rtq2K8ep4XGb5QFrGqHAXxj6IvWdck=');
insert into app_user (id, user_name, email, password, role, salt) values (52,	'hazel',	'nrdRiX2p7FFVV/UVtxunTg==',	'hazel@hazel.com',	1,	'jAe1Atx7oAXB3RhIYzHC9YeGUrLk0jZ2/imon0OQlcjMvJxi1Xmq3g8yeky7KFyk0NWvZeDikWes5Ctn+TBxhaHBe/MjAE8FaCQMXLdaxAjOz2mCIlHgmWgSNHTSF8ZaA793OkTx8/nvgN5QEkKTDCiX7Rx/YwLrJA23DstzjCc=');
insert into app_user (id, user_name, email, password, role, salt) values (53,	'gina', 'ljqk7dBaMyuN2jEZlOLVNw==',	'gina@gina.com',	1,	'JMJZGLm6gJoBcz0u65LlqbvZ3k8PB3ofrWJjlEu6lSaNwySjFYCsAYh4adYStttZepHmHelfGdc3E9AQ9UXZuljT08mTt1YDlQ0EXsOR9rA7jxk8W1Y7pAdQ0RTkAWaFI2IAbmPo/TOmhM6w7UyXqavijCP4hnOT5XNAcL+KtVI=');
insert into app_user (id, user_name, email, password, role, salt) values (54,	'craig',	'f/HOHh/MXZk517E+/RJZsg==',	'craig@craig.com',	1,	'9nssz62P6eoy9p49GMP/rNzEGr0B+ZDnRe0ihZlLN+Z9bzRpfPmHkyPO/37h79BjmvxlUXPqUaUyqDtzaUrIWfvWyvFlOXMEmp0HxStHeiwJgV/5S36xi8DQkDwUkMsMaIBLanZvRnzuJTPKLvaPlRVizBHVg+XMBIBeCOishZQ=');
insert into app_user (id, user_name, email, password, role, salt) values (55,	'Mike',	'eFNOZ+JqkMYzg/TSwY/lWQ==',	'mike@mike.com',	1,	'v1Jrf+PJu0drZK0uelZEZ8Bv83W13V5AI/8MmVlFvwP8q3x1Xkpyy3285gPUNcInjEComfeBjr6mznMG4tipBUxmHTm0dUmAhBPv9uZfHeKiuoowIL3fkJr5deuwzcN1y3tdfd7esjgyPvY8XWzdjUDmp4+wy/xZou8P83Q8n9I=');
insert into app_user (id, user_name, email, password, role, salt) values (56,	'megan',	'us20stX5Y3feXio4JYg0xQ==',	'megan@megan',	1,	'4x3OWGoG3h40IfQiLQngdLDiuj40aY22CY1PLprNhPo2AlMT89ueQk/Xk12KUjHJF9EX53yo6oYDnqY+XaKofrMAYkRqDXeFEhrYUdrUCWT87TKpuPLgX0W0/3Hd+lPFMStdoMObafG3wcpVhFhv6WfyMplb8N4QiS0nFS68sek=');



insert into team (team_id, team_name, captain_id) values (1,	'Insurgents',	16);
insert into team (team_id, team_name, captain_id) values (2,	'Avengers',	5);
insert into team (team_id, team_name, captain_id) values (3,	'DeathWish',	9);
insert into team (team_id, team_name, captain_id) values (4,	'Butchers',	6);
insert into team (team_id, team_name, captain_id) values (5,	'Defenders',	10);
insert into team (team_id, team_name, captain_id) values (6,	'Enforcers',	15);
insert into team (team_id, team_name, captain_id) values (7,	'Mean Machine',	17);
insert into team (team_id, team_name, captain_id) values (8,	'Mud Dogs',	18);
insert into team (team_id, team_name, captain_id) values (9,	'Death to BigDecimal',	7);
insert into team (team_id, team_name, captain_id) values (10,	'Dominators',	12);
insert into team (team_id, team_name, captain_id) values (11,	'Jaw Breakers',	11);
insert into team (team_id, team_name, captain_id) values (12,	'No Fear', 9);
insert into team (team_id, team_name, captain_id) values (13,	'Chargers',	8);
insert into team (team_id, team_name, captain_id) values (14,	'Dropping  Bombs',	13);
insert into team (team_id, team_name, captain_id) values (15,	'Endgame',	14);
insert into team (team_id, team_name, captain_id) values (16,	'Savages',	20);




insert into tournament (tournament_id, tournament_name, organizer_id, date, location, game, tournament_type, description) values (1,	'Tetris Tourney',	1,	'2020-04-17',	'160 E Pearson St, Chicago, IL 60611',	'Tetris',	'single',	'Format: /nTetris to the death/n/nRules:/nWinner beheads loser/n/nPrizes:/n	<h4>Format</h4> <p>Tetris to the death</p></div></div> <div class="tournamentRules"> <h2>Rules</h2><p>Winner beheads loser</p><div class="tournamentPrizes"> <h2>Prizes</h2><p>You get to keep your head and the simple joy of knowing your the winner (with your head)</p></div>');
insert into tournament (tournament_id, tournament_name, organizer_id, date, location, game, tournament_type, description) values (2,	'Jousting Tourney',	2,	'2020-05-17',	'1 Miramontes Point Road Half Moon Bay, California 94019 United States',	'Jousting',	'single',	'Format: /nSingle elimination fight to the death/n/nRules:/nWinner keeps the horse/n/nPrizes:/n	<h4>Format</h4> <p>Single elimination fight to the death</p></div></div> <div class="tournamentRules"> <h2>Rules</h2><p>Winner keeps the horse</p><div class="tournamentPrizes"> <h2>Prizes</h2><p>Horses yo...</p></div>');
insert into tournament (tournament_id, tournament_name, organizer_id, date, location, game, tournament_type, description) values (3,	'Warcraft Tourney',  3,	'2020-06-01',	'10 Avery Street Boston, MA 02111 United States',	'Warcraft',	'single',	'Format: /nSingle elimination Warcraft for real/n/nRules:/nThere"s only one rule - win/n/nPrizes:/n	<h4>Format</h4> <p>Single elimination Warcraft for real</p></div></div> <div class="tournamentRules"> <h2>Rules</h2><p>There"s only one rule - win</p><div class="tournamentPrizes"> <h2>Prizes</h2><p>The satisfaction of vanquishing your buddies medieval style - bring your axes</p></div>');
insert into tournament (tournament_id, tournament_name, organizer_id, date, location, game, tournament_type, description) values (4,	'Dungeons and Dragons',	4,	'2020-07-01',	'100 Carondelet Plaza St. Louis, MO 63105 United States',	'Dungeons and Dragons',	'single',	'Format: /nSingle elimination/n/nRules:/nWin or buy the beer for the winner/n/nPrizes:/n	<h4>Format</h4> <p>Single elimination</p></div></div> <div class="tournamentRules"> <h2>Rules</h2><p>Win or buy the beer for the winner</p><div class="tournamentPrizes"> <h2>Prizes</h2><p>The joy of free beer.</p></div>');





insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (1,	1,	1,	6,	3,	'Pod 3',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (2,	1,	1,	2,	1,	'Pod 1',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (3,	2,	1,	8,	7,	'Pod 3',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (4,	2,	1,	5,	4,	'Pod 1',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (5,	3,	1,	12,	11,	'Pod 3',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (6,	3,	1,	10,	9,	'Pod 1',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (7,	4,	1,	16,	15,	'Pod 3',	'1066-02-02',	'8:00',	0,	0);
insert into match_up (match_up_id, tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (8,	4,	1,	14,	13,	'Pod 1',	'1066-02-02',	'8:00',	0,	0);



/*
insert into player (player_id, team_id, ranking, points_scored) values (18, 12, 7, 108);
*/





insert into team_tournament (tournament_id, team_id) values (1,	1);
insert into team_tournament (tournament_id, team_id) values (1,	2);
insert into team_tournament (tournament_id, team_id) values (1,	3);
insert into team_tournament (tournament_id, team_id) values (2,	4);
insert into team_tournament (tournament_id, team_id) values (2,	5);
insert into team_tournament (tournament_id, team_id) values (1,	6);
insert into team_tournament (tournament_id, team_id) values (2,	7);
insert into team_tournament (tournament_id, team_id) values (2,	8);
insert into team_tournament (tournament_id, team_id) values (3,	9);
insert into team_tournament (tournament_id, team_id) values (3,	10);
insert into team_tournament (tournament_id, team_id) values (3,	11);
insert into team_tournament (tournament_id, team_id) values (3,	12);
insert into team_tournament (tournament_id, team_id) values (4,	13);
insert into team_tournament (tournament_id, team_id) values (4,	14);
insert into team_tournament (tournament_id, team_id) values (4,	15);
insert into team_tournament (tournament_id, team_id) values (4,	16);


UPDATE tournament 
SET tagged_desc = '<h2>Tournament Details</h2>

			<h4>Where</h4>
			<p>The Internets</p>
			<h4>When</h4>
			<p>The Day before tomorrow</p>
			<h4>Format</h4>
			<p>Single Elimination 1v1, 3 Stock, No items</p>

		</div>
		<div class="tournamentRules">
			<h2>Rules</h2>
			<!--  for each to display rules? -->
			<ul>
				<li>Don not talk about fight club</li>
				<li>Don not. Talk. About. Fight Club.</li>
				<li>No smoking</li>
				<li>You have to shower and wear deodorant</li>
			</ul>
		</div>
		<div class="tournamentPrizes">
			<h2>Prizes</h2>

			<ol>
				<li>Bragging rights, maybe some money</li>
				<li>You didnt get third</li>
				<li>You placed, so thats something</li>
				<li>Fourth place huh...</li>
			</ol>
		</div>
		<div class="tournamentSchedule">
			<h2>Schedule</h2>'
WHERE tournament_id = 1;
commit;

