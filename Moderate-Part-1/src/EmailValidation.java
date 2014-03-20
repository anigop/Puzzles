import java.io.BufferedReader;
import java.io.FileReader;


public class EmailValidation {
	
   public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				validateEmail(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void validateEmail(String s){
		if(s.length() > 0){
			boolean status = s.matches("^[A-Za-z0-9\\s\\.\\+_]+[@][A-Za-z0-9_]+\\.[A-Za-z|\\*]+[\\.A-Za-z]*$");
			
			System.out.println(s+"  "+status+"");
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//readFromFile(args[0]);
		
	   String s = "asterisk_domain@foo.*";
	   validateEmail(s);
	}

}
