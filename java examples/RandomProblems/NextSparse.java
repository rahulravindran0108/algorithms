import java.util.*;

class NextSparse {
	static void findNextSparse(String binString) {

		int [] outputArray = new int[binString.length()+1];

		int i=0,j=0;
		for(i=binString.length()-1,j=0; i>=0; i--,j++) {
			outputArray[j] = Character.getNumericValue(binString.charAt(i));
		}

		int last_finalized = 0;

		for(i=1;i<outputArray.length;i++) {
			if(outputArray[i] == 1 && outputArray[i-1] == 1 && outputArray[i+1]!=1) {

				//set next bit to 1
				outputArray[i+1] = 1;	

				for(j=i;j>=last_finalized;j--)
					outputArray[j] = 0;

				last_finalized = i+1;
			}
		}

		display(outputArray);

	}

	static void display(int [] outputArray) {
		StringBuilder builder = new StringBuilder();
		for (int k : outputArray) {
		  builder.append(k);
		}
		System.out.println(Integer.parseInt(builder.reverse().toString(),2));
	}

	public static void main(String[] args) {
		int number = 12;
		String binString = Integer.toBinaryString(number);	
		findNextSparse(binString);
	}
}