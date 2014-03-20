import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;


public class FirstNonRepeated {
	
public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				firstnonrep(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

   public static void firstnonrep(String line){
	   
	   HashMap<String,Boolean> map = new HashMap<String,Boolean>();
	   int index = 0;
	   while(index < line.length()){
		   if(map.get(line.charAt(index)+"") == null){
			  map.put(line.charAt(index)+"", false); 
		   }else{
			   map.put(line.charAt(index)+"",true);
		   }
		   index++;
	   }
	   
	   index = 0;
	   while(index < line.length()){
		   if(!map.get(line.charAt(index)+"")){
			   System.out.println(line.charAt(index));
			   return;
		   }
		   index++;
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
	}

}
