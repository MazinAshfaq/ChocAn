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

    public static Member validation(int id) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/Memberinfo.csv"));


        return null;
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
