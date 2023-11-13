package services;

import models.Bill;
import providers.BillCompany;
import providers.ElectricityCompany;
import providers.GasCompany;
import providers.WaterCompany;
import java.util.Objects;
import java.util.Scanner;

public abstract class BillServices {
    BillCompany billCompany;
    // TODO : transaction provider
    public Bill inquire(){
        Scanner in = new Scanner(System.in);
        String billType = in.nextLine();
        if (Objects.equals(billType, "Gas"))
            billCompany = new GasCompany();
        else if (Objects.equals(billType, "Water"))
            billCompany = new WaterCompany();
        else if (Objects.equals(billType, "Electricity"))
            billCompany = new ElectricityCompany();
        return billCompany.getBill();
    }
    public boolean pay(Bill bill){
        // TODO : i cannot pay if i can't check the account balance to firstly confirm it's a valid payment
        return true;
    }
}
