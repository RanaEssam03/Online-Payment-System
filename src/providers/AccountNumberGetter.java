package providers;

public interface AccountNumberGetter {
    public String getAccountNumber(String mobileNumber, String verifier);
}
