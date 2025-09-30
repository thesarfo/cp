class Solution {
    public int[][] generateSchedule(int teamCount) {
        if (teamCount <= 3 || teamCount == 4) return new int[0][0];

        List<int[]> allGames = new ArrayList<>(teamCount * (teamCount - 1));
        for (int home = 0; home < teamCount; home++)
            for (int away = 0; away < teamCount; away++)
                if (home != away) allGames.add(new int[]{home, away});

        Random random = new Random(777);
        final int maxAttempts = 2000;

        List<int[]> schedule = new ArrayList<>();
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            Collections.shuffle(allGames, random);
            List<int[]> gamesPool = new ArrayList<>(allGames);
            schedule.clear();

            int lastHome = -1, lastAway = -1, chosenIndex;

            while (!gamesPool.isEmpty()) {
                chosenIndex = -1;
                for (int i = 0; i < gamesPool.size(); i++) {
                    int[] game = gamesPool.get(i);
                    chosenIndex = (game[0] != lastHome && game[0] != lastAway && game[1] != lastHome && game[1] != lastAway) ? i : chosenIndex;
                    if (chosenIndex != -1) break;
                }
                if (chosenIndex == -1) break;

                int[] chosenGame = gamesPool.remove(chosenIndex);
                lastHome = chosenGame[0];
                lastAway = chosenGame[1];
                schedule.add(chosenGame);
            }

            if (schedule.size() == teamCount * (teamCount - 1))
                return schedule.toArray(new int[0][0]);
        }
        return new int[0][0];
    }
}©leetcode