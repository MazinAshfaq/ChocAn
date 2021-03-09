package com.chocan.Accounts;

import com.chocan.ProductService.Product;

import java.util.List;

public class Member extends Account{

    public Member(String name, int number, String address, String city, String state, int zip) {
        super(name, number, address, city, state, zip);
    }
}
