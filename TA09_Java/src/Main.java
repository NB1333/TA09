import DP.MaxCount;
import DP.MaxSum;
import GA.MinimalCountOfBanknotes;
import GA.MaximumOfQualityPresents;
import GA.MinimalSumForCheapestPresents;

public class Main {
    public static void main(String[] args) {
        MaxSum newMS = new MaxSum();

        System.out.println("Task 1 (Dynamic programming)");

        newMS.init();
        newMS.maxSum();
        newMS.printResult(newMS.getNumber(), newMS.getValues());

        MaxCount newMC = new MaxCount();
        newMC.init();
        newMC.maxCount();

        MinimalCountOfBanknotes newGA = new MinimalCountOfBanknotes();

        Banknotes banknotes = new Banknotes();

        int[] numberPresentOfType = {5, 10, 11, 13, 7};
        int[] quality = {7, 10, 7, 6, 8,};
        int[] prices = {1150, 54, 4000, 100, 90};
        int countOfPresents = 10;

        System.out.println("\nTask 2 (Greedy algorithm)\nRequired sum: " +
                newGA.requiredSum(numberPresentOfType, quality, prices, countOfPresents));

        System.out.println("The minimal number of banknotes needed to buy the cheapest medium quality present: " +
                newGA.solve(
                        newGA.requiredSum(numberPresentOfType, quality, prices, countOfPresents),
                        banknotes.getBanknotes()));

        MaximumOfQualityPresents newGA2 = new MaximumOfQualityPresents();

        System.out.println("Enter required sum: ");
        int newSum = newGA2.requestSum();

        System.out.println("Max number of presents that we can buy for " + newSum + " is " +
                newGA2.solve(newSum, numberPresentOfType, quality, prices));

        MinimalSumForCheapestPresents newGA3 = new MinimalSumForCheapestPresents();

        System.out.println("The minimum sum of the cheapest presents with the highest quality");

        System.out.println("Result: " +
                newGA3.solve(newGA3.getPresentsByQuality(numberPresentOfType, quality, prices),
                        countOfPresents));
    }
}