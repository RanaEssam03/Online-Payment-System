package models.Bills;

import java.time.LocalDate;

/**
 * The {@code Bill} class is an abstract class representing a generic bill.
 * It includes basic information such as bill amount, due date, bill ID, and customer ID.
 * Subclasses must implement the {@code printBill()} method to display specific details of the bill.
 */
public abstract class Bill {
    Double billAmount;
    LocalDate dueDate;
    String billID;
    Integer customerID;

    /**
     * Constructs a new {@code Bill} instance with the specified bill amount, bill ID, and customer ID.
     * The due date is set to the current date.
     *
     * @param billAmount the amount of the bill
     * @param billID     the unique identifier for the bill
     * @param customerID the customer identifier associated with the bill
     */
    public Bill(Double billAmount, String billID, Integer customerID) {
        setBillAmount(billAmount);
        setBillID(billID);
        setCustomerID(customerID);
        setDueDate(LocalDate.now());
    }

    /**
     * Gets the bill amount.
     *
     * @return the bill amount
     */
    public Double getBillAmount() {
        return billAmount;
    }

    /**
     * Sets the bill amount.
     *
     * @param billAmount the new bill amount
     */
    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    /**
     * Gets the due date of the bill.
     *
     * @return the due date of the bill
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the bill.
     *
     * @param dueDate the new due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the bill ID.
     *
     * @return the bill ID
     */
    public String getBillID() {
        return billID;
    }

    /**
     * Sets the bill ID.
     *
     * @param billID the new bill ID
     */
    public void setBillID(String billID) {
        this.billID = billID;
    }

    /**
     * Gets the customer ID associated with the bill.
     *
     * @return the customer ID
     */
    public Integer getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID associated with the bill.
     *
     * @param customerID the new customer ID
     */
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    /**
     * Abstract method to print details of the bill.
     * Subclasses must implement this method to provide specific bill details.
     */
    public abstract void printBill();
}
