package product;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class productService {

    public static String path = "products.txt";

    public static void addproduct() {
        System.out.println("enter product name");
        String name = productDetails.scaner.nextLine();

        System.out.println("enter product amount");
        double amount = productDetails.scaner.nextDouble();
        productDetails.scaner.nextLine();

        System.out.println("enter Product Rating");
        double rating = productDetails.scaner.nextDouble();
        productDetails.scaner.nextLine();

        productDetails p = new productDetails(name, amount, rating);
        addProduct(p);

    }

    public static void addProduct(productDetails p) {
        File file = new File(path);
        try (FileWriter fileWritter = new FileWriter(file, true)) {

            fileWritter.write(p.getName() + "," + p.getAmount() + "," + p.getRating() + "\n");
        } catch (Exception e) {

        }
    }

    public static void viewProducts() {
        File file = new File(path);

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void getproduct() {
        System.out.println("Enter product name");
        String name = productDetails.scaner.nextLine();

        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            productDetails p = null;

            while ((line = bufferedReader.readLine()) != null) {

                String arr[] = line.split(",");

                if (arr[0].equals(name)) {
                    p = new productDetails(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
                    System.out.println(p);
                    System.out.println("-----------------------------------------");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void Deleteproduct() {
        System.out.println("Enter product name");
        String name = productDetails.scaner.nextLine();

        System.out.println("enter product amount");
        double amount = productDetails.scaner.nextDouble();
        productDetails.scaner.nextLine();

        System.out.println("enter Product Rating");
        double rating = productDetails.scaner.nextDouble();
        productDetails.scaner.nextLine();

        File file = new File(path);
        File temp = new File("temp.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(temp))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String arr[] = line.split(",");

                if (arr[0].equals(name) && Double.parseDouble(arr[1]) == amount
                        && Double.parseDouble(arr[2]) == rating) {
                    System.out.println("---- Product Delete Successfully ---");
                    continue;
                }
                bufferedWriter.write(line + System.lineSeparator());
            }

            if (!file.delete()) {
                throw new Exception("Failed to delete the original file");

            }
            if (!temp.renameTo(file)) {
                throw new Exception("Failed to rename the temp file to original file name");

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void updateProduct() {

        File file = new File(path);
        File temp = new File("temp.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(temp))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");

                System.out.println("Enter option: 1 Name || 2 Amount || 3 Rating");
                int option = productDetails.scaner.nextInt();
                productDetails.scaner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Enter product name");
                        String name = productDetails.scaner.nextLine();
                        arr[0] = name;
                        break;

                    case 2:
                        System.out.println("enter product amount");
                        double amount = productDetails.scaner.nextDouble();
                        productDetails.scaner.nextLine();

                        arr[1] = String.valueOf(amount);
                        break;

                    case 3:
                        System.out.println("enter Product Rating");
                        double rating = productDetails.scaner.nextDouble();
                        productDetails.scaner.nextLine();

                        arr[2] = String.valueOf(rating);
                    default:
                        throw new Exception("Invalid Option: " + option);
                }
                bufferedWriter.write(String.join(",", arr) + System.lineSeparator());
            }
            if (!file.delete()) {
                throw new Exception("Failed to delete the original file");
            }
            if (!temp.renameTo(file)) {
                throw new Exception("Failed to rename the temp file to original file name");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
