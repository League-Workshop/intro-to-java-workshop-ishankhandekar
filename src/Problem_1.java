import java.util.ArrayList;

public class Problem_1 {

	public static void main(String[] args) {
		  
		                                                                                
		  int var = -1;
		  int oddNum = 0;
		  //Declare string
		  
		String strNums = "1,2,3,4,5,6,7,8,9";
				for (int i = 0; i < 9; i++) {
					
					char number = 0;
					
					var = var + 2;
					
					number = strNums.charAt(var);
					int a = Character.getNumericValue(number);
					isOdd(a);
					
				}
		}
		
		//Convert String to character array
		//Convert character array to int array
		
		//Call method to find the odd numbers and add the odd numbers

		//If even - add to result
		//If odd-ignore
		//Return result
		public static int isOdd (int oddNum) {
			
			if(oddNum % 2 == 0) {
				return oddNum;
			}else {
				return 0;
			}
			
		}
	}
	

	
