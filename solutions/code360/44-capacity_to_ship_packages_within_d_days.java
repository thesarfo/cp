public class Solution {
    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
        int max = 0, sum = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
            sum += weight;
        }

        int low = max, high = sum;
        int answer = high;

        while(low <= high){
            int mid = (low + high) / 2;

            int daysReq = findDays(weights, mid);

            if(daysReq <= d){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }

    public static int findDays(int[] weights, int capacity){
        int days = 1, load = 0;

        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > capacity){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
}