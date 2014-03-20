package secondattempts;

import java.io.BufferedReader;
import java.io.FileReader;

public class LargestContSum {

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				LargestCSum(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	public static void LargestCSum(String line){
		String[] numbers = line.split(",");
		
		int[] num = new int[numbers.length];
		
		for(int i = 0 ; i< numbers.length ; i++){
			String s = numbers[i].replace(" ", "");
			num[i] = Integer.parseInt(s);
		}
		
		compute(num);
		//System.out.println(compute(num,num.length-1));
	}
	
	public static void compute(int[] a){
		int sum = 0;
		int minIndex = -1;
		int rangei = 0;
		int rangej = 0;
		int minSum = 0;
		int maxSum = 0;
		for(int i = 0; i < a.length ; i++){
			
			sum += a[i];
			
			
			if(sum < minSum){
				minSum = sum;
				minIndex = i;
			}
			
			if(maxSum < sum-minSum){
				maxSum = sum-minSum;
				rangei = minIndex+1;
				rangej = i+1;
			}
		}
		
		int newsum = 0;
		while(rangei+1 <= rangej){
			newsum += a[rangei];
			rangei++;
		}
		System.out.println(newsum);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LargestCSum("-2,-3,-2,-1,-10");
		
	}

}
