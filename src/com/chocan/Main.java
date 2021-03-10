package com.chocan;

import com.chocan.Accounts.Account;
import com.chocan.Controllers.AccountController;
import com.chocan.Accounts.Provider;
import com.chocan.Auth.Logger;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int menu(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\nProvider Terminal Menu. Please Select Below");
            System.out.println("\n'1' - Manage/Change Member Information");
            System.out.println("'2' - New Service Transaction");
            System.out.println("'3' - Generate Report");
            System.out.println("'4' - View Generated Reports");
            System.out.println("'5' - View Provider Directory");
            System.out.println("'6' - Quit");
            System.out.println("Enter Here: ");
            choice = scanner.nextInt();
            if(choice < 0 || choice > 6){
                continue;
            }
            else {
                break;
            }
        }while(true);
        return choice;
    }


    public static void main(String[] args) throws FileNotFoundException {
	    /* Login */
        int providerNum = Logger.login();
        /* Populate Current Logged In Provider */
        Provider provider = AccountController.populateProvider(providerNum);
        if(provider == null) {
            System.out.println("Error");
        }
        else{
            System.out.println("Welcome Back " + provider.getName());
        }

        /* Call Menu */

        int choice = 999;
        do {
            choice = menu();
            switch(choice){
                case 1:
                    // Add, Delete, Update Member Data
                    System.out.println("Selection: " + choice);
                    break;
                case 2:
                    System.out.println("Selection: " + choice);
                    AccountController.validation();
                    break;
                case 3:
                    // Add, Delete, Update Member Data
                    System.out.println("Selection: " + choice);
                    break;
                case 4:
                    System.out.println("Selection: " + choice);
                    break;
                case 5:
                    // Add, Delete, Update Member Data
                    System.out.println("Selection: " + choice);
                    break;
                case 6:
                    System.out.println("Selection: " + choice);
                    break;

            }

        }while(choice != 6);


    }
}
