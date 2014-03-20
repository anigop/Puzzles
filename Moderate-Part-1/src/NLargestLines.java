import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;


public class NLargestLines {

	public static class line implements Comparable<line> {
		
		public String line;
		public int length;
		
		
		public int compareTo(line l){
			
			if(this.length < l.length){
				return 1;
			}
			return -1;
		}
		
		
	}
	public static void readFromFile(String filename){
		try{
			
			ArrayList<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String lline  = null;
			
			while((lline = br.readLine()) != null){
				lines.add(lline);
			}
			
			
			NLargestLines(lines);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void NLargestLines(ArrayList<String> lines){
		
		
		int n = Integer.parseInt(lines.get(0));
		int i = 0;
	    lines.remove(0);
	    
		PriorityQueue<line> heap = new PriorityQueue<line>();
		HashMap<String,line> map = new HashMap<String,line>();
		
		for(String l : lines){
			
			line lObj = new line();
			lObj.line = l;
			lObj.length = l.length();
			
			map.put(l, lObj);
			
		}
		
		
		for(String key : map.keySet()){
			heap.add(map.get(key));
		}
		
		while(i < n){
			line l = heap.remove();
			System.out.println(l.line);
			i++;
		}
		
	}
	
	
	public static void main(String[] args) {
		readFromFile(args[0]);
	}

}
