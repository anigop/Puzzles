import java.io.BufferedReader;
import java.io.FileReader;


public class StringRotation {

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				strrot(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void strrot(String line){
		String[] token = line.split(",");
		
		String word = token[0].trim();
		String rotword = token[1].trim();
		boolean isRot = false;
		rotword += rotword;
		
		int index = 0;
		while(index < rotword.length()){
				if(index < word.length() && index+word.length() < rotword.length()){
					if(rotword.substring(index,index+word.length()).equals(word)){
						isRot = true;
						System.out.println(line+"  True");
						break;
					}
				}
			
			index++;
		}
		
		if(!isRot){
			System.out.println(line+" False");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
	}

}
