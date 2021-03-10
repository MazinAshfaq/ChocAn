package com.chocan.Controllers;

import com.chocan.Accounts.Provider;
import com.chocan.Accounts.Member;

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

    public static int validation() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        System.out.println("Please Enter Member ID!");
        id = scanner.nextInt();

        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/Memberinfo.csv"));
        String [] ID = null;
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            if (line.contains(String.valueOf(id))) {
                ID = line.split(",");
                break;
            }
        }

        if(ID != null) {
            if (Integer.parseInt(ID[0]) == id) {
                if(Integer.parseInt(ID[6]) != 0) {
                    System.out.println("Member Has Outstanding Fees!");
                    System.out.println("Would you like to pay now? 1 or 0");
                    int choice = 0;
                    choice = scanner.nextInt();
                    if(choice == 1){
                         return payFee(id);
                    }
                    else{
                        System.out.println("Cannot Proceed if Fees are Not Paid!");
                        System.out.println("Have a Great Day!");
                        return 0;
                    }
                }
                else {
                    System.out.println("Valid Member");
                    return 1;
                }
            }
            else{
                System.out.println("Could Not Find Member ID!");
                System.out.println("Please Enter Correct ID:");
                id = scanner.nextInt();
            }

        }
        else {
            System.out.println("");
            return 0;
        }
        return 0;
    }

    public static int payFee(int id){
        return 0;
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
