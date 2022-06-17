package DP;

import java.util.Scanner;

public class MaxCount {
    private int number;
    private int values;
    private int[] weight;
    private int[] value;
    private int[] tempMaxSum;

    public void maxCount() {
        tempMaxSum[0] = 0;

        for (int i = 1; i <= values; i++) {
            int INF = 9999;
            tempMaxSum[i] = -INF;
        }

        for (int i = 1; i <= number; i++) {
            for (int j = values; j >= 0; j--) {
                if (j >= weight[i]) {
                    tempMaxSum[j] = Math.max(tempMaxSum[j - weight[i]] + value[i], tempMaxSum[j]);
                }
            }
        }

        for (int i = 0; i <= values; i++) {
            System.out.print(tempMaxSum[i] + " ");
        }
        System.out.println();
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter count of objects: ");
        number = sc.nextInt();

        System.out.println("Enter max bag size: ");
        values = sc.nextInt();

        weight = new int[number + 1];
        value = new int[number + 1];
        tempMaxSum = new int[values + 1];

        System.out.println("Enter weight of objects: ");
        for (int i = 1; i <= number; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter value of objects: ");
        for (int i = 1; i <= number; i++) {
            value[i] = sc.nextInt();
        }
    }
}
