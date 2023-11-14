package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.WaterBill;
import models.ConnectionAPI;


import java.util.Random;

public class WaterCompany extends BillCompany {

    public WaterCompany() {
        super(new ConnectionAPI("Water_Company"));
    }
    public Bill getBill(Integer customerID) {
        // TODO : customerID problem
        Random random = new Random();
        Double unitPrice = random.nextDouble(1000);
        Double usedAmount = random.nextDouble(1000);
        WaterBill waterBill = new WaterBill(customerID, usedAmount, unitPrice);
        return waterBill;
    }

    public boolean confirmPayment() {
        // TODO : could be concrete method in BillCompany??
        System.out.println("Gas bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
