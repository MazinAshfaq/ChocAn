package com.chocan.Accounts;

import com.chocan.ProductService.Product;

import java.util.List;

public class Provider extends Account{

    private int consultations; // 3 digits
    private int weekFee; // Up to $99,999.99

    public Provider(String name, int number, String address, String city, String state, int zip, int consultations, int weekFee) {
        super(name, number, address, city, state, zip);
        this.consultations = consultations;
        this.weekFee = weekFee;
    }

    public int getWeekFee() {
        return weekFee;
    }

    public void setWeekFee(int weekFee) {
        this.weekFee = weekFee;
    }

    public int getConsultations() {
        return consultations;
    }

    public void setConsultations(int consultations) {
        this.consultations = consultations;
    }
}
