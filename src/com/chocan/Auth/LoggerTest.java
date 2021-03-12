package com.chocan.Auth;

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

    //TODO add this test
    @Test
    void mainInvalidInputI() throws FileNotFoundException{



    }


    //test for valid user input
    @Test
    void mainValidInput() throws FileNotFoundException{

        //simulates user input
        String input = "100000000";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int val = login();

        assertEquals(parseInt(input), val);
    }

    //test for invalid file
    @Test
    void mainFileException() throws FileNotFoundException {
        String actualmessage = "";
        try{
            int val = login1();
        }
        catch(Exception e){
            actualmessage = e.getMessage();
        }

        if(actualmessage.contains("(The system cannot find the file specified)")){
            //System.out.println("true");
            assertTrue(actualmessage.contains("(The system cannot find the file specified)"));
        }
        else{
            //System.out.println("false");
            assertFalse(actualmessage.contains("(The system cannot find the file specified)"));
        }

    }

    //derived from logger class, only changes the input file to invalid
    private static int login1() throws FileNotFoundException {
        //boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        // Reading file
        int input = 100000000;
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
            }

        }while(true);

        // return the provider number
        return input;
    }

}