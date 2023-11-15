package models.Bills;

/**
 * The {@code GasBill} class represents a specific type of bill for gas usage,
 * extending the abstract {@code Bill} class.
 * It includes additional details such as gas meter reading specific to gas billing.
 */
public class GasBill extends Bill {
    Integer gasMeterReading;
    static Integer billNumber = 0;

    /**
     * Constructs a new {@code GasBill} instance with the specified bill amount, customer ID, and gas meter reading.
     *
     * @param billAmount      the amount of the gas bill
     * @param customerID      the customer identifier associated with the gas bill
     * @param gasMeterReading the gas meter reading
     */
    public GasBill(Double billAmount, Integer customerID, Integer gasMeterReading) {
        super(billAmount, "G" + (++billNumber), customerID);
        setGasMeterReading(gasMeterReading);
    }

    /**
     * Gets the gas meter reading.
     *
     * @return the gas meter reading
     */
    public Integer getGasMeterReading() {
        return gasMeterReading;
    }

    /**
     * Sets the gas meter reading.
     *
     * @param gasMeterReading the new gas meter reading
     */
    public void setGasMeterReading(Integer gasMeterReading) {
        this.gasMeterReading = gasMeterReading;
    }

    /**
     * Prints the details of the gas bill.
     */
    public void printBill() {
        System.out.println("             Gas Bill Details");
        System.out.println("Bill ID: " + billID);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Gas Meter Reading: " + gasMeterReading);
        System.out.println();
    }
}
