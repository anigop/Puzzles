import java.io.BufferedReader;
import java.io.FileReader;

import javax.naming.BinaryRefAddr;


public class NumberOfOnes {

public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				numberofOnes(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void numberofOnes(String line){
		
		int num = Integer.parseInt(line);
		
		int binaryOnes = 0;
		
		
		while(num > 0){
			if(num%2 == 1){
				binaryOnes++;
			}
			num = num/2;
		}
		
		System.out.println(binaryOnes);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numberofOnes("0");
		//readFromFile(args[0]);
	
	   int i = 1/2;
	}

}
