/*
 AmagicindexinanarrayA[l...n-l] isdefinedtobeanindexsuchthatA[i] = i. Given a
 sorted array of distinct integers, write a method to find a magic index, if
 one exists, in array A.
*/

 class MagicIndex {

 	static int returnMagicIndex(int [] input, int start, int end) {

 		if( end < start || start < 0 || end >= input.length)
 			return -1;
 		int mid = (start+end)/2;
 		if(input[mid] == mid)
 			return mid;
 		else if(input[mid] < mid)
 			return returnMagicIndex(input,mid+1,end);
 		else
 			return returnMagicIndex(input,start,mid-1);

 	}

 	static int returnMagicIndexWithDuplicates(int [] input, int start, int end) {

 		if( end < start || start < 0 || end >= input.length)
 			return -1;

 		int mid = (start+end)/2;
 		if(input[mid] == mid)
 			return mid;

 		int leftIndex = Math.min(mid-1,input[mid]);
 		int left = returnMagicIndexWithDuplicates(input,start,leftIndex);
 		if(left >=0)
 			return left;

 		int rightIndex = Math.max(input[mid],mid+1);
 		int right = returnMagicIndexWithDuplicates(input,rightIndex,end);
 		return right;

 	}

 	public static void main(String [] args) {
 		int input [] = {-18, -5, 2, 2, 2, 1, 4, 7, 9, 12, 13};

 		System.out.println(returnMagicIndexWithDuplicates(input,0,input.length-1));
 	}

 }