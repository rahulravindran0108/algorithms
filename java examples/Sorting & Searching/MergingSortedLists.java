/*
* You are given two sorted arrays, A and B, where A has a large enough buffer at the
* end to hold B. Write a method to merge B into A in sorted order.
*/

class MergingSortedLists {

	static void merge(int [] a, int [] b, int lastA, int lastB) {
		int indexA = lastA-1;
		int indexB = lastB - 1;
		int mergedIndex = lastA+lastB-1;

		//now begin sorting from last element
		while(indexA >= 0 && indexB >= 0) {
			if(a[indexA] > b[indexB]) {
				a[mergedIndex] = a[indexA];
				mergedIndex--;
				indexA--;

			} else {
				a[mergedIndex] = b[indexB];
				indexB--;
				mergedIndex--;
			}
		}

		while(indexB >= 0) {
			a[mergedIndex] = b[indexB];
			indexB--;
			mergedIndex--;
		}

		display(a);
	}

	static void display(int [] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void main(String[] args) {
		int [] a = {2,4,9,0,0,0}; //the 0 at the end indicate empty buffer
		int [] b = {1,4,10};

		merge(a,b,3,3);
	}
}