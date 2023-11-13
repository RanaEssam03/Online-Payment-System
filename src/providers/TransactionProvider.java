package providers;

import java.io.IOException;

abstract public class TransactionProvider {
    ConnectionAPI connection;

    public TransactionProvider(String name) {
        this.connection = new ConnectionAPI(name);
    }

    /**
     * this method is used to get the balance of the user from the remote server
     *
     * @param mobileNumber the mobile number of the user
     * @return
     * @throws IOException
     */
    public abstract double getBalance(String mobileNumber) throws IOException;

    /**
     * this method is used to withdraw money from the user account from the remote server
     *
     * @param amount
     * @return
     */
    public abstract boolean withDraw(double amount);

    /**
     * this method is used to transfer money to another user account from the remote server
     *
     * @param amount
     * @param mobileNumber
     * @return
     * @throws IOException
     */
    public abstract boolean transferToWallet(double amount, String mobileNumber) throws IOException;



}
