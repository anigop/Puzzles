import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;


public class RemoveCharacter {

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				processString(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void processString(String line){
		
		String[] token = line.split("[,]");
		
		HashSet<Character> set = new HashSet<Character>();
		
		int i = 0;
		
		StringBuilder sb = new StringBuilder(token[0]);
		StringBuilder sb1 = new StringBuilder(token[1]);
		
		
		while( i < sb1.length()){
			if(!sb1.equals("\\s")){
				set.add(sb1.charAt(i));
			}
			i++;
		}
		
		i = 0;
		while(i < sb.length()){
			if(set.contains(sb.charAt(i))){
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile("removechars");
	}

}
