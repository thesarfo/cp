class Solution {
    public long minDamage(int attackPower, int[] damagePerSecond, int[] hitPoints) {
        int enemyCount = damagePerSecond.length;
        List<int[]> enemyStats = new ArrayList<>();

        for (int i = 0; i < enemyCount; ++i) {
            enemyStats.add(new int[]{damagePerSecond[i], hitPoints[i]});
        }

        enemyStats.sort((e1, e2) -> {
            long priority1 = (long) e1[0] * ((e2[1] + attackPower - 1) / attackPower);
            long priority2 = (long) e2[0] * ((e1[1] + attackPower - 1) / attackPower);
            return Long.compare(priority2, priority1);
        });

        long cumulativeDamage = 0;
        long activeEnemiesDamage = 0;

        for (int[] enemyData : enemyStats) {
            activeEnemiesDamage += enemyData[0];
        }

        for (int[] enemyData : enemyStats) {
            int turnsToDefeat = (enemyData[1] + attackPower - 1) / attackPower;
            cumulativeDamage += turnsToDefeat * activeEnemiesDamage;
            activeEnemiesDamage -= enemyData[0];
        }

        return cumulativeDamage;
    }
}