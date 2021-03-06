import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;


public class TextDollar {
	
	static HashMap<String,String> tymap = new HashMap<String,String>();
	static HashMap<String,String> digitMap = new HashMap<String,String>();
	static HashMap<String,String> hMap = new HashMap<String,String>();
	static HashMap<String,String> teenMap = new HashMap<String,String>();
	public static void readFromFile(String filename){

		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String line = null;
			
			while((line = br.readLine()) != null){
				textDollar(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}

	
	public static void textDollar(String line){
		
		if(line.length() == 1 && line.charAt(0) == '1'){
			System.out.println("OneDollar");
			return;
		}
		String masterString = "";
		
		
		String[] token = threesplit(line);
		String tmp = "";
		
		for(int i = 0 ; i < token.length ; i++ ){
			
			tmp = evaltoken(reverse(token[i]));
			if(tmp.length() > 0){
				tmp += hMap.get(i+"");
			}
			
			
			masterString = tmp+masterString;
			
		}
		if(masterString.length() > 0){
			System.out.println(masterString+"Dollars");
		}else{
			System.out.println("ZeroDollars");
		}
		
	}
	
	public static String evaltoken(String s){
		
		int index = 0;
		String numb = "";
		
		while(index < s.length()){
			if(index == 0){
				
				if(s.length() == 1 && (s.charAt((s.length()-1)-(index)) == '1')){
					numb = digitMap.get(s.charAt((s.length()-1)-index)+"")+numb;
				}
				if(index+1 < s.length() && (s.charAt((s.length()-1)-(index+1)) != '1' || (s.charAt((s.length()-1)-(index+1)) == '1' && s.length() == 1))){
					numb = digitMap.get(s.charAt((s.length()-1)-index)+"")+numb;
				}
			}
			else if(index == 1){
				if(s.charAt((s.length()-1)-index) != '1'){
					numb = tymap.get(s.charAt((s.length()-1)-index)+"")+numb; 
				}else{
					numb = teenMap.get(s.charAt((s.length()-1)-index)+""+s.charAt((s.length()-1)-(index-1)));
				}
			}else{
				if(s.charAt((s.length()-1)-index) != 0 && s.charAt((s.length()-1)-index) != '0'){
					numb = digitMap.get(s.charAt((s.length()-1)-index)+"")+"Hundred"+numb;
				}
				
			}
			
			index++;
		}
		
		return numb;
	}
	public static String[] threesplit(String line){
		int index = 0;
		index = line.length()%3 == 0  ? line.length()/3 : line.length()/3+1;
		String[] arr = new String[index];
		int i = 0;
		String current = "";
		index = 0;
		
		while(index < line.length()){
			if((index+1) % 3  == 0 && index != 0){
				current += line.charAt((line.length()-1)-index);
				arr[i] = current;
				current = "";
				i++;
			}else{
				current += line.charAt((line.length()-1)-index);
			}
			
			index++;
			
		}
		
		if(current.length() > 0){
			arr[i] = current;
		}
		
		
		
		return arr;
	}
	
	public static String reverse(String s){
		if(s.length() == 1){
			return s;
		}
		return reverse(s.substring(1))+s.substring(0,1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		tymap.put("0", "");
		tymap.put("1", "Ten");
		tymap.put("2", "Twenty");
		tymap.put("3", "Thirty");
		tymap.put("4", "Forty");
		tymap.put("5", "Fifty");
		tymap.put("6", "Sixty");
		tymap.put("7", "Seventy");
		tymap.put("8", "Eighty");
		tymap.put("9", "Ninety");
		
		digitMap.put("0", "");
		digitMap.put("1", "One");
		digitMap.put("2", "Two");
		digitMap.put("3", "Three");
		digitMap.put("4", "Four");
		digitMap.put("5", "Five");
		digitMap.put("6", "Six");
		digitMap.put("7", "Seven");
		digitMap.put("8", "Eight");
		digitMap.put("9", "Nine");

		hMap.put("0", "");
		hMap.put("1", "Thousand");
		hMap.put("2", "Million");
		hMap.put("3", "Billion");
		
		teenMap.put("10", "Ten");
		teenMap.put("11", "Eleven");
		teenMap.put("12", "Twelve");
		teenMap.put("13", "Thirteen");
		teenMap.put("14", "Fourteen");
		teenMap.put("15", "Fifteen");
		teenMap.put("16", "Sixteen");
		teenMap.put("17", "Seventeen");
		teenMap.put("18", "Eighteen");
		teenMap.put("19", "Nineteen");

		
		textDollar("");
		//readFromFile(args[0]);
		//evaltoken("110");
		

	}

}
