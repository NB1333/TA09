package GA;

import java.util.TreeMap;

public class MinimalCountOfBanknotes {
    public int requiredSum(int[] presentType, int[] quality, int[] cost, int presents) {
        int finalSum = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < quality.length; i++) {
            if (quality[i] >= 5 && quality[i] < 7) {
                map.put(cost[i], presentType[i]);
            }
        }

        for (Integer key : map.keySet()) {
            if (presents > 0) {
                if (presents > map.get(key)) {
                    presents -= map.get(key);
                    finalSum += key * map.get(key);
                } else {
                    finalSum += key * presents;
                    presents = 0;
                }
            }
        }
        return finalSum;
    }

    public int solve(int sum, int[] nominal) {
        int vid = 0;

        for (int i = nominal.length - 1; i > 0; i--) {
            int nom = nominal[i];
            while (sum - nom >= 0) {
                sum -= nom;
                vid++;
            }
        }
        return vid;
    }
}
