package providers;

import java.io.FileNotFoundException;
import java.io.IOException;

public  class ConnectionAPI {
    String name;
    String apiURL;
    public ConnectionAPI(String name) {
        this.name = name;
        this.apiURL = "https://"+name+".com";
    }

}
