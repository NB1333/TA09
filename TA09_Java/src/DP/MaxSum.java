package DP;

import java.util.Scanner;

public class MaxSum {
    private int number;
    private int values;
    private int[] weight;
    private int[] value;
    private int[][] tempMaxSum;

    public int getNumber() {
        return number;
    }

    public int getValues() {
        return values;
    }

    public void maxSum() {
        for (int j = 0; j <= values; j++) {
            tempMaxSum[0][j] = 0;
        }

        for (int i = 1; i <= number; i++) {
            for (int j = 0; j <= values; j++) {
                if (j >= weight[i]) {
                    tempMaxSum[i][j] = Math.max(tempMaxSum[i - 1][j - weight[i]] + value[i], tempMaxSum[i - 1][j]);
                } else {
                    tempMaxSum[i][j] = tempMaxSum[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= number; i++) {
            for (int j = 0; j <= values; j++) {
                System.out.print(tempMaxSum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printResult(int number, int value) {
        boolean[] isAdd = new boolean[number + 1];

        for (int i = number; i >= 1; i--) {
            if (tempMaxSum[i][value] == tempMaxSum[i - 1][value])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                value -= weight[i];
            }
        }

        for (int i = 1; i <= number; i++) {
            System.out.print(isAdd[i] + " ");
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
        tempMaxSum = new int[number + 1][values + 1];

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
