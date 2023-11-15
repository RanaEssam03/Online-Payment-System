package models;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The {@code ConnectionAPI} class represents a basic model for connecting to an API.
 * It provides methods to get and set the name and API URL.
 * The API URL is automatically generated based on the provided name.
 */
public class ConnectionAPI {
    String name;
    String apiURL;

    /**
     * Constructs a new {@code ConnectionAPI} instance with the specified name.
     *
     * @param name the name of the API
     */
    public ConnectionAPI(String name) {
        this.name = name;
        this.apiURL = "https://" + name + ".com";
    }

    /**
     * Gets the name of the API.
     *
     * @return the name of the API
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the API.
     *
     * @param name the new name for the API
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the API URL.
     *
     * @return the API URL
     */
    public String getApiURL() {
        return apiURL;
    }

    /**
     * Sets the API URL.
     *
     * @param apiURL the new API URL
     */
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }
}
