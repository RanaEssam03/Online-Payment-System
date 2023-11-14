package providers.BillPayment;

import models.Bills.Bill;
import models.ConnectionAPI;

abstract public class BillCompany {

    ConnectionAPI connectionAPI;

    public BillCompany(ConnectionAPI connectionAPI) {
        this.connectionAPI = connectionAPI;
    }

    public abstract Bill getBill(Integer customerID);
    public abstract boolean confirmPayment();

}
