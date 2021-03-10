package com.chocan.Auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Logger {

    public static int searchFile(Scanner textScanner, int input){
        // Implement search here
        // textScanner.useDelimiter(",");
        String [] words = null;
        while(textScanner.hasNext()){
            String line = textScanner.nextLine();
            words = line.split(",");
            if(words[0].equals(String.valueOf(input))){
                return 1;
            }
        }
        return 0; // For now
    }

    public static int login() throws FileNotFoundException {
        //boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        // Reading file
        int input = 0;
        int fileReturn = 0;

        do{
            System.out.print("\nEnter in Provider Number: ");
            input = scanner.nextInt();
            // Check number
            // Note:
            // - Either implement reading file by denoted name
            //   Ex: number: 1000000
            // - Have same user data fields, and skip lines after reading first line.
            //   Using second option below.
            File file = new File("src/com/chocan/TextFiles/providerinfo.csv");
            Scanner textScanner = new Scanner(file);
            fileReturn = searchFile(textScanner, input);

            if(fileReturn == 1){
                break;
            }
            else {
                System.out.println("\nInvalid Number. Try Again");
            }

        }while(true);

        // return the provider number
        return input;
    }

    public static void main(String [] args) throws FileNotFoundException {
        int val = login();
        System.out.println("ID: " + val);
    }
}
