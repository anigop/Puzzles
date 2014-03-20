import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class TelephoneWords {

static HashMap<String,String> numbertoCharMap;
static ArrayList<String> allwords = new ArrayList<String>();

public static void readFromFile(String filename){

			try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				printall(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void printall(String line){
		
		genWords(line, "");
		
		//System.out.println(allwords.toString().substring(1, allwords.toString().length()-1).replace(" ", ""));
		
		System.out.print(allwords.get(0));
		for(int i=1; i<allwords.size();i++){
			System.out.print(","+allwords.get(i));
		}
		System.out.println();
	}
	public static void genWords(String line , String word){
		if(line.length() == 0){
			allwords.add(word);
			return;
		}
		
		String mappedchar = numbertoCharMap.get(line.substring(0,1));
		
		for(int i =0; i < mappedchar.length() ; i++){
				genWords(line.substring(1), word+mappedchar.charAt(i));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbertoCharMap = new HashMap<String,String>();
		
		numbertoCharMap.put("0", "0");
		numbertoCharMap.put("1", "1");
		numbertoCharMap.put("2", "abc");
		numbertoCharMap.put("3", "def");
		numbertoCharMap.put("4", "ghi");
		numbertoCharMap.put("5", "jkl");
		numbertoCharMap.put("6", "mno");
		numbertoCharMap.put("7", "pqrs");
		numbertoCharMap.put("8", "tuv");
		numbertoCharMap.put("9", "wxyz");
		
		
		printall("4155230");

	}

}
