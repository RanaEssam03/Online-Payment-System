package models.Bills;

public class WaterBill extends Bill {
    static Integer billNumber = 0;
    Double usedAmount;
    Double unitPrice;
    public WaterBill(Integer customerID, Double usedAmount, Double unitPrice){
        super(usedAmount*unitPrice, "W" + (++billNumber), customerID);
        setUsedAmount(unitPrice);
        setUnitPrice(unitPrice);
    }

    public Double getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Double usedAmount) {
        this.usedAmount = usedAmount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public void printBill(){
        System.out.println("             Water Bill Details");
        System.out.println("Bill ID: " + billID);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Used Amount: " + usedAmount);
        System.out.println();
    }
}
