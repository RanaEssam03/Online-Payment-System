package providers;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class APIProvider { //We don't need the api string
    // The subclasses their verifying have the same implementation, we don't need them
    APIProvider(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getProviderAPI() {
        return providerAPI;
    }

    public void setProviderAPI(String providerAPI) {
        this.providerAPI = providerAPI;
    }

    private String providerAPI;
    public abstract double verifyAccount(String mobileNumber) throws IOException;
}
