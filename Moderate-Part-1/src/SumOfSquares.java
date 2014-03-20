import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class SumOfSquares {

	
	public static void readFromFile(String filename){
		try{
			
			ArrayList<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String lline  = null;
			
			while((lline = br.readLine()) != null){
				lines.add(lline);
			}
			
			//lines.remove(0);
			sumOfSquares(lines);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void sumOfSquares(ArrayList<String> tuples){
		
		int n = Integer.parseInt(tuples.get(0));
		tuples.remove(0);
		
		

		for(String number : tuples){
			
			int num = Integer.parseInt(number);
			int count = 0;
			
			if( num == 0 || num == 1 ){
				System.out.println(1);
				continue;
			}
			int[] arr = generateNumbers(num);
			
			for(int i = 0 ; i < arr.length; i++){
				
				int diff = num - arr[i];
				
				int index = binarysearch(arr , 0, arr.length-1, diff);
				if(index != -1){
					count++;
				}
			}
			System.out.println(count/2);
		}
	}
	
	public static int[] generateNumbers(int num){
		
		//System.out.println(num);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		int index = 0;
		
		int[] arr ;
		
		while(true){
			if(index*index <= num){
				nums.add(index*index);
				index++;
			}else{
				break;
			}
		}
		
		
		arr = new int[nums.size()];
		
		//System.out.println(nums);
		for(int i = 0 ; i < nums.size() ; i++){
			arr[i] = nums.get(i);
		}
		
		return arr;
	}
	
	
	public static int binarysearch(int[] a , int low , int high , int target){
		
		int mid = (low+high)/2;
		
		
		if(low > high){
			return -1; 
		}
		if(a[mid] == target){
			return mid;
		}
		
		if(a[mid] > target){
			return binarysearch(a,low,mid-1,target);
		}
		
		else{
			return binarysearch(a,mid+1,high,target);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile("sumofsquares");

	}

}
