package com.chocan.Controllers;

import com.chocan.Accounts.Provider;
import com.chocan.Auth.Logger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.chocan.Controllers.AccountController.populateProvider;
import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest {


    // pass a value on a line that doesn't exist at all
    @Test
    void mainFalse() throws FileNotFoundException {
        Provider test = populateProvider(999);
        assertEquals(true, test == null);
    }

    //pass a value that exists on a line
    @Test
    void mainTrue() throws FileNotFoundException {
        Provider test = populateProvider(100);
        assertEquals(true, test != null);
    }

    //pass file that doesn't exist
    @Test
    void mainFileException() throws FileNotFoundException {
        String actualmessage = "";
        try {
            Provider test = populateProviderTest(100);
        }
        catch(Exception e){
            actualmessage = e.getMessage();
            assertTrue(actualmessage.contains("(The system cannot find the file specified)"));
        }
        //Should fail if fake file not passed in
        assertTrue(actualmessage.contains("(The system cannot find the file specified)"));

    }
    //derived from original. Changes file to be read as a fake file
    private static Provider populateProviderTest(int id) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerinfoFake.csv"));
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


}