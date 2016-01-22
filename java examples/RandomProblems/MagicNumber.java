class MagicNumber {

	static void printMagic(int n) {
		int pow = 1;
		int answer = 0;

		while(n != 0) {
			pow = pow*5;

			if((n & 1)!=0)
				answer+=pow;
			n >>= 1;
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {

		int n = 3;

		printMagic(n);	
	}
}