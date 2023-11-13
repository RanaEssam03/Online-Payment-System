package providers;

import models.Bill;
import models.GasBill;
import java.util.Random;

public class GasCompany extends BillCompany{
    public Bill getBill(/*Integer customerID*/) {
        // TODO : customerID problem
        Random random = new Random();
        Double billAmount = random.nextDouble(100);
        Integer gasMeterReading = random.nextInt(1000);
        Integer usedAmount = random.nextInt(1000);
        GasBill gasBill = new GasBill(billAmount, 1, gasMeterReading, usedAmount);
        return gasBill;
    }

    public boolean confirmPayment() {
        // TODO : how to confirm payment if i dont have access to the account of the customer
        return false;
    }
}
