import java.util.*;

class CountAnagramSubstring {

	//assuming pattern length is shorter than string length
	static void search(char [] text, char [] pat) {

		//this is to map pattern count
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		//this is to map text count
		HashMap<Character, Integer> map2 = new HashMap<Character,Integer>();

		for(int i=0;i<pat.length;i++) {
			if(map.containsKey(pat[i]))
				map.put(pat[i],map.get(pat[i])+1);
			else
				map.put(pat[i],1);

			if(map2.containsKey(text[i]))
				map2.put(text[i],map2.get(text[i])+1);
			else
				map2.put(text[i],1);
		}

		for(int i=pat.length;i<text.length;i++) {
			if(map.equals(map2))
				System.out.println("found at index"+(i-pat.length));

			map2.put(text[i],(map2.containsKey(text[i]) ? map2.get(text[i]) : 0)+1);
			map2.put(text[i-pat.length],map2.get(text[i-pat.length])-1);
			if(map2.get(text[i-pat.length]) == 0)
				map2.remove(text[i-pat.length]);
	
		}

		if(map.equals(map2))
				System.out.println("found at index"+(text.length-pat.length));

	}

	static void display(HashMap<Character, Integer> map) {
		for (char key : map.keySet()) {
    		System.out.print(key+":"+map.get(key)+";");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		char txt[] = "BACDGABCDA".toCharArray();
	    char pat[] = "ABCD".toCharArray();
	    search(txt,pat);
	}
}