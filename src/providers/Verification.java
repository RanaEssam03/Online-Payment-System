package providers;

public abstract class Verification {

    private ConnectionAPI connection;
    public void setConnection(ConnectionAPI connection) {
        this.connection = connection;
    }
    abstract public boolean verifyAccount(String mobileNumber, String provider);
    public String getVerifierName(){
        return connection.getName();
    }
}