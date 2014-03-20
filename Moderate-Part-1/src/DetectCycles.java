import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;


public class DetectCycles {

public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				detectcycles(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void detectcycles(String line){
		
		String[] numbers = line.split("\\s");
		int cycleStart = 0;
		int cyclelength = 0;
		boolean inCycle = false;
		StringBuilder sb = new StringBuilder();
		int ceil = 0;
		int index =0 ;
		String prev = "";
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		while(index < numbers.length){
			
			if( !inCycle && map.get(numbers[index]) == null){
				if(index+1 < numbers.length){
					map.put(numbers[index], numbers[index+1]);
				}
				
			}
			
			else if( !inCycle && map.get(numbers[index]) != null ){
				cycleStart = index;
				cyclelength += 1;
				inCycle = true;
				prev = numbers[index];
			    
			}
			
			else if(inCycle && map.get(numbers[index]) != null){
				if(map.get(prev).equals(numbers[index]) && ! prev.equals(numbers[index])){
					cyclelength++;
					map.remove(prev);
					prev = numbers[index];
					
				}else{
					break;
				}
			}
			
			index++;
		}
		
		
		ceil = cycleStart+cyclelength;
				
		while(cycleStart < ceil){
			sb.append(numbers[cycleStart]);
			
			if(cycleStart < ceil-1){
				sb.append(" ");
			}
			cycleStart++;
		}
		
		System.out.println(sb);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
	}

}
