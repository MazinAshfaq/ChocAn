package com.chocan.Reports;

import com.chocan.Accounts.Account;
import com.chocan.Accounts.Provider;

import java.io.*;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;


public class Reports{
    private String provider;
    private String member;
    private int providerID;
    private int memberID;
    private String dateOS;
    private String currentDT;
    private String servicecode;
    private String serviceName;
    private int fees;
    private String comments;

    public Reports(String provider, String member, int providerID, int memberID, String dateOS, String currentDT, String servicecode, String serviceName, int fees, String comments) throws FileNotFoundException {
        this.provider = provider;
        this.member = member;
        this.providerID = providerID;
        this.memberID = memberID;
        this.dateOS = dateOS;
        this.currentDT = currentDT;
        this.servicecode = servicecode;
        this.serviceName = serviceName;
        this.fees = fees;
        this.comments = comments;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //TWO CSV FILES TO WRITE TOO
        //A MEMBER REPORT AND A PROVIDER REPORT

    }

    //Create a function for menu and what report they want to run

    //two functions: one for member report, one for provider
    //validate member id

    public static void menu(int providerID) {
        Scanner input;
        input = new Scanner(System.in);

        //Ask provider if they want to generate a member report or provider report
        System.out.println("Please Select Below\n");
        System.out.println("1 - Run a Provider Report");
        System.out.println("2 - Run a Member Report");

        int choice = input.nextInt();

        if(choice == 1) { //Run Provider Report
            //pass provider ID
            providerReport(providerID);
        }
        else if(choice == 2) { //Run a member report
            member(providerID);
        }
        else { //Non Valid ID
            System.out.println("Please Enter a Valid Parameter");
            menu(providerID);
        }

    }

    private static void providerReport(int provID) {
        //using provider ID search for necessary information and store it in providerReports
        String line = "";
        String splitby = ",";

        //temps
        String provider;
        String member;
        //int providerID;
        int memberID;
        String dateOS;
        String currentDT;
        String servicecode;
        String serviceName;
        int memberfees;
        String comments;

        //Will need to get Providers street address, city, state, zip code,
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/com/chocan/TextFiles/servicelist.csv"));
            line = br.readLine(); //go past first
            for(line = br.readLine(); line != null; line = br.readLine())//while((line = br.readLine()) != null)
            {
                String[] prov = line.split(splitby);

                if(provID == Integer.parseInt(prov[0])) { //Find specific Provider

                    //providerID = Integer.parseInt(prov[0]);
                    memberID = Integer.parseInt(prov[1]);
                    provider = prov[2];
                    member = prov[3];
                    dateOS = prov[4];
                    currentDT = prov[5];
                    servicecode = prov[6];
                    serviceName = prov[7];
                    memberfees = Integer.parseInt(prov[8]);
                    comments = prov[9];


                    //grab the rest of the info from providerinfo
                    //call another function
                    pInfo(provID, memberID, provider, member, dateOS, currentDT, servicecode, serviceName, memberfees, comments);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return;
        //provider not found
    }

    private static void pInfo(int provID, int memberID, String provider, String member, String dateOS, String currentDT, String servicecode, String serviceName, int memberfees, String comments) throws IOException {
        String line2 = "";
        String splitby = ",";

        BufferedReader br2 = new BufferedReader(new FileReader("src/com/chocan/TextFiles/providerinfo.csv"));
        line2 = br2.readLine(); //go past first
        for(line2 = br2.readLine(); line2 != null; line2 = br2.readLine()) {
            String [] info = line2.split(splitby);
            if(provID == Integer.parseInt(info[0])) { //found provider
                //get address, city, zip code. num of consultations, and total fees
                String address = info[2];
                String city = info[3];
                String state = info[4];
                int zip = Integer.parseInt(info[5]);
                int consultations = Integer.parseInt(info[6]);
                int fees = Integer.parseInt(info[7]);

                //push data onto providerReport.csv
                boolean success = ProviderCSV(provID, memberID, provider, member, dateOS, currentDT, servicecode, serviceName, memberfees, comments, address, city, state, zip, consultations, fees);
                if(success) {
                    System.out.println("Successfull push to CSV");
                    return;
                }
            }
        }
    }


    private static boolean ProviderCSV(int providerID, int memberID, String provider, String member, String dateOS, String currentDT, String servicecode, String serviceName, int memberfees, String comments, String address, String city, String state, int zip, int consultations, int fees) throws IOException {
        FileWriter push = new FileWriter("src/com/chocan/TextFiles/providerReport.csv", true);
        try {
            push.append(String.valueOf(providerID));
            push.append(",");
            push.append(provider);
            push.append(",");
            push.append(address);
            push.append(",");
            push.append(city);
            push.append(",");
            push.append(state);
            push.append(",");
            push.append(String.valueOf(zip));
            push.append(",");
            push.append(dateOS);
            push.append(",");
            push.append(currentDT);
            push.append(",");
            push.append(member);
            push.append(",");
            push.append(String.valueOf(memberID));
            push.append(",");
            push.append(servicecode);
            push.append(",");
            push.append(String.valueOf(memberfees));
            push.append(",");
            push.append(String.valueOf(consultations));
            push.append(",");
            push.append(String.valueOf(fees));
            push.append("\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

        push.flush();
        push.close();

        return true;
    }

    public static void member(int ID) {
        Scanner input;
        input = new Scanner(System.in);

        //first validate id
        //ask for member ID
        System.out.println("Enter the 9 digit Member ID\n");
        int searchID = input.nextInt();
        int length = String.valueOf(searchID).length();

        System.out.println("TEST LENGTH OF searchID: " + length);



    }

    public static void Allreports(int ID) {
        //read from file
        Scanner input;
        input = new Scanner(System.in);

        String line = "";
        String splitby = ",";

        //temps
        String provider;
        String member;
        int providerID;
        int memberID;
        String dateOS;
        String currentDT;
        String servicecode;
        String serviceName;
        int fees;
        String comments;

        //Will need to get Providers street address, city, state, zip code,
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/com/chocan/TextFiles/servicelist.csv"));
            line = br.readLine(); //go past first
            for(line = br.readLine(); line != null; line = br.readLine())//while((line = br.readLine()) != null)
            {
                String[] prov = line.split(splitby);

                providerID = Integer.parseInt(prov[0]);
                memberID = Integer.parseInt(prov[1]);
                provider = prov[2];
                member = prov[3];
                dateOS = prov[4];
                currentDT = prov[5];
                servicecode = prov[6];
                serviceName = prov[7];
                fees = Integer.parseInt(prov[8]);
                comments = prov[9];

                //grab the rest of the info from provider and

                System.out.println("Provider Name: " + provider + "Provider Number: " + providerID + "Provider Street Address: " + member + " " + memberID);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
