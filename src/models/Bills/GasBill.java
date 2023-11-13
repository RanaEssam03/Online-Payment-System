package models.Bills;

public class GasBill extends Bill {
    Integer gasMeterReading;
    Integer usedAmount;
    static Integer billNumber = 0;
    public GasBill(Double billAmount, Integer customerID, Integer gasMeterReading, Integer usedAmount){
        super(billAmount, "G" +(++billNumber), customerID);
        this.gasMeterReading = gasMeterReading;
        this.usedAmount = usedAmount;
    }

    public Integer getGasMeterReading() {
        return gasMeterReading;
    }

    public void setGasMeterReading(Integer gasMeterReading) {
        this.gasMeterReading = gasMeterReading;
    }

    public Integer getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Integer usedAmount) {
        this.usedAmount = usedAmount;
    }
}
