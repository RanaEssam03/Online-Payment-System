
import views.InstaPay;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
      try {
            InstaPay instaPay = new InstaPay();
            instaPay.run();
      }
        catch (Exception e){
            System.out.println("Something went wrong try again!");
        }
    }

    /**
    Registered account using CIB Bank account
    username : nourmuhammad@instapay
    password: Software2023$
    ***/

    /**
     Registered account using vodafone cash wallet
     username: ranaessam@instapay
     password: Software2023$
     ***/

    /**
     To register using bank account use this mobile number 01114335538
     in CIB bank to make sure that it will be verified
     */
    /**
      To register using wallet use this mobile number 01007104077
     in Etisalat online wallet to make sure that it will be verified
     */


}
