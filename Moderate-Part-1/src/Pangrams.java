import java.io.BufferedReader;
import java.io.FileReader;


public class Pangrams {


	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				pangramsDistance(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void pangramsDistance(String line){
		int[] a = new int[26];
		int index = 0;
		String s = "";
		line = line.toUpperCase();
		
		while(index < line.length()){
			if(line.charAt(index) >= 65 && line.charAt(index) <= 90 ){
				a[line.charAt(index)-65] = 1;
			}
			index++;
		}
		
		
		for(int i = 0 ; i<a.length ; i++){
			if(a[i] == 0){
				char c = (char)(i+65);
				s += c;
			}
		}
		
		if(s.length() > 0){
			System.out.println(s.toLowerCase());
		}else{
			System.out.println("NULL");
		}
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
		
	}

}
