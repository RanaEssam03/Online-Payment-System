package models.Bills;

public class ElectricityBill extends Bill {
    static Integer billNumber = 0;
    Double unitPrice;
    Double usedAmount;
    public ElectricityBill(Double billAmount, Integer customerID, Double unitPrice, Double usedAmount){
        super(billAmount, "E" + (++billNumber), customerID);
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
}
