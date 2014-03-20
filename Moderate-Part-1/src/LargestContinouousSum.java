import java.io.BufferedReader;
import java.io.FileReader;


public class LargestContinouousSum {

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				largestsum(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void largestsum(String line){
		
		String[] numbers = line.split(",");
		int maxSum = 0;
		int currentMax = 0;
		int sum = 0;
		
		for(String s : numbers){
			s = s.replace(" ", "");
			int num = Integer.parseInt(s);
			
			sum += num;
			currentMax = sum > currentMax ? sum : currentMax;
			
			if(sum < 0){
				maxSum = currentMax > maxSum ? currentMax : maxSum;
				currentMax = 0;
				sum = 0;
			}
		}
		currentMax = sum > currentMax ? sum : currentMax;
		maxSum = currentMax > maxSum ? currentMax : maxSum;
		
		System.out.println(maxSum);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		largestsum("-2,-3,-2,-1,-10");
	}

}
