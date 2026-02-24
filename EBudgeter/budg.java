import java.util.Scanner;

public class budg {
    public static void intro() {
        System.out.println(
                "Welcome to E's SUPER SIMPLE, slightly inaccurate, Monthly Budget Calculator! (post expenses)");
        System.out.println("For all inputs, please enter numbers only (no $, commas, or %).");
        System.out.println("Let's get started!");
    }

    public static void calculateBudget(double income, double expenses, double rothP, double savingsP,
            double spendingP) {
        double leftover = income - expenses;
        double roth = leftover * rothP;
        double savings = leftover * savingsP;
        double spending = leftover * spendingP;

        System.out.println("Your budget breakdown:");
        System.out.printf("Roth IRA Contributions: $%.2f\n", roth);
        System.out.printf("Savings: $%.2f\n", savings);
        System.out.printf("Spending: $%.2f\n", spending);
    }

    public static double percentageGetter(int percentage) {
        return (double) percentage / 100;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double income; // Monthly income
        double expenses; // Monthly expenses

        // Intro
        intro();
        System.out.println();

        // Get user input for income and expenses
        System.out.print("Enter your monthly income: ");
        income = scnr.nextDouble();
        System.out.print("Enter your monthly expenses: ");
        expenses = scnr.nextDouble();

        // Splitting 50% roth, 30% savings, 20% spendings
        System.out.println();
        System.out.println(
                "What % of your leftover money would you like to allocate to Roth IRA contributions? (Default is 50%)");
        int rothPercentage = scnr.nextInt();
        double rothP = percentageGetter(rothPercentage);
        System.out.println(
                "What % of your leftover money would you like to allocate to Savings? (Default is 30%)");
        int savingsPercentage = scnr.nextInt();
        double savingsP = percentageGetter(savingsPercentage);
        System.out.println(
                "What % of your leftover money would you like to allocate to Spending? (Default is 20%)");
        int spendingPercentage = scnr.nextInt();
        double spendingP = percentageGetter(spendingPercentage);

        // Calculate and display the budget breakdown
        System.out.println();
        System.out.println("Calculating your budget...");
        System.out.println();
        calculateBudget(income, expenses, rothP, savingsP, spendingP);
    }
}
