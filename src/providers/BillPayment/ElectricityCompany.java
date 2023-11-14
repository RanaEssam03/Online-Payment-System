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
    public Bill getBill(Integer customerID) {
        Random random = new Random();
        Double unitPrice = random.nextDouble(1000);
        Double usedAmount = random.nextDouble(1000);
        ElectricityBill electricityBill = new ElectricityBill(customerID, unitPrice, usedAmount);
        return electricityBill;
    }

    public boolean confirmPayment() {
        // TODO : could be concrete method in BillCompany??
        System.out.println("Electricity bill payment confirmed using " + connectionAPI.getApiURL());
        return true;
    }
}
