package com.chocan.Reports;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static com.chocan.Reports.Reports.member;
//import static com.chocan.Reports.Reports.providerReport;
import static org.junit.jupiter.api.Assertions.*;

class ReportsTest {

    @Test
    void menuValidInput(){
      menu(100000000,1);
      menu(100000000,2);
    }


    //tests for invalid file input
    @Test
    void viewValidInput()  {

       int choice = view(100000000, 1);
       assertEquals(choice,1);
       choice = view(100000000, 2);
       assertEquals(choice,2);
    }

    private static void menu(int providerID, int val) {
        Scanner input;
        input = new Scanner(System.in);

        //Ask provider if they want to generate a member report or provider report
        System.out.println("Please Select Below\n");
        System.out.println("1 - Run a Provider Report");
        System.out.println("2 - Run a Member Report");

        int choice = val;

        if (choice == 1) { //Run Provider Report
            //pass provider ID
          //  providerReport(providerID);
           assertTrue(true);
        } else if (choice == 2) { //Run a member report
            assertTrue(true);
           // member(providerID);
        } else { //Non Valid ID
            System.out.println("Please Enter a Valid Parameter");
            assertFalse(false);
         //   menu(providerID);
        }

    }

    private static int view(int provID, int val) {
        Scanner input;
        input = new Scanner(System.in);

        //Ask which reports they would like to view
        System.out.println("Which Report would you like to view\n");
        System.out.println("1 - View Provider Report");
        System.out.println("2 - View Member Report");

        int choice = val;

        if (choice == 1) { //View Provider Report
            //pass provider ID
            //viewProvider(provID);
            return choice;
        } else if (choice == 2) { //View Member Report
            //viewMember(provID);
            return choice;
        }


        System.out.println("Please Enter a Valid Parameter");
        view(provID,val);

        return choice;
    }




}