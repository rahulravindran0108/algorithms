import java.util.*;

class AlternatePositiveNegative {

	static void rearrange(int [] input, int n) {
		int outOfPlace = -1;

		for(int i=0;i<n;i++) {

			if(outOfPlace >= 0) {
				if (((input[i] >= 0) && (input[outOfPlace] < 0)) ||
                 		((input[i] < 0) && (input[outOfPlace] >= 0)))
            	{
            		input = rightrotate(input, n, outOfPlace, i);

	                if (i - outOfPlace > 2)
	                    outOfPlace = outOfPlace + 2;
	                else
	                    outOfPlace = -1;
	            }
			}

			if(outOfPlace == -1) {
				if((input[i] >=0 &&  (i % 2 == 0)) || ((input[i] < 0) && !(i % 2 == 0))) {
					outOfPlace = i;
				}
				
			}
		}
	}

	static int [] rightrotate(int arr[], int n, int outofplace, int cur)
	{
	    int tmp = arr[cur];
	    for (int i = cur; i > outofplace; i--)
	        arr[i] = arr[i-1];
	    arr[outofplace] = tmp;
	    return arr;
	}
 

	public static void main(String[] args) {
		int input[] = {1, 2, 3, -4, -1, 4};

		rearrange(input, input.length);

		System.out.println(Arrays.toString(input));

	}
}