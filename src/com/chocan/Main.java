package com.chocan;

import com.chocan.Controllers.AccountController;
import com.chocan.Accounts.Provider;
import com.chocan.Auth.Logger;

import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
	    /* Login */
        int providerNum = Logger.login();
        /* Populate Current Logged In Provider */
        Provider provider = AccountController.populateProvider(providerNum);
        if(provider == null) {
            System.out.println("Error");
        }
        else{
            System.out.println("Welcome Back " + provider.getName());
        }

        /* Call Menu */







    }
}
