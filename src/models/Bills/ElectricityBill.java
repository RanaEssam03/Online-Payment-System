package models.Bills;

public class ElectricityBill extends Bill {
    static Integer billNumber = 0;
    Double unitPrice;
    Double usedAmount;
    public ElectricityBill(Integer customerID, Double unitPrice, Double usedAmount){
        super(usedAmount*unitPrice, "E" + (++billNumber), customerID);
        setUnitPrice(unitPrice);
        setUsedAmount(usedAmount);
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Double usedAmount) {
        this.usedAmount = usedAmount;
    }
    public void printBill(){
        System.out.println("             Electricity Bill Details");
        System.out.println("Bill ID: " + billID);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Used Amount: " + usedAmount);
        System.out.println();
    }
}
