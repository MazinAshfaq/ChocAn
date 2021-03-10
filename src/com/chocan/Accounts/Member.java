package com.chocan.Accounts;

import com.chocan.ProductService.Product;

import java.util.List;

public class Member extends Account{
    private int fees;
    public Member(String name, int number, String address, String city, String state, int zip, int fees) {
        super(name, number, address, city, state, zip);
        this.fees = fees;
    }
}
