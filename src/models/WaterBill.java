package models;

public class WaterBill extends Bill{
    static Integer billNumber = 0;
    Double usedAmount;
    Double unitPrice;
    public WaterBill(Double billAmount, Integer customerID, Double usedAmount, Double unitPrice){
        super(billAmount, "W" + (++billNumber), customerID);
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
}
