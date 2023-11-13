package models;

import java.io.FileNotFoundException;
import java.io.IOException;

public  class ConnectionAPI {
    String name;
    String apiURL;
    public ConnectionAPI(String name) {
        this.name = name;
        this.apiURL = "https://"+name+".com";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }
}
