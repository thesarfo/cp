class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int lTime = events[0][1];
        int lButton = events[0][0];
        
        for (int i = 1; i < events.length; i++) {
            int dur = events[i][1] - events[i - 1][1];
            
            if (dur > lTime || (dur == lTime && events[i][0] < lButton)) {
                lTime = dur;
                lButton = events[i][0];
            }
        }
        
        return lButton;
    }
}
©leetcode