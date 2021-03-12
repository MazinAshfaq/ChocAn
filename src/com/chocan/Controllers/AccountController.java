package com.chocan.Controllers;

import com.chocan.Accounts.Member;
import com.chocan.Accounts.Provider;
import com.chocan.Accounts.Member;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;


/* Controls methods with accounts and accessing files */
public class AccountController<Static> {

    public static Member populateMember(int id) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/memberinfo.csv"));
        String [] words = null;
        String [] retWords = null;
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            words = line.split(",");
            if(words[0].equals(String.valueOf(id))){
               retWords = words;
               break;
            }

        }
        fileScanner.close();

        if(retWords != null){

            return new Member(words[1], Integer.parseInt(words[0]),
                    words[2], words[3], words[4],
                    Integer.parseInt(words[5]), Integer.parseInt(words[6]));
        }
        else {
            return null;
        }

    }

    private static void printPDirectory(int serviceC) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerdirectory.csv"));
        boolean b = false;
        //Save file into List of Lists
        List<List<String>> file = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            file.add(saveFile(fileScanner.nextLine()));
        }


    }

    private static String getSName(int serviceC,List<List<String>>file){
        String s = "";
        for (List<String> list : file) {
            if (list.get(0).equals(String.valueOf(serviceC))) {
                return list.get(1);
            }
        }
        return s;
    }

    private static String getSFee(int serviceC,List<List<String>>file){
        String s = "";
        for (List<String> list : file) {
            if (list.get(0).equals(String.valueOf(serviceC))) {
                return list.get(2);
            }
        }
        return s;
    }

    private static void checkServiceID(int serviceC,List<List<String>>file){
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        for (List<String> list : file) {
            if (list.get(0).equals(String.valueOf(serviceC))) {
                String line = String.join(" ", list);
                System.out.print(line);
                System.out.println("\n");
                found = true;
            }
        }
        if(found){
            return;
        }
        else{
            System.out.println("Could not find Service, try again.");
            System.out.println("Please Enter Service Code:");
            int NserviceC = scanner.nextInt();
            checkServiceID(NserviceC,file);
        }
    }

    public static void addService(Provider provider, Member member) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerdirectory.csv"));
        boolean b = false;
        //Save file into List of Lists
        List<List<String>> file = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            file.add(saveFile(fileScanner.nextLine()));
        }

        System.out.println("Please Enter Current Date MM/DD/YYYY");
       //Check date function maybe or if not a string catch error
        String date = scanner.nextLine();
        System.out.println("Please Enter Service Code:");
        int serviceC = scanner.nextInt();
        checkServiceID(serviceC,file);

        String y = "y";
        String n = "n";
        String choice;
        scanner.nextLine();
        do {
            System.out.println("Did you enter the correct code? (y/n)");
            choice = scanner.nextLine();

            if(choice.equals(y)){
                break;
            }
            else{
                System.out.println("Please Enter Service Code:");
                serviceC = scanner.nextInt();
                checkServiceID(serviceC,file);
            }

        }while((choice.equals(n)));

        String comments = "";
        System.out.println("Would you like to enter any comments about the service? (y/n)");
        choice = scanner.nextLine();
        if(choice.equals(y)){
            comments = scanner.nextLine();
        }


        Date curdate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatter.format(curdate);
        try {
            writeToEndOfFile(provider.getNumber()+ ","+member.getNumber()+","+provider.getName()+ ","+member.getName()+","+date+","+curdate+","+
                    String.valueOf(serviceC)+","+getSName(serviceC,file)+","+getSFee(serviceC,file)+","+comments);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return;

    }

    public static Provider populateProvider(int id) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/providerinfo.csv"));
        String[] words = null;
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            if (line.contains(String.valueOf(id))) {
                words = line.split(",");
                break;
            }
        }
        fileScanner.close();

        if (words != null) {
            return new Provider(words[1], Integer.parseInt(words[0]), words[2],
                    words[3], words[4], Integer.parseInt(words[5]), Integer.parseInt(words[6]),
                    Integer.parseInt(words[7]));
        } else {
            return null;
        }
    }

    private static List<String> saveFile(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    private static void writeToEndOfFile(String line) throws IOException {
        FileWriter writer = new FileWriter("src/com/chocan/TextFiles/servicelist.csv",true);
        BufferedWriter br = new BufferedWriter(writer);
        br.write(line);
        br.append("\n");

        br.close();
        writer.close();

    }

    private static void writeToFile(List<List<String>> file) throws IOException {
        FileWriter writer = new FileWriter("src/com/chocan/TextFiles/memberinfotest.csv");

        //Traverses List and for each list
        for (List<String> list : file) {
            //Convert array into string delimited by ","
            String line = String.join(",", list);
            //Write it to the file
            writer.write(line);
            writer.append("\n");
        }
        writer.close();
    }

    public static void payFee(int id) throws IOException {

        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/Memberinfo.csv"));

        //Save file into List of Lists
        List<List<String>> file = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            file.add(saveFile(fileScanner.nextLine()));
        }

        //Traverse saved file to find ID and edit the fees to 0
        file.forEach((list) -> {
            if(list.get(0).equals(String.valueOf(id))) {
                list.set(6,String.valueOf(0));
            }
        });

        //Write back new values
        writeToFile(file);

        return;
    }

    public static void validation(Provider provider) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        int id;
        int c;
        id = scanner.nextInt();

        Scanner fileScanner = new Scanner(new File("src/com/chocan/TextFiles/Memberinfo.csv"));
        String [] ID = null;
        String [] ID2 = null;
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            ID = line.split(",");
            if(ID[0].equals(String.valueOf(id))) {
                ID2 = ID;
            }
         }

        if(ID2 != null) {
                if(Integer.parseInt(ID2[6]) != 0) {
                    System.out.println("Member Has Outstanding Fees!");
                    System.out.println("Would you like to pay now? 1 or 0");
                    c = scanner.nextInt();
                    if(c == 1) {
                        try {
                            payFee(id);
                            System.out.println("Fee has been payed!");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("Cannot Proceed if Fees are Not Paid!");
                        System.out.println("Have a Great Day!");
                        return;
                    }
                }
                else {
                    System.out.println("Valid Member");
                    addService(provider,populateMember(id));
                    return ;
                }
            }
        else{
            System.out.println("Could Not Find Member ID!");
            System.out.println("Please Enter Correct ID:");
            id = scanner.nextInt();
            validation(provider);
        }
        return;
    }

    public static void main(String [] args) throws FileNotFoundException {
        Provider test = populateProvider(100);
        if(test == null){
            System.out.println("\nError");
        }
        else{
            System.out.println("\nName: " + test.getName());
            System.out.println("\nNumber: " + test.getNumber());
            System.out.println("\nConsultations: " + test.getConsultations());
        }
    }
}
