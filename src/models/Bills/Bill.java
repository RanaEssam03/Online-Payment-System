package models.Bills;

import java.time.LocalDate;

public abstract class Bill {
    Double billAmount;
    LocalDate dueDate;
    String billID;
    Integer customerID;
    public Bill(Double billAmount, String  billID, Integer customerID){
        setBillAmount(billAmount);
        setBillID(billID);
        setCustomerID(customerID);
        this.dueDate = LocalDate.now();
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }
}
