package models;

import java.util.Date;

public class Transaction {
    private Date transactionDate;
    private double transactionAmount;
    private String transactionType; 
    private String transactionCategory;
    private String transactionDescription;

    public Transaction(Date transactionDate, double transactionAmount, String transactionType, String transactionCategory, String transactionDescription) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
        this.transactionDescription = transactionDescription;
    }

    public Date getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }
    public double getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(double transactionAmount) { this.transactionAmount = transactionAmount; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public String getTransactionCategory() { return transactionCategory; }
    public void setTransactionCategory(String transactionCategory) { this.transactionCategory = transactionCategory; }
    public String getTransactionDescription() { return transactionDescription; }
    public void setTransactionDescription(String transactionDescription) { this.transactionDescription = transactionDescription; }

    @Override
    public String toString() {
        return "Transaction [Date=" + transactionDate + ", Amount=" + transactionAmount + ", Type=" + transactionType + 
               ", Category=" + transactionCategory + ", Description=" + transactionDescription + "]";
    }
}
