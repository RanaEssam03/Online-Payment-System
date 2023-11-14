package models.Bills;

public class GasBill extends Bill {
    Integer gasMeterReading;
    static Integer billNumber = 0;
    public GasBill(Double billAmount, Integer customerID, Integer gasMeterReading){
        super(billAmount, "G" +(++billNumber), customerID);
        setGasMeterReading(gasMeterReading);
    }

    public Integer getGasMeterReading() {
        return gasMeterReading;
    }

    public void setGasMeterReading(Integer gasMeterReading) {
        this.gasMeterReading = gasMeterReading;
    }

    public void printBill(){
        System.out.println("             Gas Bill Details");
        System.out.println("Bill ID: " + billID);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Gas Meter Reading: " + gasMeterReading);
        System.out.println();
    }
}
