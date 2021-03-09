package com.chocan.Accounts;

import com.chocan.ProductService.Product;

import java.util.List;

public class Account {
    private String name; //25 chars
    private int number; // 9 digits
    private String address; // 25 chars
    private String city; // 14 chars
    private String state; // 2 Letters
    private int zip; // 5 digits
    /*
    Need Product Service (Probably a list)
    Ideas:
    private List<Product> product;
    private Product product;
     */
    // Temporary Product Service from above
    private List<Product> productServices;

    public Account(String name, int number, String address, String city, String state, int zip, List<Product> productServices) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.productServices = productServices;
    }

    public Account(int number){
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public List<Product> getProductServices() {
        return productServices;
    }

    public void setProductServices(List<Product> productServices) {
        this.productServices = productServices;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", productServices=" + productServices +
                '}';
    }
}
