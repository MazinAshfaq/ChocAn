package com.chocan.Controllers;

import com.chocan.Accounts.Provider;
//import com.chocan.Accounts.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/* Controls methods with accounts and accessing files */
public class AccountController {


    public static Provider populateProvider(int id) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerinfo.csv"));
        String [] words = null;
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            if(line.contains(String.valueOf(id))){
                words = line.split(",");
                break;
            }
        }

        if(words != null){
            return new Provider(words[1], Integer.parseInt(words[0]), words[2],
                    words[3], words[4], Integer.parseInt(words[5]), Integer.parseInt(words[6]),
                    Integer.parseInt(words[7]));
        }
        else {
            return null;
        }
    }

    public static void payFee(int id) throws FileNotFoundException{

        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/Memberinfo.csv"));
        System.out.println("INSDIE PAY FEE");
        String [] ID = null;
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            ID = line.split(",");

            if(ID[0].equals(String.valueOf(id))) {
                ID[6] = String.valueOf(0);//Replace Fees field with 0

                if (ID.length > 0) {
                    StringBuilder sb = new StringBuilder();//Make a new string
                    for (String s : ID) {
                        sb.append(s).append(",");//Convert ID to
                    }
                }
            }
        }
        return;
    }

    public static void validation() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        int id;
        int c;
        id = scanner.nextInt();

        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/Memberinfo.csv"));
        String [] ID = null;
        String [] ID2 = null;
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            ID = line.split(",");
            if(ID[0].equals(String.valueOf(id))) {
                ID2 = ID;
            }
         }

        if(ID2 != null) {
                if(Integer.parseInt(ID2[6]) != 0) {
                    System.out.println("Member Has Outstanding Fees!");
                    System.out.println("Would you like to pay now? 1 or 0");
                    c = scanner.nextInt();
                    if(c == 1) payFee(id);
                    else{
                        System.out.println("Cannot Proceed if Fees are Not Paid!");
                        System.out.println("Have a Great Day!");
                        return;
                    }
                }
                else {
                    System.out.println("Valid Member");
                    return;
                }
            }
        else{
            System.out.println("Could Not Find Member ID!");
            System.out.println("Please Enter Correct ID:");
            id = scanner.nextInt();
            validation();
        }
    }


    public static void main(String [] args) throws FileNotFoundException {
        Provider test = populateProvider(100);
        if(test == null){
            System.out.println("\nError");
        }
        else{
            System.out.println("\nName: " + test.getName());
            System.out.println("\nNumber: " + test.getNumber());
            System.out.println("\nConsultations: " + test.getConsultations());
        }
    }
}
