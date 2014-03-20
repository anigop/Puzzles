import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class SeatTeamMembers {
public static void readFromFile(String filename){

		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				parseLine(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

 public static boolean compute(List<List<String>> list , HashSet<String> set){
	 if(list.size() == 0){
		 System.out.println(set);
		 return true;
	 }
	 
	 List<String> p = null;
	 p = list.get(0);
	 for(String slots : p){
		 if(!set.contains(slots)){
			 set.add(slots);
			 if(compute(list.subList(1,list.size()), set)){
				return true; 
			 }
			 set.remove(slots);
		 }
	 }
	 return false;
 }
 
 
 public static void parseLine(String line){
	 
	 String[] initToken = line.split(";");
	 HashSet<String> mem = new HashSet<String>();
	 boolean open = false;
	 int index = 0 ;
	 List<List<String>> listoflists = new ArrayList<List<String>>();
	 ArrayList<String> innerList = new ArrayList<String>();
	 line = initToken[1].trim();
	 String arr = "";
	 
	 while(index < line.length()){
		 if(line.charAt(index) == '['){
			 
			 open = true;
			 innerList = new ArrayList<String>();
		 }
		 
		 else if(line.charAt(index) == ']'){
			 open = false;
			 
			 String[] tokens = arr.split(",");
			
			 for(String s : tokens){
					 innerList.add(s);
			 }
			 arr = "";
			 listoflists.add(innerList);
		 }
		 
		 else if(open){
			 arr += line.charAt(index);

		 }
		 
		 index++;
	 }
	 System.out.println(listoflists);
	 if(compute(listoflists, mem)){
		 System.out.println("Yes");
	 }else{
		 System.out.println("No");
	 }
	 
	
	 
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//parseLine("3; 1:[8, 7, 3], 2:[13, 5, 4, 7, 12, 8, 10], 4:[4, 7, 12, 8, 10],  4:[4, 7, 12, 13, 5, 8, 10] , [4,5] , [5,4] ,[4]");
		//parseLine("3; 1:[8, 7, 3]");
		
		parseLine(" 4; [14,  9,  8,  15,  4,  13,  11,  10]] [[3,  12], [9,  2,  8,  5,  6], [7,  12,  14,  11,  8,  1,  9], [10,  9,  7,  13,  14,  5,  3,  6], [3,  5,  7,  9,  6,  12], [4,  3,  14,  7,  6,  8,  13,  9,  12,  1], [13,  9,  4,  6,  2,  5,  3,  14], [12,  2,  6,  5,  11,  10,  14], [3,  4,  12,  11,  14], [9,  1,  10,  ");
		
	}

}
