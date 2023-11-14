package providers;

import static Database.Data.*;

public class WalletVerification extends Verification implements BalanceGetter{
    @Override
    public boolean verifyAccount(String mobileNumber, String verifier) {
        System.out.println(verifier);
        return walletsMap.get(verifier).containsKey(mobileNumber);
    }

    @Override
    public double getBalance(String mobileNumber, String verifier) {
        return walletsMap.get(verifier).get(mobileNumber);
    }
}
