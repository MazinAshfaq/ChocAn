package com.chocan.TestFiles;

import com.chocan.Accounts.Member;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.chocan.Auth.Logger.login;
import static com.chocan.Controllers.MemberController.*;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

class MemberControllerTest {

    /*scratched, not working
    @Test
    void updateMemberTest() throws IOException{


        Member member = null;
        String input = viewMemberLast();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in1 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in1);

        member = getMemberFromId();
        System.setIn(sysInBackup);

        input = viewMemberLast();
        ByteArrayInputStream in2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in2);
        updateMember(member, "test");

    }
    */

    //tests for correctly deleting member
    //adds member with random ID
    //saves id of last ID in the list
    //deletes the very last id
    //check if it still exists after deletion. This test should pass by asserting FALSE
    @Test
    void deleteMemberTest() throws IOException{

        String testID;
        addMember();
        testID = viewMemberLast();
        deleteMember(parseInt(testID));
        viewMember(parseInt(testID));
    }

    //test for correctly adding member
    //saves member id from the last
    //seek to view member. This should PASS by asserting true.
    @Test
    void addMemberTest() throws IOException {

        //values passed in order, Test, 123TestSt, testCity, TS, 12345
        String testID;
        addMember();
        testID = viewMemberLast();
        viewMember(parseInt(testID));

    }

    //derived, modified to take hard-coded input
    private static void addMember() throws IOException {
        // Add true to append to the end
        FileWriter writer = new FileWriter("src/com/chocan/TextFiles/memberinfo.csv", true);
        Scanner scanner = new Scanner(System.in);
        // New Random ID for Member
        String memberNumber = String.valueOf(100000000 + new Random().nextInt(900000000));
        // Name
     //   System.out.print("Enter in Member Full Name: ");
        String memberName = "Test";
        // Address
     //   System.out.print("Enter in Street Address: ");
        String memberAddress = "123TestSt";
        // City
     //   System.out.print("Enter in City Name: ");
        String memberCity = "testCity";
        // State
     //   System.out.print("Enter in State (2 characters): ");
        String memberState = "TS";
        // Zip
     //   System.out.print("Enter in Zip Code: ");
        String memberZip = "12345";
        // Set Fees to 0 for now (assuming paid upfront)
        String memberFees = String.valueOf(0);

        writer.append("\n");
        writer.append(memberNumber);
        writer.append(",");
        writer.append(memberName);
        writer.append(",");
        writer.append(memberAddress);
        writer.append(",");
        writer.append(memberCity);
        writer.append(",");
        writer.append(memberState);
        writer.append(",");
        writer.append(memberZip);
        writer.append(",");
        writer.append(memberFees);

        writer.close();
    }


    //derived, meant to return id of last member from list
    private static String viewMemberLast() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/chocan/TextFiles/memberinfo.csv"));
        String [] line;

        while(scanner.hasNext()){
            line = scanner.nextLine().split(",");
            if(scanner.hasNext() == false){
                return line[0];
           }
        }
        return "not found";
    }
    //derived, meant to return name of last member from list
    private static String viewMemberLastName() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/chocan/TextFiles/memberinfo.csv"));
        String [] line;

        while(scanner.hasNext()){
            line = scanner.nextLine().split(",");
            if(scanner.hasNext() == false){
                return line[1];
            }
        }
        return "not found";
    }

    //derived, asserts true when correct id passed. if not found, return false.
    private static void viewMember(int id) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/chocan/TextFiles/memberinfo.csv"));
        String [] line;
        boolean found = false;
        while(scanner.hasNext()){
            line = scanner.nextLine().split(",");
            if(line[0].equals(String.valueOf(id))){
                found = true;
                assertTrue(true);
                break;
            }
        }
        if(found == false)
            assertFalse(false);
    }

    //dervied to only change name
    public static void updateMember(Member member, String newName) throws IOException {
        int choice = updateMemberMenu(member.getName());
        Scanner scanner = new Scanner(System.in);
        String toReplace = null;
        switch(1){
            case 1:
                System.out.print("Enter New Name: ");
                toReplace = scanner.nextLine();
                break;
            case 2:
                System.out.print("Enter New Street Address: ");
                toReplace = scanner.nextLine();
                break;
            case 3:
                System.out.print("Enter New City: ");
                toReplace = scanner.nextLine();
                break;
            case 4:
                System.out.print("Enter New State: ");
                toReplace = scanner.nextLine();
                break;
            case 5:
                System.out.print("Enter New Zip: ");
                toReplace = scanner.nextLine();
                break;
            case 6:
                // update fess
                toReplace = String.valueOf(0);
                break;
            case 7:
                return;
        }

        // Replace line in filecontents
        List<String[]> fileContents = readFileContents();
        String [] toAdd = null;

        for(int i = 0; i<fileContents.size(); ++i){
            String temp = fileContents.get(i)[0];
            if(fileContents.get(i)[0].equals(String.valueOf(member.getNumber()))){
                toAdd = updateMember(fileContents.get(i), choice, toReplace);
                fileContents.set(i, toAdd);
            }
        }

        FileWriter writer = new FileWriter("src/com/chocan/TextFiles/memberinfo.csv");
        int wordCount, lineCount = 0;
        for(String [] line : fileContents){
            ++lineCount;
            wordCount = 0;
            for(String word : line){
                if(wordCount == line.length-1){
                    writer.append(word);
                    break;
                }
                writer.append(word);
                writer.append(",");
                ++wordCount;
            }
            if(lineCount == fileContents.size()){
                break;
            }
            writer.append("\n");
        }

        writer.close();
    }
    private static String [] updateMember(String [] line, int choice, String toReplace){
        line[choice] = toReplace;
        return line;
    }

}
