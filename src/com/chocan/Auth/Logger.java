package com.chocan.Auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Logger {

    public static int searchFile(Scanner textScanner){
        // Implement search here
        return 0; // For now
    }

    public static int login() throws FileNotFoundException {
        //boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        // Reading file
        int input = 0;
        int fileInput = 0;

        do{
            System.out.print("\nEnter in Provider Number: ");
            input = scanner.nextInt();
            // Check number
            // Note:
            // - Either implement reading file by denoted name
            //   Ex: number: 1000000
            // - Have same user data fields, and skip lines after reading first line.
            //   Using second option below.
            File file = new File("src/com/chocan/TestFiles/providerinfo.txt");
            Scanner textScanner = new Scanner(file);
            fileInput = textScanner.nextInt();

            // if using second option, skip the next "i" amount of lines in textScanner
            // Implement here...

            if(fileInput == input){
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
        int providerNum = login();
        System.out.println("\nProvider Number: " + providerNum);
    }
}
