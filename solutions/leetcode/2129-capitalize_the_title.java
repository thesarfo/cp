class Solution {
    public String capitalizeTitle(String title) {
        String[] parts = title.split(" ");
        StringBuilder result = new StringBuilder();

        for(String s : parts){
            if(s.length() <= 2) {
                result.append(s.toLowerCase()).append(" ");
            } else {
                result.append(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()).append(" ");
            }
        }
        return result.toString().trim();
    }
}
