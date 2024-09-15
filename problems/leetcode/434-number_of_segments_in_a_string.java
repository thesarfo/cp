class Solution {
    public int countSegments(String s) {
        String[] segment = s.trim().split("\\s+");

        int count = s.trim().isEmpty() ? 0 : segment.length;
         
        return count;
    }
}