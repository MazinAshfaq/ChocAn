package com.chocan.Accounts;

import com.chocan.ProductService.Product;

import java.util.List;

public class Member extends Account{

    private int valid;
    public Member(String name, int number, String address, String city, String state, int zip, int valid) {
        super(name, number, address, city, state, zip);
        this.valid = valid;
    }

    public Member() {
        super();
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
            return "Member{" +
                    "valid=" + valid +
                    '}';
        }
}

