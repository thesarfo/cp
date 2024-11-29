int searchInsert(vector<int>& arr, int m)
{
	// Write your code here.
	int low = 0, high = arr.size() - 1;

	while(low <= high){
		int mid = low + (high - low) / 2;
		if(arr[mid] == m){
			return mid;
		} else if(arr[mid] > m){
			high = mid - 1;
		} else{
			low = mid + 1;
		}
	}
	return low;
}