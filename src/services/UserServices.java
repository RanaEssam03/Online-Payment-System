package services;

import models.Account;
import providers.APIProvider;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserServices {
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    public  boolean register(Account account, String mobileNumber, APIProvider provider) throws IOException {
        double balance = provider.verifyAccount(mobileNumber);
        if(balance == -1){
            return false;
        }
        account.setBalance(balance);
        account.setMobile(mobileNumber);
        System.out.println("Please enter the following details:- ");
        String name;
        String email;
        String password;
        String password2;
        System.out.print("Name: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        System.out.print("\n");
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        System.out.print("Email: ");
        email = in.nextLine();
        while(!patternMatches(email, emailRegex)){
            System.out.println("Invalid email format, please re-enter your email: ");
            email = in.nextLine();
        }
        account.setEmail(email);
        System.out.print("\n"); //Needed just for memorizing password rules when testing
        System.out.println("Please enter your passwords satisfying the following constraints:-");
        System.out.println("1. It contains at least 8 characters and at most 20 characters.");
        System.out.println("2. It contains at least one digit.");
        System.out.println("3. It contains at least one upper case alphabet.");
        System.out.println("4. It contains at least one lower case alphabet.");
        System.out.println("5. It contains at least one special character which includes !@#$%&*()-+=^.");
        System.out.println("6. It doesn't contain any white space.");
        System.out.print("Password: ");
        password = in.nextLine();
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        while(!patternMatches(password, passwordRegex)){
            System.out.println("Invalid password format, please re-enter your password: ");
            password = in.nextLine();
        }
        System.out.print("Re-enter your password: ");
        password2 = in.nextLine();
        while(!Objects.equals(password, password2)){
            System.out.println("Passwords don't match, please re-enter your pasword correctly: ");
            password2 = in.nextLine();
        }
        account.setPassword(password);
        System.out.println("Account created successfully");
        return true;
    }
    public  void changePassword(){
    }
    boolean  verifyOTP(){
        return false;
    }

}
