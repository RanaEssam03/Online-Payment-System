package models.Bills;

public class ElectricityBill extends Bill {
    static Integer billNumber = 0;
    Double unitPrice;
    Double usedAmount;

    /**
     * Constructs a new {@code ElectricityBill} instance with the specified customer ID, unit price, and used amount.
     * The bill amount is automatically calculated based on the unit price and used amount.
     *
     * @param customerID the customer identifier associated with the electricity bill
     * @param unitPrice  the unit price of electricity
     * @param usedAmount the amount of electricity used
     */
    public ElectricityBill(Integer customerID, Double unitPrice, Double usedAmount) {
        super(usedAmount * unitPrice, "E" + (++billNumber), customerID);
        setUnitPrice(unitPrice);
        setUsedAmount(usedAmount);
    }

    /**
     * Gets the unit price of electricity.
     *
     * @return the unit price
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the unit price of electricity.
     *
     * @param unitPrice the new unit price
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the amount of electricity used.
     *
     * @return the used amount
     */
    public Double getUsedAmount() {
        return usedAmount;
    }

    /**
     * Sets the amount of electricity used.
     *
     * @param usedAmount the new used amount
     */
    public void setUsedAmount(Double usedAmount) {
        this.usedAmount = usedAmount;
    }

    /**
     * Prints the details of the electricity bill.
     */
    public void printBill() {
        System.out.println("             Electricity Bill Details");
        System.out.println("Bill ID: " + billID);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Used Amount: " + usedAmount);
        System.out.println();
    }
}
