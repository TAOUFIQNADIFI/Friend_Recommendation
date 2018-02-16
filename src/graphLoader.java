import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class graphLoader {
	
	  private String fileName;
	  private CapGraph g;
	  public graphLoader(String fileName){
		this.fileName=fileName;
		g=new CapGraph();
	  }	
	
	 public Graph LoadGraph(){
		 BufferedReader br = null;
	        try
	        {br = new BufferedReader(new FileReader(fileName));
	        String line = "";
	        while ((line = br.readLine()) != null) 
            {
	        	String[] lineDetails = line.split(",");
	           if(lineDetails.length>0){
	        	 //  System.out.println(lineDetails[0]);
	        	int v = Integer.parseInt(lineDetails[0]);   
	        	int v1 = Integer.parseInt(lineDetails[1]); 
	        
	        	if(!g.getListOfVertices().contains(v)){
	        		g.addVertex(v);
	        		g.addEdge(v, v1);	        		
	        	  }
	        	
	        	else{
	        		g.addEdge(v, v1);
	        			        	}
	        	
	        	
	           }
	           }
            
            }
	        catch(Exception ee)
	        {
	            ee.printStackTrace();
	        }
	        
		 finally{
			 
			 try
	            {
	                br.close();
	            }
	            catch(IOException ie)
	            {
	                System.out.println("Error occured while closing the BufferedReader");
	                ie.printStackTrace();
	            }
	        }
		 
	   return g;
	 } 
	  
  
}
