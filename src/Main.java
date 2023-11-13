import services.GUIManager;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our online payment system");
        GUIManager guiManager = new GUIManager();
        guiManager.authenticate();

        //menu for logging in and using all the app's features
    }
}
