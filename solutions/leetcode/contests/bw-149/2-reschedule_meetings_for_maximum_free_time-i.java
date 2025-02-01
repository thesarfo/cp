import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int totalEvents = startTime.length;
        int maxFreeTime = 0;
        int currentFreeTime = 0;
        
        List<Integer> freeTimeList = new ArrayList<>();
        
        freeTimeList.add(startTime[0]); 
        for (int i = 1; i < totalEvents; i++) {
            freeTimeList.add(startTime[i] - endTime[i - 1]); 
        }
        freeTimeList.add(eventTime - endTime[totalEvents - 1]); 
        
        for (int i = 0; i <= k; i++) {
            currentFreeTime += freeTimeList.get(i);
        }
        maxFreeTime = currentFreeTime;
        
        for (int i = k + 1; i < freeTimeList.size(); i++) {
            currentFreeTime += freeTimeList.get(i) - freeTimeList.get(i - (k + 1));
            maxFreeTime = Math.max(maxFreeTime, currentFreeTime);
        }
        
        return maxFreeTime;
    }
}
