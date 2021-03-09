package com.chocan;

import com.chocan.Accounts.Provider;
import com.chocan.Auth.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.util.logging.Logger.*;

public class Main {
    // Global Helper Functions

    public static void main(String[] args) throws FileNotFoundException {
        /* 1) Provider Auth */
        int loginNum = Logger.login();
        // Populate a Provider by creating a setter function in Provider. Need to create it.
        System.out.println("\nHello Member: " + loginNum);



    }
}
