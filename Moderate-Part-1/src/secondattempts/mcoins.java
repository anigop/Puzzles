package secondattempts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mcoins {
	
public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				mincoins(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

  public static void mincoins(String line){
	 
	    int reminder = Integer.parseInt(line);
	    int sum = 0;
	    
	    int fives = reminder / 5;
	    reminder -= fives * 5;
	    sum += fives;
	    
	    int threes = reminder / 3;
	    reminder -= threes * 3;
	    sum += threes;
	    
	    int ones = reminder;
	    sum += ones;
	    
	    
	    System.out.println(sum);
  }
	public static void main (String[] args)
    {
		long start = System.currentTimeMillis();
		mincoins("23130");
		long time = System.currentTimeMillis() - start;
		
		
		System.out.println(time);
       //readFromFile(args[0]);
    }
}
