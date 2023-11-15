package providers.BillPayment;

import models.Bills.Bill;
import models.ConnectionAPI;

/**
 * The {@code BillCompany} class is an abstract class representing a company providing bills for payment.
 * It includes a connection to an API and abstract methods for getting a bill and confirming payment.
 */
abstract public class BillCompany {

    ConnectionAPI connectionAPI;

    /**
     * Constructs a new {@code BillCompany} instance with the specified connection API.
     *
     * @param connectionAPI the connection API for interacting with the company's billing system
     */
    public BillCompany(ConnectionAPI connectionAPI) {
        this.connectionAPI = connectionAPI;
    }

    /**
     * Abstract method to get a bill for a specific customer.
     *
     * @param customerID the customer identifier for whom to retrieve the bill
     * @return the bill associated with the customer
     */

    public abstract Bill getBill(Integer customerID);

    /**
     * Abstract method to confirm the payment of a bill.
     *
     * @return {@code true} if the payment is confirmed, {@code false} otherwise
     */
    public abstract boolean confirmPayment();

}
