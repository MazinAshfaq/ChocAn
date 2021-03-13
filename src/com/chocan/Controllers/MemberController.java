package com.chocan.Controllers;

import com.chocan.Accounts.Member;

import java.io.*;
import java.security.AccessController;
import java.util.*;

public class MemberController {

    public static void printMember(String [] line){
        System.out.println("\nMember Information");
        System.out.println("Member ID: " + line[0]);
        System.out.println("Name: " + line[1]);
        System.out.println("Street Address: " + line[2]);
        System.out.println("City: " + line[3]);
        System.out.println("State: " + line[4]);
        System.out.println("Zip: " + line[5]);
        System.out.println("Fees Due: " + line[6]);
    }

    public static void viewMember(int id) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/chocan/TextFiles/memberinfo.csv"));
        String [] line;
        while(scanner.hasNext()){
            line = scanner.nextLine().split(",");
            if(line[0].equals(String.valueOf(id))){
                printMember(line);
                break;
            }
        }
    }

    public static Member getMemberFromId() throws FileNotFoundException {
        int memberId = 0;
        Scanner scanner = new Scanner(System.in);
        Member member = null;
        while(member == null) {
            System.out.println("Enter in 0 to go back");
            System.out.print("Enter in Member Number: ");
            memberId = scanner.nextInt();
            member = AccountController.populateMember(memberId);
            if (memberId == 0){
                break;
            }
            if (member == null) {
                System.out.println("Invalid Member Number");
            }
        }
        return member;
    }

    public static void addMember() throws IOException {
        // Add true to append to the end
        FileWriter writer = new FileWriter("src/com/chocan/TextFiles/memberinfo.csv", true);
        Scanner scanner = new Scanner(System.in);
        // New Random ID for Member
        String memberNumber = String.valueOf(100000000 + new Random().nextInt(900000000));
        // Name
        System.out.print("Enter in Member Full Name: ");
        String memberName = scanner.nextLine();
        // Address
        System.out.print("Enter in Street Address: ");
        String memberAddress = scanner.nextLine();
        // City
        System.out.print("Enter in City Name: ");
        String memberCity = scanner.nextLine();
        // State
        System.out.print("Enter in State (2 characters): ");
        String memberState = scanner.nextLine();
        // Zip
        System.out.print("Enter in Zip Code: ");
        String memberZip = scanner.nextLine();
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
    
    public static List<String[]> readFileContents() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/chocan/TextFiles/memberinfo.csv"));
        List<String[]> list = new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextLine().split(","));
        }
        scanner.close();
        return list;
    }

    public static void deleteMember(int id) throws IOException {
        List<String[]> fileContents = readFileContents();
        int count = 0;
        for(String [] line : fileContents){
            if(line[0].equals(String.valueOf(id))){
                fileContents.remove(count);
                break;
            }
            ++count;
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

    public static int updateMemberMenu(String name){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("What would you like to modify for " + name + "?");
            System.out.println("'1' - Name");
            System.out.println("'2' - Street Address");
            System.out.println("'3' - City");
            System.out.println("'4' - State");
            System.out.println("'5' - Zip");
            System.out.println("'6' - Fees");
            System.out.println("'7' - Go Back");
            System.out.print("Enter Here: ");
            choice = scanner.nextInt();
            if(choice < 0 || choice > 7){
                continue;
            }
            else {
                break;
            }

        }while(true);
        return choice;
    }

    public static String [] updateMember(String [] line, int choice, String toReplace){
        line[choice] = toReplace;
        return line;
    }

    public static void updateMember(Member member) throws IOException {
        int choice = updateMemberMenu(member.getName());
        Scanner scanner = new Scanner(System.in);
        String toReplace = null;
        switch(choice){
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

    public static int memberControllerMenu(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("\nSelect Modification to Member Info Below");
            System.out.println("\n'1' - Add Member");
            System.out.println("'2' - Delete Member");
            System.out.println("'3' - Update Member");
            System.out.println("'4' - View Member Info");
            System.out.println("'5' - Go Back");
            System.out.print("Enter Here: ");
            choice = scanner.nextInt();
            if(choice < 0 || choice > 5){
                continue;
            }
            else {
                break;
            }

        }while(true);
        return choice;
    }


    public static void memberController() throws IOException {

        int choice = 0;
        Member member = null;
        do{
            choice = memberControllerMenu();
            switch(choice){
                case 1:
                    // Call Add Member
                    System.out.println("Add Member Function");
                    addMember();
                    break;

                case 2:
                    // Call Delete Member
                    member = getMemberFromId();
                    // if member NULL, then go back
                    if(member == null){
                        break;
                    }
                    System.out.println("Delete Member Function");
                    deleteMember(member.getNumber());
                    break;

                case 3:
                    // Call Update Member
                    member = getMemberFromId();
                    // if member NULL, then go back
                    if(member == null){
                        break;
                    }
                    System.out.println("Update Member Function");
                    updateMember(member);
                    break;

                case 4:
                    // Call View Member
                    member = getMemberFromId();
                    // if member NULL, then go back
                    if(member == null){
                        break;
                    }
                    System.out.println("View Member Function");
                    viewMember(member.getNumber());
                    break;

            }

        }while(choice != 5);
    }


    public static void main(String [] args) throws IOException {
        MemberController.memberController();



    }
}
