package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.GasBill;
import models.ConnectionAPI;


import java.util.Random;

/**
 * The {@code GasCompany} class represents a company providing gas bills,
 * extending the {@code BillCompany} abstract class.
 * It generates a random bill amount and gas meter reading to create a {@code GasBill}.
 */
public class GasCompany extends BillCompany {
    /**
     * Constructs a new {@code GasCompany} instance with a predefined connection API.
     */
    public GasCompany() {
        super(new ConnectionAPI("Gas_Company"));
    }

    /**
     * Generates a random gas bill for the specified customer ID.
     *
     * @param customerID the customer identifier for whom to generate the bill
     * @return the randomly generated gas bill
     */
    public Bill getBill(Integer customerID) {
        Random random = new Random();
        Double billAmount = random.nextDouble(100);
        Integer gasMeterReading = random.nextInt(1000);
        GasBill gasBill = new GasBill(billAmount, customerID, gasMeterReading);
        return gasBill;
    }

    /**
     * Confirms the payment of the gas bill.
     *
     * @return {@code true} if the payment is confirmed, {@code false} otherwise
     */
    public boolean confirmPayment() {

        System.out.println("Gas bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
