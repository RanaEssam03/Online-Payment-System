package providers;

import java.io.IOException;

public class ConnectionAPI {
    String name;
    String api;
    public ConnectionAPI(){
        setApi("123456789");
        setName("verification API");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
