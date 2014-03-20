
public class ProgressBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			String dot = "~";
			int count = 5330;
			
			for(int i = 0 ; i< count;i++){
				System.out.print(dot);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
