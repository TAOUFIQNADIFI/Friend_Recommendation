/**
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

//import sun.security.provider.certpath.AdjacencyList;

/**
 * @author Your name here.
 * 
 * For the warm up assignment, you must implement your Graph in a class
 * named CapGraph.  Here is the stub file.
 *
 */
public class CapGraph implements Graph {

	private static final String CapGraph = null;
	
	private int numOfVertices;
	private int numOfEdges;
	private HashMap<Integer,HashSet<Integer>> adjListsMap; 
	private  HashSet<Integer> ListOfVertices ; 
	
	public  CapGraph(){
		adjListsMap = new HashMap<Integer,HashSet<Integer>>();
		 ListOfVertices  = new HashSet<Integer>();
		numOfVertices=0;
		numOfEdges=0;	
		//ListOfVertices=new Stack<Integer>();
	}
	
	public HashSet<Integer> getListOfVertices(){
		
		return ListOfVertices;
	}
	
	@Override
	public void addVertex(int num) {
		// TODO Auto-generated method stub
		if(!adjListsMap.containsKey(num)){
			HashSet<Integer> value = new HashSet<Integer>();
			adjListsMap.put(num,value);
			ListOfVertices.add(num);
			//System.out.println(ListOfVertices);
			numOfVertices++;
		}

	}

	/* (non-Javadoc)
	 * @see graph.Graph#addEdge(int, int)
	 */
	@Override
	public void addEdge(int from, int to)	{
		// TODO Auto-generated method stub
		adjListsMap.get(from).add(to);    
		
		
	}

	
	

	
	public  HashSet<Integer> getNeighbors(int a){
		HashSet<Integer> result = new HashSet<Integer>();
		if (adjListsMap.containsKey(a)){
			
			result=adjListsMap.get(a);
		}
		return result ;
	}
	
	
	/*
	@Override
	public HashMap<Integer, HashSet<Integer>> exportGraph() {
		// TODO Auto-generated method stub
		return adjListsMap;
	}
   */

	
	@Override
	public HashMap<Integer,Integer> friendsRec(int center) {
		// TODO Auto-generated method stub
	    HashSet<Integer> friends= getNeighbors(center);
		HashMap<Integer,Integer> Friends=new HashMap<Integer,Integer>();
		for(int a : friends){
			HashSet<Integer> friends1= getNeighbors(a);
			for(int b : friends1){
				
			if(!(b==center)){
				if(!friends.contains(b)){
					if(!Friends.containsKey(b)){
						Friends.put(b, 1);
											}
					else{
						int c = Friends.get(b);
						c++;
						Friends.put(b,c);
					}
				}
			}
			}
		}
		return Friends;
	}



	@Override
	public   ArrayList<Integer> bestFriendsRec(int center, int num) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		HashMap<Integer,Integer> frien = friendsRec( center);
		LinkedHashMap<Integer, Integer> sortedFriend =  sortHashMapByValues( frien);
		for(int key : sortedFriend.keySet()){
			System.out.println("the key is:  " +key + " value:  "+ sortedFriend.get(key) );
			num--;
			result.add(key);
			if(num==0){break;}
		}
		return result;
	}
	
	


	public LinkedHashMap<Integer, Integer> sortHashMapByValues(
	        HashMap<Integer, Integer> passedMap) {
	    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    
	   
	    Collections.sort(mapValues, Collections.reverseOrder());
	    
	    Collections.sort(mapKeys);
       //  System.out.println(mapValues);
	    LinkedHashMap<Integer, Integer> sortedMap =  new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	    	int val = valueIt.next();
	    	//System.out.println(val);
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            int comp1 = passedMap.get(key);
	            int comp2 = val;

	            if (comp1==comp2) {
	                keyIt.remove();
	                
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	   // System.out.println(sortedMap);
	    
	    return sortedMap;
	}
	
}
