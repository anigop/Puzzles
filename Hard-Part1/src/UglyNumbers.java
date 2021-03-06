import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class UglyNumbers {

	static int totalCount = 0;
public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				System.out.println(line);
				uglynumbers(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public static void allseq(String line, String sequence){
		
		if(line.length() == 1){
			//sequences.add(sequence+line);
			int result = evalseq(sequence+line);
			totalCount = isUgly(result) ? totalCount+1 : totalCount;
			return;
		}
		
		allseq(line.substring(1), sequence+line.substring(0,1)+"+");
		allseq(line.substring(1), sequence+line.substring(0,1)+"-");
		allseq(line.substring(1), sequence+line.substring(0,1));
	}
	
	public static int evalseq(String seq){
		
		Queue<String> operator = new LinkedList<String>();
		Queue<String> operand = new LinkedList<String>();
		
		int index = 0;
		String tokens[] = seq.split("[+|-]");
		int result = 0;
		
		for(String tok : tokens){
			operand.add(tok);
		}
		
		while(index < seq.length()){
			if(seq.charAt(index) == '+' || seq.charAt(index) == '-'){
				operator.add(seq.charAt(index)+"");
			}
			index++;
		}
		
		result = Integer.parseInt(operand.remove());
		
		while(!operator.isEmpty()){
			
			String symbol = operator.remove();
			if(operator.size() >= 0){
				int o1 = Integer.parseInt(operand.remove());
				
				if(symbol.equals("-")){
					result -= o1;
				}else{
					result += o1;
				}
			}
		}
		return result;
	}
	
	public static boolean isUgly(int num){
		return num % 5 == 0 || num % 7 == 0 || num % 3 ==0 || num%2 == 0;
	}
	
	
	
	
	public static void uglynumbers(String input){
		allseq(input, "");
		
		System.out.println(totalCount);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile("ugly");
		
		
	}

}
