package marchMadness;

import java.util.Map;

import marchMadness.db.RankPoints;
import marchMadness.db.SqliteConnection;
import marchMadness.db.Team;


/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class App {

	public static void main(String[] args) {
		
		SqliteConnection connection = new SqliteConnection("db/marchMadness.db");
		System.out.println(connection);
		
		Map<String, RankPoints> map = connection.getAllTeamsRankPoint();
		
		//east region
		Team eTeam1 = connection.getTeamById("1437");
		Team eTeam16 = connection.getTeamById("1291");
		
		Team eTeam8 = connection.getTeamById("1458");
		Team eTeam9 = connection.getTeamById("1439");
		
		Team eTeam5 = connection.getTeamById("1438");
		Team eTeam12 = connection.getTeamById("1423");
		
		Team eTeam4 = connection.getTeamById("1196");
		Team eTeam13 = connection.getTeamById("1190");
		
		Team eTeam6 = connection.getTeamById("1374");
		Team eTeam11 = connection.getTeamById("1425");
		
		Team eTeam3 = connection.getTeamById("1124");
		Team eTeam14 = connection.getTeamById("1308");
		
		Team eTeam7 = connection.getTeamById("1376");
		Team eTeam10 = connection.getTeamById("1266");
		
		Team eTeam2 = connection.getTeamById("1181");
		Team eTeam15 = connection.getTeamById("1407");
		
		//round 1
		Game egame1 = new Game(1, eTeam1, eTeam16, 2016, map);
		System.out.println("east region round 1: " + egame1.winnerTeam());
		Game egame2 = new Game(1, eTeam8, eTeam9, 2016, map);
		System.out.println("east region round 1: " + egame2.winnerTeam());
		Game egame3 = new Game(1, eTeam5, eTeam12, 2016, map);
		System.out.println("east region round 1: " + egame3.winnerTeam());
		Game egame4 = new Game(1, eTeam4, eTeam13, 2016, map);
		System.out.println("east region round 1: " + egame4.winnerTeam());
		Game egame5 = new Game(1, eTeam6, eTeam11, 2016, map);
		System.out.println("east region round 1: " + egame5.winnerTeam());
		Game egame6 = new Game(1, eTeam3, eTeam14, 2016, map);
		System.out.println("east region round 1: " + egame6.winnerTeam());
		Game egame7 = new Game(1, eTeam7, eTeam10, 2016, map);
		System.out.println("east region round 1: " + egame7.winnerTeam());
		Game egame8 = new Game(1, eTeam2, eTeam15, 2016, map);
		System.out.println("east region round 1: " + egame8.winnerTeam());
		
		//round 2
		Game eRound2_1 = new Game(2, egame1.winnerTeam(), egame2.winnerTeam(), 2016, map);
		System.out.println("east region round 2: " + eRound2_1.winnerTeam());
		Game eRound2_2 = new Game(2, egame3.winnerTeam(), egame4.winnerTeam(), 2016, map);
		System.out.println("east region round 2: " + eRound2_2.winnerTeam());
		Game eRound2_3 = new Game(2, egame5.winnerTeam(), egame6.winnerTeam(), 2016, map);
		System.out.println("east region round 2: " + eRound2_3.winnerTeam());
		Game eRound2_4 = new Game(2, egame7.winnerTeam(), egame8.winnerTeam(), 2016, map);
		System.out.println("east region round 2: " + eRound2_4.winnerTeam());
		
		//round 3
		Game eRound3_1 = new Game(3, eRound2_1.winnerTeam(), eRound2_2.winnerTeam(), 2016, map);
		System.out.println("east region round 3: " + eRound3_1.winnerTeam());
		Game eRound3_2 = new Game(3, eRound2_3.winnerTeam(), eRound2_4.winnerTeam(), 2016, map);
		System.out.println("east region round 3: " + eRound3_2.winnerTeam());
		
		//round 4
		Game eRound4 = new Game(4, eRound3_1.winnerTeam(), eRound3_2.winnerTeam(), 2016, map);
		System.out.println("east region final: " + eRound4.winnerTeam());
		
		
		
		//West region
		Team wTeam1 = connection.getTeamById("1211");
		Team wTeam16 = connection.getTeamById("1355");
		
		Team wTeam8 = connection.getTeamById("1321");
		Team wTeam9 = connection.getTeamById("1435");
		
		Team wTeam5 = connection.getTeamById("1323");
		Team wTeam12 = connection.getTeamById("1343");
		
		Team wTeam4 = connection.getTeamById("1452");
		Team wTeam13 = connection.getTeamById("1137");
		
		Team wTeam6 = connection.getTeamById("1267");
		Team wTeam11 = connection.getTeamById("1462");
		
		Team wTeam3 = connection.getTeamById("1199");
		Team wTeam14 = connection.getTeamById("1195");
		
		Team wTeam7 = connection.getTeamById("1388");
		Team wTeam10 = connection.getTeamById("1433");
		
		Team wTeam2 = connection.getTeamById("1112");
		Team wTeam15 = connection.getTeamById("1315");
		
		//round 1
		Game wgame1 = new Game(1, wTeam1, wTeam16, 2016, map);
		System.out.println("west region round 1: " + wgame1.winnerTeam());
		Game wgame2 = new Game(1, wTeam8, wTeam9, 2016, map);
		System.out.println("west region round 1: " + wgame2.winnerTeam());
		Game wgame3 = new Game(1, wTeam5, wTeam12, 2016, map);
		System.out.println("west region round 1: " + wgame3.winnerTeam());
		Game wgame4 = new Game(1, wTeam4, wTeam13, 2016, map);
		System.out.println("west region round 1: " + wgame4.winnerTeam());
		Game wgame5 = new Game(1, wTeam6, wTeam11, 2016, map);
		System.out.println("west region round 1: " + wgame5.winnerTeam());
		Game wgame6 = new Game(1, wTeam3, wTeam14, 2016, map);
		System.out.println("west region round 1: " + wgame6.winnerTeam());
		Game wgame7 = new Game(1, wTeam7, wTeam10, 2016, map);
		System.out.println("west region round 1: " + wgame7.winnerTeam());
		Game wgame8 = new Game(1, wTeam2, wTeam15, 2016, map);
		System.out.println("west region round 1: " + wgame8.winnerTeam());
		
		//round 2
		Game wRound2_1 = new Game(2, wgame1.winnerTeam(), wgame2.winnerTeam(), 2016, map);
		System.out.println("west region round 2: " + wRound2_1.winnerTeam());
		Game wRound2_2 = new Game(2, wgame3.winnerTeam(), wgame4.winnerTeam(), 2016, map);
		System.out.println("west region round 2: " + wRound2_2.winnerTeam());
		Game wRound2_3 = new Game(2, wgame5.winnerTeam(), wgame6.winnerTeam(), 2016, map);
		System.out.println("west region round 2: " + wRound2_3.winnerTeam());
		Game wRound2_4 = new Game(2, wgame7.winnerTeam(), wgame8.winnerTeam(), 2016, map);
		System.out.println("west region round 2: " + wRound2_4.winnerTeam());
		
		//round 3
		Game wRound3_1 = new Game(3, wRound2_1.winnerTeam(), wRound2_2.winnerTeam(), 2016, map);
		System.out.println("west region round 3: " + wRound3_1.winnerTeam());
		Game wRound3_2 = new Game(3, wRound2_3.winnerTeam(), wRound2_4.winnerTeam(), 2016, map);
		System.out.println("west region round 3: " + wRound3_2.winnerTeam());
		
		//round 4
		Game wRound4 = new Game(4, wRound3_1.winnerTeam(), wRound3_2.winnerTeam(), 2016, map);
		System.out.println("west region final: " + wRound4.winnerTeam());
		
		
		//Midwest region
		Team mTeam1 = connection.getTeamById("1242");
		Team mTeam16 = connection.getTeamById("1300");
		
		Team mTeam8 = connection.getTeamById("1274");
		Team mTeam9 = connection.getTeamById("1277");
		
		Team mTeam5 = connection.getTeamById("1235");
		Team mTeam12 = connection.getTeamById("1305");
		
		Team mTeam4 = connection.getTeamById("1345");
		Team mTeam13 = connection.getTeamById("1436");
		
		Team mTeam6 = connection.getTeamById("1166");
		Team mTeam11 = connection.getTeamById("1348");
		
		Team mTeam3 = connection.getTeamById("1332");
		Team mTeam14 = connection.getTeamById("1233");
		
		Team mTeam7 = connection.getTeamById("1276");
		Team mTeam10 = connection.getTeamById("1329");
		
		Team mTeam2 = connection.getTeamById("1257");
		Team mTeam15 = connection.getTeamById("1240");
		
		//round 1
		Game mgame1 = new Game(1, mTeam1, mTeam16, 2016, map);
		System.out.println("midwest region round 1: " + mgame1.winnerTeam());
		Game mgame2 = new Game(1, mTeam8, mTeam9, 2016, map);
		System.out.println("midwest region round 1: " + mgame2.winnerTeam());
		Game mgame3 = new Game(1, mTeam5, mTeam12, 2016, map);
		System.out.println("midwest region round 1: " + mgame3.winnerTeam());
		Game mgame4 = new Game(1, mTeam4, mTeam13, 2016, map);
		System.out.println("midwest region round 1: " + mgame4.winnerTeam());
		Game mgame5 = new Game(1, mTeam6, mTeam11, 2016, map);
		System.out.println("midwest region round 1: " + mgame5.winnerTeam());
		Game mgame6 = new Game(1, mTeam3, mTeam14, 2016, map);
		System.out.println("midwest region round 1: " + mgame6.winnerTeam());
		Game mgame7 = new Game(1, mTeam7, mTeam10, 2016, map);
		System.out.println("midwest region round 1: " + mgame7.winnerTeam());
		Game mgame8 = new Game(1, mTeam2, mTeam15, 2016, map);
		System.out.println("midwest region round 1: " + mgame8.winnerTeam());
		
		//round 2
		Game mRound2_1 = new Game(2, mgame1.winnerTeam(), mgame2.winnerTeam(), 2016, map);
		System.out.println("midwest region round 2: " + mRound2_1.winnerTeam());
		Game mRound2_2 = new Game(2, mgame3.winnerTeam(), mgame4.winnerTeam(), 2016, map);
		System.out.println("midwest region round 2: " + mRound2_2.winnerTeam());
		Game mRound2_3 = new Game(2, mgame5.winnerTeam(), mgame6.winnerTeam(), 2016, map);
		System.out.println("midwest region round 2: " + mRound2_3.winnerTeam());
		Game mRound2_4 = new Game(2, mgame7.winnerTeam(), mgame8.winnerTeam(), 2016, map);
		System.out.println("midwest region round 2: " + mRound2_4.winnerTeam());
		
		//round 3
		Game mRound3_1 = new Game(3, mRound2_1.winnerTeam(), mRound2_2.winnerTeam(), 2016, map);
		System.out.println("midwest region round 3: " + mRound3_1.winnerTeam());
		Game mRound3_2 = new Game(3, mRound2_3.winnerTeam(), mRound2_4.winnerTeam(), 2016, map);
		System.out.println("midwest region round 3: " + mRound3_2.winnerTeam());
		
		//round 4
		Game mRound4 = new Game(4, mRound3_1.winnerTeam(), mRound3_2.winnerTeam(), 2016, map);
		System.out.println("midwest region final: " + mRound4.winnerTeam());
		
		
		//south region
		Team sTeam1 = connection.getTeamById("1314");
		Team sTeam16 = connection.getTeamById("1411");
		
		Team sTeam8 = connection.getTeamById("1116");
		Team sTeam9 = connection.getTeamById("1371");
		
		Team sTeam5 = connection.getTeamById("1278");
		Team sTeam12 = connection.getTeamById("1292");
		
		Team sTeam4 = connection.getTeamById("1139");
		Team sTeam13 = connection.getTeamById("1457");
		
		Team sTeam6 = connection.getTeamById("1153");
		Team sTeam11 = connection.getTeamById("1243");
		
		Team sTeam3 = connection.getTeamById("1417");
		Team sTeam14 = connection.getTeamById("1245");
		
		Team sTeam7 = connection.getTeamById("1173");
		Team sTeam10 = connection.getTeamById("1455");
		
		Team sTeam2 = connection.getTeamById("1246");
		Team sTeam15 = connection.getTeamById("1297");
		
		//round 1
		Game sgame1 = new Game(1, sTeam1, sTeam16, 2016, map);
		System.out.println("south region round 1: " + sgame1.winnerTeam());
		Game sgame2 = new Game(1, sTeam8, sTeam9, 2016, map);
		System.out.println("south region round 1: " + sgame2.winnerTeam());
		Game sgame3 = new Game(1, sTeam5, sTeam12, 2016, map);
		System.out.println("south region round 1: " + sgame3.winnerTeam());
		Game sgame4 = new Game(1, sTeam4, sTeam13, 2016, map);
		System.out.println("south region round 1: " + sgame4.winnerTeam());
		Game sgame5 = new Game(1, sTeam6, sTeam11, 2016, map);
		System.out.println("south region round 1: " + sgame5.winnerTeam());
		Game sgame6 = new Game(1, sTeam3, sTeam14, 2016, map);
		System.out.println("south region round 1: " + sgame6.winnerTeam());
		Game sgame7 = new Game(1, sTeam7, sTeam10, 2016, map);
		System.out.println("south region round 1: " + sgame7.winnerTeam());
		Game sgame8 = new Game(1, sTeam2, sTeam15, 2016, map);
		System.out.println("south region round 1: " + sgame8.winnerTeam());
		
		//round 2
		Game sRound2_1 = new Game(2, sgame1.winnerTeam(), sgame2.winnerTeam(), 2016, map);
		System.out.println("south region round 2: " + sRound2_1.winnerTeam());
		Game sRound2_2 = new Game(2, sgame3.winnerTeam(), sgame4.winnerTeam(), 2016, map);
		System.out.println("south region round 2: " + sRound2_2.winnerTeam());
		Game sRound2_3 = new Game(2, sgame5.winnerTeam(), sgame6.winnerTeam(), 2016, map);
		System.out.println("south region round 2: " + sRound2_3.winnerTeam());
		Game sRound2_4 = new Game(2, sgame7.winnerTeam(), sgame8.winnerTeam(), 2016, map);
		System.out.println("south region round 2: " + sRound2_4.winnerTeam());
		
		//round 3
		Game sRound3_1 = new Game(3, sRound2_1.winnerTeam(), sRound2_2.winnerTeam(), 2016, map);
		System.out.println("south region round 3: " + sRound3_1.winnerTeam());
		Game sRound3_2 = new Game(3, sRound2_3.winnerTeam(), sRound2_4.winnerTeam(), 2016, map);
		System.out.println("south region round 3: " + sRound3_2.winnerTeam());
		
		//round 4
		Game sRound4 = new Game(4, sRound3_1.winnerTeam(), sRound3_2.winnerTeam(), 2016, map);
		System.out.println("south region final: " + sRound4.winnerTeam());
		
		
		//final 4
		Game final4_1 = new Game(5, eRound4.winnerTeam(), wRound4.winnerTeam(), 2016, map);
		System.out.println("east and west final: " + final4_1.winnerTeam());
		Game final4_2 = new Game(5, mRound4.winnerTeam(), sRound4.winnerTeam(), 2016, map);
		System.out.println("midwest and sound final: " + final4_2.winnerTeam());
		
		//NCAA Champion
		
		Game champion = new Game(6, final4_1.winnerTeam(), final4_2.winnerTeam(), 2016, map);
		System.out.println("NACC champion: " + champion.winnerTeam());
		
		connection.close();
	}
}
