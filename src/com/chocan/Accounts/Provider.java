package com.chocan.Accounts;

import com.chocan.ProductService.Product;

import java.util.List;

public class Provider extends Account{

    private int consultations; // 3 digits
    private int weekFee; // Up to $99,999.99

    public Provider(String name, int number, String address, String city, String state, int zip, List<Product> productServices, int consultations, int weekFee) {
        super(name, number, address, city, state, zip, productServices);
        this.consultations = consultations;
        this.weekFee = weekFee;
    }
}
