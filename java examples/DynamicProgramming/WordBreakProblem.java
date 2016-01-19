class WordBreakProblem {


	public static void main(String[] args) {
		System.out.println(wordBreak("ilike"));
	}

	static boolean wordBreak(String word) {
		if(word.length() == 0)
			return true;

		boolean [] checked = new boolean[word.length()+1];

		
		for(int i=1;i<=word.length();i++) {

			if(checked[i] == false && contains(word.substring(0,i)) )
			checked[i] = true;

			if(checked[i] == true) {

				if(i == word.length())
					return true;

				for(int j=i+1;j<=word.length();j++) {
					if(checked[j] == false && contains(word.substring(i,j)))
						checked[j] = true;

					if(j==word.length() && checked[j] == true)
						return true;
				}
			}


		}

		return false;
	}

	static boolean contains(String word) {
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                           "icecream","and","go","i","like","ice","cream"};
		for(String example : dictionary) {
			if(example.equals(word))
				return true;
		}
		return false;
	}
}