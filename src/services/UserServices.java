package services;

import Database.Data;
import models.Account.Account;
import providers.Account.AccountProvider;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The UserServices class provides a general method for user registration and account creation and feature of changing password
 */

public class UserServices {
    /**
     * Registers a new account with the provided details.
     *
     * @param account      the account object to be registered.
     * @param mobileNumber the mobile number associated with the account.
     * @param provider     the account provider for verification.
     * @param providerName the name of the account provider.
     * @return true if the registration is successful, false otherwise.
     */
    public boolean register(Account account, String mobileNumber, AccountProvider provider, String providerName) {
        if (!provider.verifyAccount(mobileNumber, providerName)) {
            return false;
        }
        boolean valid;
        account.setMobile(mobileNumber);
        System.out.println("Please enter the following data:- ");
        String userName;
        String email;
        String password;
        String password2;
        System.out.print("Username(name@instapay): ");
        Scanner in = new Scanner(System.in);
        userName = in.nextLine();
        while (!userName.contains("@instapay")) {
            System.out.print("Ivalid username, please re-enter your username: ");
            userName = in.nextLine();
        }
        while (verifyAccount(userName)) {
            System.out.print("Username already exists, please re-enter your username: ");
            userName = in.nextLine();
        }
        account.setUserName(userName);
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        System.out.print("Email: ");
        email = in.nextLine();
        valid = Pattern.compile(emailRegex)
                .matcher(email)
                .matches();
        while (!valid) {
            System.out.println("Invalid email format, please re-enter your email: ");
            email = in.nextLine();
            valid = Pattern.compile(emailRegex).matcher(email).matches();
        }
        account.setEmail(email);
        System.out.println("Please enter your password satisfying the following constraints:-");
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
        valid = Pattern.compile(passwordRegex).matcher(password).matches();
        while (!valid) {
            System.out.println("Invalid password format, please re-enter your password: ");
            password = in.nextLine();
            valid = Pattern.compile(passwordRegex).matcher(password).matches();
        }
        System.out.print("Re-enter your password: ");
        password2 = in.nextLine();
        while (!Objects.equals(password, password2)) {
            System.out.println("Passwords don't match, please re-enter your password correctly: ");
            password2 = in.nextLine();
        }
        account.setPassword(password);
        Authentication authentication = new Authentication();
        String crntOTP = authentication.sendOtp(mobileNumber);
        System.out.print("Enter the OTP sent to your mobile number: ");
        String otp;
        otp = in.nextLine();
        while (!Objects.equals(otp, crntOTP)) {
            System.out.println("Invalid OTP, please re-enter the OTP sent to your number: ");
            otp = in.nextLine();
        }
        Data.accounts.add(account);
        System.out.println("Account created successfully");
        return true;
    }

    /**
     * Gives the logged-in user the ability to change his password
     *
     * @param account the account of the user
     */
    public void changePassword(Account account) {
        System.out.print("Enter you current password: ");
        Scanner in = new Scanner(System.in);
        String inputPassword = in.nextLine();
        while (!Objects.equals(inputPassword, account.getPassword())) {
            System.out.print("Incorrect password, please re-enter your current password: ");
            inputPassword = in.nextLine();
        }
        String newPassword;
        System.out.print("Enter your new password: ");
        newPassword = in.nextLine();
        boolean valid;
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        valid = Pattern.compile(passwordRegex).matcher(newPassword).matches();
        while (!valid) {
            System.out.println("Invalid password format, please re-enter your password: ");
            newPassword = in.nextLine();
            valid = Pattern.compile(passwordRegex).matcher(newPassword).matches();
        }
        String newPassword2;
        System.out.print("Re-enter your password: ");
        newPassword2 = in.nextLine();
        while (!Objects.equals(newPassword, newPassword2)) {
            System.out.println("Passwords don't match, please re-enter your password correctly: ");
            newPassword2 = in.nextLine();
        }
        account.setPassword(newPassword);
        System.out.println("Password changed successfully");
    }

    public boolean verifyAccount(String username) {
        for (int i = 0; i < Data.accounts.size(); i++) {
            if (Data.accounts.get(i).getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
