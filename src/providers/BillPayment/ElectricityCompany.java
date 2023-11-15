package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.ElectricityBill;
import models.ConnectionAPI;
import providers.BillPayment.BillCompany;

import java.util.Random;

/**
 * The {@code ElectricityCompany} class represents a company providing electricity bills,
 * extending the {@code BillCompany} abstract class.
 * It generates random unit price and used amount to create an {@code ElectricityBill}.
 */
public class ElectricityCompany extends BillCompany {
    /**
     * Constructs a new {@code ElectricityCompany} instance with a predefined connection API.
     */
    public ElectricityCompany() {
        super(new ConnectionAPI("Electricity_Company"));
    }

    /**
     * Generates a random electricity bill for the specified customer ID.
     *
     * @param customerID the customer identifier for whom to generate the bill
     * @return the randomly generated electricity bill
     */
    public Bill getBill(Integer customerID) {
        Random random = new Random();
        Double unitPrice = random.nextDouble(2);
        Double usedAmount = random.nextDouble(1000);
        ElectricityBill electricityBill = new ElectricityBill(customerID, unitPrice, usedAmount);
        return electricityBill;
    }

    /**
     * Confirms the payment of the electricity bill.
     *
     * @return {@code true} if the payment is confirmed, {@code false} otherwise
     */
    public boolean confirmPayment() {
        System.out.println("Electricity bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
