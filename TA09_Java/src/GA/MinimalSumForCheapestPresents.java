package GA;

import java.util.TreeMap;

public class MinimalSumForCheapestPresents {
    public TreeMap<Integer, Integer> getPresentsByQuality(int[] presentType, int[] quality, int[] price) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < quality.length; i++) {

            if (quality[i] >= 9 && quality[i] <= 10) {
                map.put(price[i], presentType[i]);
            }
        }
        return map;
    }

    public int solve(TreeMap<Integer, Integer> newMap, int numberOfPresents) {
        int minSum = 0;

        for (Integer key : newMap.keySet()) {
            if (numberOfPresents > 0) {
                if (numberOfPresents > newMap.get(key)) {
                    numberOfPresents -= newMap.get(key);
                    minSum += key * newMap.get(key);
                } else {
                    minSum += key * numberOfPresents;
                    numberOfPresents = 0;
                }
            }
        }
        return minSum;
    }
}
