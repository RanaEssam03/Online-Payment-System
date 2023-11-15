package models.Bills;

/**
 * The {@code WaterBill} class represents a specific type of bill for water usage,
 * extending the abstract {@code Bill} class.
 * It includes additional details such as used amount and unit price specific to water billing.
 */
public class WaterBill extends Bill {
    static Integer billNumber = 0;
    Double usedAmount;
    Double unitPrice;

    /**
     * Constructs a new {@code WaterBill} instance with the specified customer ID, used amount, and unit price.
     * The bill amount is automatically calculated based on the used amount and unit price.
     *
     * @param customerID the customer identifier associated with the water bill
     * @param usedAmount the amount of water used
     * @param unitPrice  the unit price of water
     */
    public WaterBill(Integer customerID, Double usedAmount, Double unitPrice) {
        super(usedAmount * unitPrice, "W" + (++billNumber), customerID);
        setUsedAmount(unitPrice);
        setUnitPrice(unitPrice);
    }

    /**
     * Gets the amount of water used.
     *
     * @return the used amount
     */
    public Double getUsedAmount() {
        return usedAmount;
    }

    /**
     * Sets the amount of water used.
     *
     * @param usedAmount the new used amount
     */
    public void setUsedAmount(Double usedAmount) {
        this.usedAmount = usedAmount;
    }

    /**
     * Gets the unit price of water.
     *
     * @return the unit price
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the unit price of water.
     *
     * @param unitPrice the new unit price
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Prints the details of the water bill.
     */
    public void printBill() {
        System.out.println("             Water Bill Details");
        System.out.println("Bill ID: " + billID);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Used Amount: " + usedAmount);
        System.out.println();
    }
}
