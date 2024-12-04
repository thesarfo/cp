class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int low = 0, high = arr.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr.get(low) <= arr.get(high)){
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    index = low;
                }
                break;
            }

            if(arr.get(low) <= arr.get(mid)){
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    index = low;
                }
                low = mid + 1;

            } else{
                if(arr.get(mid) < arr.get(high)){
                    if(arr.get(mid) < ans){
                        ans = arr.get(mid);
                        index = mid;
                    }
                }
                high = mid - 1;
            }
        }
        return index;
    }
}