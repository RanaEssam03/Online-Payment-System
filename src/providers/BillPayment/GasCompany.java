package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.GasBill;
import models.ConnectionAPI;


import java.util.Random;

public class GasCompany extends BillCompany {
    public GasCompany() {
        super(new ConnectionAPI("Gas_Company"));
    }
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
        // TODO:could be concrete method in BillCompany??
        // TODO : how to confirm payment if i dont have access to the account of the customer
        System.out.println("Gas bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
