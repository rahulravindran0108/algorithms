class EditDistance {


	public static void main(String[] args) {
		String input1 = "Saturday";
		String input2 = "Sunday";

		int [][] mapper = new int[input1.length()][input2.length()];

		for(int i=0;i<input1.length();i++)
			mapper[i][0] = i;

		for(int j=0;j<input2.length();j++)
			mapper[0][j] = j;

		for(int i=1;i<input1.length();i++) {
			for(int j=1;j<input2.length();j++) {
				if(input1.charAt(i) == input2.charAt(j))
					mapper[i][j] = mapper[i-1][j-1];
				else
					mapper[i][j] = Math.min(mapper[i-1][j]+1,
						Math.min(mapper[i][j-1]+1,mapper[i-1][j-1]+1));
			}
		}


		//print the matrix
		for(int i=0;i<input1.length();i++) {
			for(int j=0;j<input2.length();j++) {
				System.out.print(mapper[i][j]);
			}
			System.out.println();
		}

		//print the edit distance
		System.out.println(mapper[input1.length()-1][input2.length()-1]);
	}
}