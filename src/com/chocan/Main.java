package com.chocan;

import com.chocan.Accounts.Account;
import com.chocan.Controllers.AccountController;
import com.chocan.Accounts.Provider;
import com.chocan.Auth.Logger;
import com.chocan.Controllers.MemberController;
import com.chocan.Reports.Reports;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
import com.chocan.Controllers.AccountController;
import com.chocan.Accounts.Provider;
import com.chocan.Auth.Logger;
import com.chocan.Reports.Reports;
import java.io.FileNotFoundException;

public class Main {

    public static void viewProviderDirectory() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/chocan/TextFiles/providerdirectory.csv"));
        System.out.println("Service Code\tService Title\tService Fee");
        String [] line;
        scanner.nextLine();
        while(scanner.hasNext()){
            line = scanner.nextLine().split(",");
            System.out.println(line[0] + "\t\t" + line[1] + "\t\t" + line[2]);
        }
        scanner.close();
    }

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

    public static void main(String[] args) throws IOException {
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

        int choice = 999;
        do {
            choice = menu();
            switch(choice){
                case 1:
                    // Add, Delete, Update Member Data
                    MemberController.memberController();
                    break;
                case 2:
                    System.out.println("Selection: " + choice);
                    System.out.println("Please Enter Member ID!");
                    AccountController.validation();
                    break;
                case 3:
                    System.out.println("Selection: " + choice);
                    int id = provider.getNumber();
                    Reports.menu(id);
                    break;
                case 4:
                    //View a report

                    System.out.println("Selection: " + choice);
                    int pID = provider.getNumber();
                    int c = Reports.view(pID);
                    if(c == 1) {
                        //provider report
                        Reports.viewProvider(pID);
                    }
                    else {
                        String provName = provider.getName();
                        Reports.viewMember(provName);
                    }
                    break;
                case 5:

                    //View P Directory

                    System.out.println("Selection: " + choice);
                    viewProviderDirectory();
                    break;
                case 6:
                    System.out.println("Logging " + provider.getName() + " out. Goodbye");
                    break;

            }

        }while(choice != 6);
    }
}
