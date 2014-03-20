import java.io.BufferedReader;
import java.io.FileReader;


public class RepeatedNumber {
	
	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				repeatedNumber(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void repeatedNumber(String line){
		
		String[] token = line.split(";");
		String numberlist = token[1];
		String length = token[0];
		
		int index = 0;
		boolean zfilled = false;
		
		String[] numbers = numberlist.split(",");
		int[] array = new int[Integer.parseInt(length)];
		
		while(index < numbers.length){
			
			int num = Integer.parseInt(numbers[index]);
			
			if(num == 0 && !zfilled){
				zfilled = true;
			}
			else if (num == 0){
				System.out.println(0);
				break;
			}
			
			if(array[num] != 0){
				System.out.println(num);
				break;
			}
			
			array[num] = num;
			index++;
		}
		
		
		
	}
	public static void main(String[] args) {
		
		readFromFile(args[0]);

	}

}
