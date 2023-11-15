package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.WaterBill;
import models.ConnectionAPI;


import java.util.Random;

/**
 * The {@code WaterCompany} class represents a company providing water bills,
 * extending the {@code BillCompany} abstract class.
 * It generates random unit price and used amount to create a {@code WaterBill}.
 */
public class WaterCompany extends BillCompany {
    /**
     * Constructs a new {@code WaterCompany} instance with a predefined connection API.
     */
    public WaterCompany() {
        super(new ConnectionAPI("Water_Company"));
    }

    /**
     * Generates a random water bill for the specified customer ID.
     *
     * @param customerID the customer identifier for whom to generate the bill
     * @return the randomly generated water bill
     */
    public Bill getBill(Integer customerID) {
        // TODO : customerID problem
        Random random = new Random();
        Double unitPrice = 6.5;
        Double usedAmount = 200.5;
        WaterBill waterBill = new WaterBill(customerID, usedAmount, unitPrice);
        return waterBill;
    }

    /**
     * Confirms the payment of the water bill.
     *
     * @return {@code true} if the payment is confirmed, {@code false} otherwise
     */
    public boolean confirmPayment() {
        // TODO : could be concrete method in BillCompany??
        System.out.println("Gas bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
