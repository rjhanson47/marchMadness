/****************************************************************************************
 *                                                                                      *
 *                            @author Jin and Robert                                    *
 *                                                                                      *
 ****************************************************************************************/
 
 dist folder contains marchMadness.zip
 unzip the file
 
 to run marchMadness.zip
 1. open cmd
 2. cd to directory had marchMadness.jar
 3. to run "java -jar marchMadness.jar"
 
 
 Algorithm:
 
 Formula =(MatchupHistory)+(SeasonStatsvsOpponentSeasonStats)+(StrengthOfSchedule)+(TeamRank)

Matchup History: 
-	Search through the last 3 seasons for the games between the two teams
-	Scoring:
o	Each of the last 3 seasons will be weighted for relevance: 
	2016 Season Matchup: .8/win
	2015 Season Matchup: .6/win
	2014 Season Mathcup: .3/win


SeasonStatsvsOpponentSeasonStats 

-	Create a Win games Table, Loss games Table, and a Total games Table. 
-	Collect the total stats between Wins and Losses
-	Compare the following total stats between each team:
o	Total Average Rebound Differential per game
o	Total Average Turnover Differential per game
o	Total Average Score per game
o	Total Average Steals per game
-	Scoring
o	+1 to the score for each stat higher than the opponent’s stat.
o	Best score = +4
o	Worst score = 0 

Win Table: (Do the same for Lose Table)
•	WOR 
•	WDR
•	WSTL
•	WTO
•	WScore
•	WORDIF = (WOR – LDR)
•	WDRDIF = (WDR – LOR)
•	WTRDIF = (WOR – LDR) + (WDR – LOR)
•	AvgWOR = (2016SeasonTotalWOR/# of Games)
•	AvgWDR = (2016Season TotalWDR/# of Games)
•	AvgWSTL = (2016Season TotalWSTL/# of Games)
•	AvgWTO = (2016Season TotalWTO/# of Games)
•	AvgWScore = (2016Season TotalWScore/#Games)
•	AvgWORDIF = (2016SeastonTotalWORDIF/#Games)
•	AvgWDRDIF = (2016SeastonTotalWDRDIF/#Games)
•	AvgWTRDIF = (2016SeastonTotalWTRDIF/#Games)


Loss Table: 
•	LOR
•	LDR
•	LSTL
•	LTO
•	LScore
•	LOR - WDR
•	LDR – WOR
•	AvgLOR
•	AvgLDR
•	AvgLSTL
•	AvgLTO
•	AvgLScore
•	Avg(LOR – WDR)
•	Avg(LDR – WOR)


Total Table: (Total Win and Lose Table) 

•	Total Win Table and Loss Table Statistics



StrengthOfSchedule2016Season
-	Take the rankings (tournament seed) of the opponent for each game in the 2016 season
-	Convert the rankings to points
o	1 seed = 16 points
o	2 seed = 15 points
o	……..
o	16 seed = 1 point
o	No seed = 0 points
-	Scoring: 
o	Sum the opponents total points for the 2016 season 
o	Normalize the points using the following equation:
	normalized nx = x- min(x) / max(x) - min(x)

o	Score = 0-1 points depending on Strength of schedule.


Team Rank
-	Take the rank of the team (tournament seed) 
-	Convert the rankings to points
o	1 seed = 16 points
o	2 seed = 15 points
o	……..
o	16 seed = 1 point
o	No seed = 0 points
-	Scoring: 
o	Normalize the points using the following equation: 
	normalized nx = x- min(x) / max(x) - min(x)
o	Score = 0-1 depending on rank
o	Take the rank and multiply it by .5 
o	This will weight the ranks lower. 


outputs:

Connection to SQLite has been established.
jdbc:sqlite:db/marchMadness.db
east region round 1: Team [teamId=1437, teamName=Villanova]
east region round 1: Team [teamId=1458, teamName=Wisconsin]
east region round 1: Team [teamId=1438, teamName=Virginia]
east region round 1: Team [teamId=1196, teamName=Florida]
east region round 1: Team [teamId=1374, teamName=SMU]
east region round 1: Team [teamId=1124, teamName=Baylor]
east region round 1: Team [teamId=1266, teamName=Marquette]
east region round 1: Team [teamId=1181, teamName=Duke]
east region round 2: Team [teamId=1437, teamName=Villanova]
east region round 2: Team [teamId=1438, teamName=Virginia]
east region round 2: Team [teamId=1124, teamName=Baylor]
east region round 2: Team [teamId=1181, teamName=Duke]
east region round 3: Team [teamId=1438, teamName=Virginia]
east region round 3: Team [teamId=1181, teamName=Duke]
east region final: Team [teamId=1181, teamName=Duke]
west region round 1: Team [teamId=1211, teamName=Gonzaga]
west region round 1: Team [teamId=1321, teamName=Northwestern]
west region round 1: Team [teamId=1323, teamName=Notre Dame]
west region round 1: Team [teamId=1452, teamName=West Virginia]
west region round 1: Team [teamId=1462, teamName=Xavier]
west region round 1: Team [teamId=1199, teamName=Florida St]
west region round 1: Team [teamId=1388, teamName=St Mary's CA]
west region round 1: Team [teamId=1112, teamName=Arizona]
west region round 2: Team [teamId=1211, teamName=Gonzaga]
west region round 2: Team [teamId=1452, teamName=West Virginia]
west region round 2: Team [teamId=1199, teamName=Florida St]
west region round 2: Team [teamId=1112, teamName=Arizona]
west region round 3: Team [teamId=1211, teamName=Gonzaga]
west region round 3: Team [teamId=1112, teamName=Arizona]
west region final: Team [teamId=1112, teamName=Arizona]
midwest region round 1: Team [teamId=1242, teamName=Kansas]
midwest region round 1: Team [teamId=1274, teamName=Miami FL]
midwest region round 1: Team [teamId=1235, teamName=Iowa St]
midwest region round 1: Team [teamId=1345, teamName=Purdue]
midwest region round 1: Team [teamId=1166, teamName=Creighton]
midwest region round 1: Team [teamId=1332, teamName=Oregon]
midwest region round 1: Team [teamId=1276, teamName=Michigan]
midwest region round 1: Team [teamId=1257, teamName=Louisville]
midwest region round 2: Team [teamId=1242, teamName=Kansas]
midwest region round 2: Team [teamId=1345, teamName=Purdue]
midwest region round 2: Team [teamId=1332, teamName=Oregon]
midwest region round 2: Team [teamId=1257, teamName=Louisville]
midwest region round 3: Team [teamId=1242, teamName=Kansas]
midwest region round 3: Team [teamId=1257, teamName=Louisville]
midwest region final: Team [teamId=1242, teamName=Kansas]
south region round 1: Team [teamId=1314, teamName=North Carolina]
south region round 1: Team [teamId=1371, teamName=Seton Hall]
south region round 1: Team [teamId=1278, teamName=Minnesota]
south region round 1: Team [teamId=1139, teamName=Butler]
south region round 1: Team [teamId=1153, teamName=Cincinnati]
south region round 1: Team [teamId=1417, teamName=UCLA]
south region round 1: Team [teamId=1173, teamName=Dayton]
south region round 1: Team [teamId=1246, teamName=Kentucky]
south region round 2: Team [teamId=1314, teamName=North Carolina]
south region round 2: Team [teamId=1139, teamName=Butler]
south region round 2: Team [teamId=1417, teamName=UCLA]
south region round 2: Team [teamId=1246, teamName=Kentucky]
south region round 3: Team [teamId=1139, teamName=Butler]
south region round 3: Team [teamId=1246, teamName=Kentucky]
south region final: Team [teamId=1139, teamName=Butler]
east and west final: Team [teamId=1112, teamName=Arizona]
midwest and sound final: Team [teamId=1242, teamName=Kansas]
NACC champion: Team [teamId=1242, teamName=Kansas]


