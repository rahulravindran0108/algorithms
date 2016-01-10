/*
You are given two 32-bit numbers,N and M, and two bit positions,
i and j. Write a method to insert M into N such that M starts at bit j
and ends at bit i. You can assume that the bits j through i have enough
space to fit all ofM. That is,ifM= 10011, you can assume that there are
at least 5 bits between j and i. You would not, for example, have j=3 and i=2
,because M could not fully fit between bit 3 and bit 2.
*/
class InsertBits {

	static void updateBits(int n, int m, int i, int j) {
		int allOnes = ~0;
		int left = allOnes << (j+1);
		int right=((1 << i)-1);

 		int mask=left|right;

		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
        int answer = n_cleared | m_shifted; // OR them, and we're done!

        displayInBinary(answer);
	}

	static void displayInBinary(int x) {
		System.out.println(Integer.toBinaryString(x));
	}

	public static void main(String[] args) {
		int n = 1000000000;
		int m = 10011;
		int i=2,j=6;
		updateBits(n,m,i,j);
	}

}