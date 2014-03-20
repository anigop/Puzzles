package secondattempts;

import java.io.BufferedReader;
import java.io.FileReader;

public class Coins {

	public static void readFromFile(String filename){

		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String line = null;
			
			while((line = br.readLine()) != null){
				mincoins(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	
	
	public static void mincoins(String line){
		
		int count = 0;
		int amount = Integer.parseInt(line);
		
		
		int fives = amount/5;
		amount -= fives*5; 
		
		int threes = amount/3;
		amount -= threes*3;
		
		count = fives+threes+amount;
		
		System.out.println(count);
		
	}
	
	public static void main(String[] args) {
		readFromFile(args[0]);
	}

}
