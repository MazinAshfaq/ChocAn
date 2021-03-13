package com.chocan.TestFiles;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class ReportsTest {

    @Test
        //Test for valid input
    void viewMemberInvalidInput1() throws FileNotFoundException {
        String actualmessage = "";
        try {
            int val = viewProvider2(150000000);
        } catch (Exception e) {
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("The system cannnot find the file specified."));

    }

    @Test
        //Test for Invalid input
    void viewMemberValidInput2() throws FileNotFoundException {
        String actualmessage = "";
        try {
            int val = viewProvider1(12345);
        } catch (Exception e) {
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("The system cannot find the file specified."));
    }

    @Test
        //Test if the file exists (This case: File does exist)
    void viewProvFileExceptionTrue() throws FileNotFoundException {
        String actualmessage = "";
        try {
            int val = viewProvider2(150000000);
        } catch (Exception e) {
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("The system cannnot find the file specified."));

    }

    @Test
        //Test if the file exists (This case: File doesn't exist)
    void viewProvFileExceptionFalse() throws FileNotFoundException {
        String actualmessage = "";
        try {
            int val = viewProvider1(150000000);
        } catch (Exception e) {
            actualmessage = e.getMessage();
        }
        assertFalse(actualmessage.contains("The system cannot find the file specified."));

    }

    private static int viewProvider1(int provID) throws FileNotFoundException {
        String line = "";
        String splitby = ",";
        //int provID = 150000000;

        System.out.println("\n");

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/com/chocan/TextFiles/providerReport.csv"));
            line = br.readLine(); //go past first
            while ((line = br.readLine()) != null) {
                String[] prov = line.split(splitby);

                //find specific provider
                int compare = Integer.parseInt(prov[0]);
                if (provID == compare) {
                    //display
                    System.out.println("Provider Name: " + prov[1] + "\nProvider ID: " + provID + "\nStreet Address: " + prov[2] +
                            "\nCity: " + prov[3] + "\nState: " + prov[4] + "\nZip Code: " + prov[5] +
                            "\n\tDate of Service: " + prov[6] + "\n\tDate And Time Data were received: " + prov[7] +
                            "\n\tMember Name: " + prov[8] + "\n\tMember ID: " + prov[9] + "\n\tService Code: " + prov[10] +
                            "\n\tMember Fees: " + prov[11] + "\nTotal Consultations: " + prov[12] + "\nTotal Fees for the week: " + prov[13]);
                    System.out.println("\n");
                }
            }
        } catch (IOException e) {
            //   e.printStackTrace();
        }
        return provID;
    }

    private static int viewProvider2(int provID) throws FileNotFoundException {
        String line = "";
        String splitby = ",";
        //int provID = 150000000;

        System.out.println("\n");

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/com/chocan/TextFiles/providerReport22.csv")); //Add something to make this file to test for invalid files.
            line = br.readLine(); //go past first
            while ((line = br.readLine()) != null) {
                String[] prov = line.split(splitby);

                //find specific provider
                int compare = Integer.parseInt(prov[0]);
                if (provID == compare) {
                    //display
                    System.out.println("Provider Name: " + prov[1] + "\nProvider ID: " + provID + "\nStreet Address: " + prov[2] +
                            "\nCity: " + prov[3] + "\nState: " + prov[4] + "\nZip Code: " + prov[5] +
                            "\n\tDate of Service: " + prov[6] + "\n\tDate And Time Data were received: " + prov[7] +
                            "\n\tMember Name: " + prov[8] + "\n\tMember ID: " + prov[9] + "\n\tService Code: " + prov[10] +
                            "\n\tMember Fees: " + prov[11] + "\nTotal Consultations: " + prov[12] + "\nTotal Fees for the week: " + prov[13]);
                    System.out.println("\n");
                }
            }
        } catch (IOException e) {
            //   e.printStackTrace();
        }
        return provID;
    }

    public static void viewMember1(String provName) throws IOException {
        Scanner input = new Scanner(System.in);
        String line = "";
        String splitby = ",";
        String temp = "";

        //ask for member ID
        System.out.println("Enter the 9 digit Member ID\n");
        int searchID = 150000000;
        int length = String.valueOf(searchID).length();

        //System.out.println("TEST LENGTH OF searchID: " + length);
        if (length < 9 || length > 9) { //invalid member id
            System.out.println("Invalid Member ID");
            viewMember1(provName);
            return;
        }
        System.out.println("\n");

        try {

            BufferedReader br = new BufferedReader(new FileReader("src/com/chocan/TextFiles/memberReport.csv"));
            line = br.readLine(); //go past first
            for (line = br.readLine(); line != null; line = br.readLine())//while((line = br.readLine()) != null)
            {
                String[] mem = line.split(splitby);

                if (searchID == Integer.parseInt(mem[0])) { //if match member
                    if (provName.equals(mem[7])) { //if match provider
                        //display info
                        System.out.println("Member Name: " + mem[1] + "\nMember ID: " + mem[0] + "\nStreet Address: " + mem[2] +
                                "\nCity: " + mem[3] + "\nState: " + mem[4] + "\nZip Code: " + mem[5] + "\n\tDate of Service: " + mem[6] +
                                "\n\tProvider Name: " + provName + "\n\tService Name: " + mem[8]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return;
    }
}
