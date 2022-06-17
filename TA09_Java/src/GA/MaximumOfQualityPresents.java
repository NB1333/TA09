package GA;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class MaximumOfQualityPresents {
    public int requestSum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int number(int[] quality) {
        int counter = 0;

        for (int i = 0; i < quality.length; i++) {
            if (quality[i] >= 7 && quality[i] < 9) {
                counter++;
            }
        }
        return counter;
    }

    public int[] weights(int[] presentType, int[] quality, int[] cost) {
        int counter = number(quality);
        int[] weights = new int[counter];
        int j = 0;
        for (int i = 0; i < quality.length; i++) {
            if (quality[i] >= 7 && quality[i] < 9) {
                weights[j] = cost[i] * presentType[i];
                j++;
            }
        }
        return weights;
    }

    public int[] costs(int[] presentType, int[] quality) {
        int counter = number(quality);
        int[] costs = new int[counter];
        int j = 0;
        for (int i = 0; i < quality.length; i++) {
            if (quality[i] >= 7 && quality[i] < 9) {
                costs[j] = presentType[i];
                j++;
            }
        }
        return costs;

    }

    public int solve(int required, int[] typeOfPresent, int[] quality, int[] price) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        int[] sumcosts = weights(typeOfPresent, quality, price);
        int[] number = costs(typeOfPresent, quality);
        int presents = 0;

        for (int i = 0; i < sumcosts.length; i++) {
            map.put(number[i], sumcosts[i]);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) < required) {
                required -= map.get(key);
                presents += key;
            } else if (map.get(key) / key < required) {
                required -= map.get(key) / key;
                presents += 1;
            }
        }
        return presents;
    }
}
