import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


public class StringPermutation {

static ArrayList<String> allCombinations = new ArrayList<String>();

public static void readFromFile(String filename){

			try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				System.out.println(line);
				perms(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public static void perms(String line){
	
		ArrayList<String> allperms = allcomb(line);
		Collections.sort(allperms);
		String result = allperms.toString();
		result = result.replace(" ", "");
		System.out.println(result.substring(1,result.length()-1));
	}
	
	
	public static ArrayList<String> allcomb(String s){
		if(s.length() == 1){
			ArrayList<String> listOfone = new ArrayList<String>();
			listOfone.add(s);
			return listOfone;
		}else{
			String currentLetter = s.substring(0,1);
			
			ArrayList<String> newList = new ArrayList<String>();
			
			ArrayList<String> oldList = allcomb(s.substring(1));
			
			for(String str : oldList){
				
				for(int i = 0; i <= str.length();i++){
					newList.add(str.substring(0, i)+currentLetter+str.substring(i,str.length()));
				}
			}
			return newList;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
		
	}

}
