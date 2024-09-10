package services;

import models.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FinanceService {
    private List<Transaction> allTransactions;

    public FinanceService() {
        allTransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction newTransaction) {
        allTransactions.add(newTransaction);
        System.out.println("Transaction added: " + newTransaction);
    }

    public double calculateTotalIncome() {
        return allTransactions.stream()
                .filter(transaction -> transaction.getTransactionType().equalsIgnoreCase("Income"))
                .mapToDouble(Transaction::getTransactionAmount)
                .sum();
    }

    public double calculateTotalExpenses() {
        return allTransactions.stream()
                .filter(transaction -> transaction.getTransactionType().equalsIgnoreCase("Expense"))
                .mapToDouble(Transaction::getTransactionAmount)
                .sum();
    }

    public void generateReport() {
        double totalIncome = calculateTotalIncome();
        double totalExpenses = calculateTotalExpenses();
        double totalSavings = totalIncome - totalExpenses;
        System.out.println("Financial Report:");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Total Savings: $" + totalSavings);
    }

    public void viewTransactionsByCategory(String category) {
        List<Transaction> filteredTransactions = allTransactions.stream()
                .filter(transaction -> transaction.getTransactionCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        if (filteredTransactions.isEmpty()) {
            System.out.println("No transactions found in category: " + category);
        } else {
            filteredTransactions.forEach(System.out::println);
        }
    }
}
