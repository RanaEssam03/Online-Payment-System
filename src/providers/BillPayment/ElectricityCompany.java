package providers.BillPayment;

import models.Bills.Bill;
import models.Bills.ElectricityBill;
import models.ConnectionAPI;
import providers.BillPayment.BillCompany;

import java.util.Random;

public class ElectricityCompany extends BillCompany {
    public ElectricityCompany() {
        super(new ConnectionAPI("Electricity_Company"));
    }
    public Bill getBill(/*Integer customerID*/) {

        Random random = new Random();
        Double billAmount = random.nextDouble(100);
        Double unitPrice = random.nextDouble(1000);
        Double usedAmount = random.nextDouble(1000);
        ElectricityBill electricityBill = new ElectricityBill(billAmount, 1, unitPrice, usedAmount);
        return electricityBill;
    }

    public boolean confirmPayment() {
        System.out.println("Electricity bill payment confirmed");
        return true;
    }
}
