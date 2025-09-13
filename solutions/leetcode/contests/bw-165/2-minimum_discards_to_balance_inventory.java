class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int windowSize, int maxAllowed) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Deque<int[]> windowQueue = new ArrayDeque<>();
        int discardCount = 0;
        int totalArrivals = arrivals.length;

        for (int currentIndex = 1; currentIndex <= totalArrivals; currentIndex++) {
            while (!windowQueue.isEmpty() && windowQueue.peek()[0] < currentIndex - windowSize + 1) {
                int valueToRemove = windowQueue.poll()[1];
                frequencyMap.put(valueToRemove, frequencyMap.get(valueToRemove) - 1);
            }

            int currentArrival = arrivals[currentIndex - 1];

            if (frequencyMap.getOrDefault(currentArrival, 0) < maxAllowed) {
                windowQueue.offer(new int[] { currentIndex, currentArrival });
                frequencyMap.put(currentArrival, frequencyMap.getOrDefault(currentArrival, 0) + 1);
            } else {
                discardCount++;
            }
        }
        return discardCount;
    }
}