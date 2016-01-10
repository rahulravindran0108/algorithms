/*
* Author: Rahul Ravindran
*/
class MakeChange {

	//make change method for making change equal to n
	static int makeChange(int n, int denomination) {
		int next_denom = 0;

		// using switch statment to find the next denomination
		switch(denomination) {
			case 25:
				next_denom = 10;
				break;
			case 10:
				next_denom = 5;
				break;
			case 5:
				next_denom = 1;
				break;
			case 1:
				return 1;

		}

		int ways = 0;

		for(int i=0;i*denomination <=n;i++) {
			ways+=makeChange(n-i*denomination,next_denom);
		}

		return ways;

	}


	public static void main(String[] args) {
		System.out.println(makeChange(100,25));
	}
}