package product;

import java.util.ArrayList;
import java.util.Scanner;

public class productDetails {

   public static ArrayList<productDetails> products = new ArrayList<>();
   public static Scanner scaner = new Scanner(System.in);

   private String name;
   private double amount;
   private double rating;

   public productDetails(String name, double amount, double rating) {
      this.name = name;
      this.amount = amount;
      this.rating = rating;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }

   public double getAmount() {
      return amount;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public double getRating() {
      return rating;
   }

   @Override
   public String toString() {
      String str = "";
      str += "PRODUCT NAME: " + this.name + "\n";
      str += "PRODUCT AMOUNT: " + this.amount + "\n";
      str += "PRODUCT RATING: " + this.rating;
      return str;
   }

   public static void addProduct() {
      System.out.println("enter product name");
      String name = scaner.nextLine();

      System.out.println("enter product amount");
      double amount = scaner.nextDouble();
      scaner.nextLine();

      System.out.println("enter Product Rating");
      double rating = scaner.nextDouble();
      scaner.nextLine();

      productDetails p = new productDetails(name, amount, rating);
      products.add(p);
   }

   public static void viewProducts() {
      if (products.isEmpty()) {
         System.out.println("No Products Available");
      } else {
         for (productDetails x : products) {
            System.out.println(x.toString());
         }
      }
   }
}