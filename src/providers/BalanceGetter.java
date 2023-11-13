package providers;

public interface BalanceGetter {
    public double getBalance(String mobileNumber, String verifier);
}
