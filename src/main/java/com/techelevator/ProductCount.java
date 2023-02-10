package com.techelevator;

public class ProductCount { //this class will allow us to incorporate each item of the vendingmachine.csv file and let us start each item by 5 for every single item.
    private String code;
    private String name;
    private double price;
    private String type;
    private int count;

    public ProductCount(String code, String name, double price, String type, int itemCount){
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.count = 5; // setting the items count to 5
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static ProductCount getSnackByItemCode(String code){ //creating a method to creat an array of ProductCount objects which start off empty [0].
        ProductCount[] productList = new ProductCount[0]; //initialize array with empty amount
        for(ProductCount product : productList){ //iterates thru the productList array with and Enhanced for each loop
            if (product.getCode().equals(code)){ //checks to see if the code of the current product object is equal to the code passed through in the argument
                return product;// if they match return the current product object
            }
        }
        return null; //otherwise return null
    }

    public void reduceItemQuantityByOne(){ //made a method to reduce the number of items in inventory by 1 if method is called.
        if (count > 0) {
            count --;
        }
    }

}
