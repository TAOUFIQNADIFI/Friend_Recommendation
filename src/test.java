import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class test {
/*
 * main(String[] args) to test the code.
 * 
 * */
	public static void main(String[] args){
		graphLoader g = new graphLoader("data/test3.csv");
		Graph G = g.LoadGraph();
		
		HashMap<Integer,Integer> friend=	G.friendsRec(1) ;
		ArrayList<Integer>friend1 = G.bestFriendsRec(1, 1);
		//System.out.println(friend.get(1213));
		//System.out.println(friend.get(32));
		//System.out.println(friend.get(73));
		//System.out.println(friend.get(135));
		System.out.println(friend);
		System.out.println(friend1);
	}
	
}
