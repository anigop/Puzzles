import java.io.BufferedReader;
import java.io.FileReader;


public class FizzBuzz {

	
	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				returnfbString(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void returnfbString(String input){
		
		StringBuilder returnVal = new StringBuilder();
		String[] tuple = input.split("\\s");
		int i = 1;
		
		while(i <= Integer.parseInt(tuple[2])){
			
		  if((i % Integer.parseInt(tuple[0]) == 0) && (i% Integer.parseInt(tuple[1])) == 0){
			  returnVal.append("FB");
			  
		  }
		
		  else if(i % Integer.parseInt(tuple[0]) == 0){
			  returnVal.append("F");
		  }
		  
		  else if(i % Integer.parseInt(tuple[1]) == 0){
			  returnVal.append("B");
		  }
		  
		  else{
			  returnVal.append(i);
		  }
			
		  
		  if(i < Integer.parseInt(tuple[2])){
			  returnVal.append(" ");
		  }
		  
		  i++;
		}
		
		
		System.out.println(returnVal);
		
	}
	public static void main(String[] args) {
		readFromFile(args[0]);
	}

}
