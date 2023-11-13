package providers;

import models.Bill;

abstract public class BillCompany {
    public abstract Bill getBill(/*Integer customerID*/);
    public abstract boolean confirmPayment();
}
