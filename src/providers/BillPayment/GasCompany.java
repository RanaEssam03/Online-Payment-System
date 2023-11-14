package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.GasBill;
import models.ConnectionAPI;


import java.util.Random;

public class GasCompany extends BillCompany {
    public GasCompany() {
        super(new ConnectionAPI("Gas_Company"));
    }
    public Bill getBill(Integer customerID) {
        Random random = new Random();
        Double billAmount = random.nextDouble(100);
        Integer gasMeterReading = random.nextInt(1000);
        GasBill gasBill = new GasBill(billAmount, customerID, gasMeterReading);
        return gasBill;
    }

    public boolean confirmPayment() {
        // TODO : could be concrete method in BillCompany??
        System.out.println("Gas bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
