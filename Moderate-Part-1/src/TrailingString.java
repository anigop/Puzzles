import java.awt.PageAttributes.OriginType;
import java.io.BufferedReader;
import java.io.FileReader;


public class TrailingString {
	
public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				trailingString(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

public static void trailingString(String line){
		
	String[] tokens = line.split(",");
	
	String orgword = tokens[0].trim();
	String newword = tokens[1].trim();
	boolean status = false;
	int origpointer = orgword.length()-1;
	int newpointer = newword.length()-1;
	
	
	while(newpointer >= 0 && origpointer >= 0 ){
		
		if(orgword.charAt(origpointer) == newword.charAt(newpointer)){
			origpointer--;
			newpointer--;
			status = true;
		}else{
			status = false;
			break;
		}
	}
	
	if(newpointer > origpointer){
		status = false;
	}
	if(status){
		System.out.println(1);
	}else{
		System.out.println(0);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trailingString("OK,NOK");
	}

}
