class TrendChange {

	//the usual binary search
	static int search(int [] input, int start, int end, int search) {
		if(start > end)
			return -1;
		int mid = (start+end)/2;

		if(input[mid] == search)
			return search;
		else if(input[mid] > search)
			return search(input,start,mid-1,search);
		else
			return search(input,mid+1,end,search);
	}

	//the modified trend change finder
	//assuming 

	static int trendSearch(int [] arr, int start, int end) {

		if(start > end)
			return -1;

		int mid = (start+end)/2;

		if(arr[mid] > arr[start])
			return trendSearch(arr,mid+1,end);
		else if(arr[mid] < arr[start])
			return trendSearch(arr,start,mid-1);
		else
			return arr[mid];

	}

	public static void main(String[] args) {
		int [] input = {1,2,3,4,5,3,2};
		//System.out.println(search(input,0,input.length-1,5));
		System.out.println(trendSearch(input,0,input.length-1));
	}
}