package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.WaterBill;
import models.ConnectionAPI;


import java.util.Random;

public class WaterCompany extends BillCompany {

    public WaterCompany() {
        super(new ConnectionAPI("Water_Company"));
    }
    public Bill getBill(/*Integer customerID*/) {
        // TODO : customerID problem
        Random random = new Random();
        Double billAmount = random.nextDouble(100);
        Double unitPrice = random.nextDouble(1000);
        Double usedAmount = random.nextDouble(1000);
        WaterBill waterBill = new WaterBill(billAmount, 1, usedAmount, unitPrice);
        return waterBill;
    }

    public boolean confirmPayment() {
        // TODO : how to confirm payment if i dont have access to the account of the customer
        System.out.println("Water bill payment confirmed");
        return true;
    }
}
