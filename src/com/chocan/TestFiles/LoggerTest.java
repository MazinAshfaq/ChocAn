package com.chocan.TestFiles;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


import static com.chocan.Auth.Logger.login;
import static com.chocan.Auth.Logger.searchFile;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    //Tests for invalid user input
    @Test
    void mainInvalidInput() throws FileNotFoundException{

        String input = "99232";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in2);


        int val = login2();
        System.setIn(sysInBackup);
        assertEquals(0, val);

    }


    //Tests for valid user input
    @Test
    void mainValidInput() throws FileNotFoundException{

        //simulates user input
        String input = "100000000";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in1 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in1);

        int val = login();
        System.setIn(sysInBackup);
        assertEquals(parseInt(input), val);
    }
    //does not throw exception (file does exists)
    @Test
    void mainFileExceptionFalse() throws FileNotFoundException {
        String actualmessage = "";
        try{
            int val = login2();
        }
        catch(Exception e){
            actualmessage = e.getMessage();
        }

        assertFalse(actualmessage.contains("(The system cannot find the file specified)"));
    }


    //throws exception (file does not exist)
    @Test
    void mainFileExceptionTrue() throws FileNotFoundException {
        String actualmessage = "";
        try{
            int val = login1();
        }
        catch(Exception e){
            actualmessage = e.getMessage();
        }

        assertTrue(actualmessage.contains("(The system cannot find the file specified)"));

    }

    //derived from logger class.
    //changes the input file to invalid
    private static int login1() throws FileNotFoundException {
        //boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        // Reading file
        int input = 0;
        int fileReturn = 0;

        do{
            /* ---> commented out for testing
            System.out.print("\nEnter in Provider Number: ");
            input = scanner.nextInt();
            */

            // Check number
            // Note:
            // - Either implement reading file by denoted name
            //   Ex: number: 1000000
            // - Have same user data fields, and skip lines after reading first line.
            //   Using second option below.
            File file = new File("src/com/chocan/TextFiles/providerinfoFake.csv");
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


    //derived from logger class.
    //added break in while loop if given invalid input
    private static int login2() throws FileNotFoundException {
        //boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        // Reading file
        int input = 0;
        int fileReturn = 0;

        do{
            /* ---> commented out for testing
            System.out.print("\nEnter in Provider Number: ");
            input = scanner.nextInt();
            */

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
                break;
            }

        }while(true);

        // return the provider number
        return input;
    }

}