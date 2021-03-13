package com.chocan.TestFiles;

import com.chocan.Accounts.Provider;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    //pass file that does exist
    @Test
    void mainFileExceptionFalse() throws FileNotFoundException {
        String actualmessage = "";
        try {
            Provider test = populateProvider(100);
        }
        catch(Exception e){
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("(The system cannot find the file specified)"));

    }

    //pass file that doesn't exist
    @Test
    void mainFileExceptionTrue() throws FileNotFoundException {
        String actualmessage = "";
        try {
            Provider test = populateProviderTest(100);
        }
        catch(Exception e){
            actualmessage = e.getMessage();
        }
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

    @Test
    void pDirValidFile() throws FileNotFoundException{
        String actualmessage = "";
        try {
            int val = printPDirectory2(111111);
        } catch(Exception e){
            actualmessage = e.getMessage();
        }
        assertTrue(actualmessage.contains("(The system cannot find the file specified)"));
    }

    @Test
    void pDirInvalidFile() throws FileNotFoundException {
        String actualmessage = "";
        try {
            int val = printPDirectory1(111111);
        } catch(Exception e){
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("(The system cannot find the file specified)"));

    }


    private static int printPDirectory1(int serviceC) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerdirectory.csv"));
        boolean b = false;
        //Save file into List of Lists
        List<List<String>> file = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            //file.add(saveFile(fileScanner.nextLine()));
            return 1;
        }
        return 0;

    }

    private static int printPDirectory2(int serviceC) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerdirectoryInvalid.csv"));
        boolean b = false;
        //Save file into List of Lists
        List<List<String>> file = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            //file.add(saveFile(fileScanner.nextLine()));
            return 1;
        }
        return 0;
    }


    @Test //Test add service to file with Invalid Service code.
    void addInvalidService1() throws FileNotFoundException{
        List<List<String>> file = new ArrayList<>();
        String actualmessage = "";
        try{
           String val = getSName1(123456, file);
        }
        catch (Exception e){
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("0"));
    }

    @Test //Test add service to file with Valid Service code.
    void addInvalidService2() throws FileNotFoundException{
        List<List<String>> file = new ArrayList<>();
        String actualmessage = "";
        try{
            String val = getSName2(111111, file);
        }
        catch (Exception e){
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("1"));
    }


    private static String getSName1(int serviceC,List<List<String>>file) throws FileNotFoundException{
        String s = "0";
        for (List<String> list : file) {
            if (list.get(0).equals(String.valueOf(serviceC))) {
                return list.get(1);
            }
        }
        s = "1";
        return s;
    }

    private static String getSName2(int serviceC,List<List<String>>file) throws FileNotFoundException{
        String s = "0";
        for (List<String> list : file) {
            if (list.get(0).equals(String.valueOf(serviceC))) {
                return list.get(1);
            }
        }
        s = "1";
        return s;
    }
}