import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;


public class StringList {

	
	static TreeSet<String> allwords;
	public static void readFromFile(String filename){

		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String line = null;
			
			while((line = br.readLine()) != null){
				StringList(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	
	public static void StringList(String line){
		
		String[] token = line.split(",");
		int num = Integer.parseInt(token[0]);
		String s = token[1];
		allwords = new TreeSet<String>();

		genAll(num, s , "");
		
		
		System.out.println(allwords.toString().substring(1,allwords.toString().length()-1).replaceAll(" ",""));
	}
	
	public static void genAll(int num , String s , String current){
		
		if(current.length() >= num){
			allwords.add(current);
			return;
		}
		for(int i =0 ; i < s.length() ; i++){
			genAll(num, s, current+s.charAt(i));
		}
	}
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
	}

}
