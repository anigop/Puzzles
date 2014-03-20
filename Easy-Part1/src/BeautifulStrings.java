import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.PriorityQueue;


public class BeautifulStrings {

public static class node implements Comparable<node>{

	public String c;
	public int count;
	@Override
	public int compareTo(node o) {
		// TODO Auto-generated method stub
		if(this.count < o.count){
			return 1;
		}
		return -1;
	}
	
	
}
public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				beautyscore(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


    public static void beautyscore(String line){
    	
    	int maxValue = 26;
    	int beautyscore = 0;
    	
    	PriorityQueue<node> heap = new PriorityQueue<node>();
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	
    	line = line.toLowerCase();
    	
    	String[] tokens = line.split("");
    	
    	for(String s : tokens){
    		if(s.matches("[A-Za-z]")){
    			if(map.get(s) == null){
    				map.put(s, 1);
    			}else{
    				map.put(s,map.get(s)+1);
    			}
    		}
    	}
    	
    	for(String key : map.keySet()){
    		node n = new node();
    		n.c = key;
    		n.count = map.get(key);
    		heap.add(n);
    	}
    	
    	while(!heap.isEmpty()){
    		beautyscore += heap.remove().count*maxValue;
    		maxValue--;
    	}
    	
    	System.out.println(line);
    	System.out.println(beautyscore);
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readFromFile(args[0]);

	}

}
