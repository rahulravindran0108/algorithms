// Write a method to compute all permutations of a string
import java.util.ArrayList;

class StringPermutation {

	//method that takes in string and produces all possible permutations

	static ArrayList<String> getPerms (String input) {
		if(input == null) 
			return null;

		ArrayList<String> permutations = new ArrayList<String>();

		if(input.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char first = input.charAt(0);

		ArrayList<String> words = getPerms(input.substring(1));

		for(String word : words) {
			for(int i=0;i<=word.length();i++) {
				permutations.add(insertCharAt(word,first,i));
			}
		}

		return permutations;

	}

	static String insertCharAt(String word, char c, int position) {
		String start = word.substring(0,position);
		String end = word.substring(position);
		return start+c+end;
	}

	public static void main(String[] args) {
		String input = "he";
		ArrayList<String> output = getPerms(input);

		for(String perms : output) {

			System.out.println(perms);

		}
	}

}