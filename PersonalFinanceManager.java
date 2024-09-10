import services.FinanceService;
import models.Transaction;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalFinanceManager {
    private static FinanceService financeService = new FinanceService();
    private static Scanner userInputScanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int userChoice = userInputScanner.nextInt();
            userInputScanner.nextLine();
            switch (userChoice) {
                case 1 -> addNewTransaction();
                case 2 -> displaySummary();
                case 3 -> viewTransactionsByCategory();
                case 4 -> financeService.generateReport();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nPersonal Finance Manager");
        System.out.println("1. Add New Transaction");
        System.out.println("2. View Financial Summary");
        System.out.println("3. View Transactions by Category");
        System.out.println("4. Generate Financial Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addNewTransaction() {
        try {
            System.out.print("Enter transaction date (yyyy-MM-dd): ");
            Date transactionDate = dateFormat.parse(userInputScanner.nextLine());
            System.out.print("Enter transaction amount: ");
            double transactionAmount = userInputScanner.nextDouble();
            userInputScanner.nextLine();
            System.out.print("Enter transaction type (Income/Expense): ");
            String transactionType = userInputScanner.nextLine();
            System.out.print("Enter transaction category: ");
            String transactionCategory = userInputScanner.nextLine();
            System.out.print("Enter transaction description: ");
            String transactionDescription = userInputScanner.nextLine();
            Transaction newTransaction = new Transaction(transactionDate, transactionAmount, transactionType, transactionCategory, transactionDescription);
            financeService.addTransaction(newTransaction);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void displaySummary() {
        System.out.println("Total Income: $" + financeService.calculateTotalIncome());
        System.out.println("Total Expenses: $" + financeService.calculateTotalExpenses());
    }

    private static void viewTransactionsByCategory() {
        System.out.print("Enter category to view transactions: ");
        String category = userInputScanner.nextLine();
        financeService.viewTransactionsByCategory(category);
    }
}
