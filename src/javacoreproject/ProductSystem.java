package javacoreproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductSystem {
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("**Enter product information**");
        try {
            System.out.println("Enter product's ID:");
            int id = input.nextInt();

            input.nextLine();

            System.out.println("Enter product's name:");
            String name = input.nextLine();

            System.out.println("Enter product's quantity:");
            int quantity = input.nextInt();

            input.nextLine();

            System.out.println("Enter product's description:");
            String description = input.nextLine();

            System.out.println("Enter product's price:");
            double price = input.nextDouble();

            Product p = new Product(id, name, quantity, description, price);
            App.PRODUCTS.add(p);

        } catch (InputMismatchException ex) {
            System.err.println("Invalid input! Please choose again.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void show() {
        System.out.println("**Product list**");
        System.out.println(String.format("%5s %5s %12s %9s %12s %5s %17s %8s %10s", "ID", "|", "Name", "|",
                "Quantity", "|", "Description", "|", "Price"));
        System.out.println("-----------------------------------------------------------------" +
                "--------------------------------");
        for (Product p : App.PRODUCTS) {
            System.out.println(String.format("%5s %5s %12s %9s %10s %7s %17s %8s %10s", p.getId(), "|", p.getProductName(), "|",
                    p.getProductQuantity(), "|", p.getProductDescription(), "|", p.getPrice()));
        }
        System.out.println();
    }

    public void update() {
        Scanner input = new Scanner(System.in);
        try {

            System.out.println("Enter product's ID: ");
            int id = input.nextInt();
            Product p1 = new Product();

            for (Product p : App.PRODUCTS) {
                if (p.getId() == id) {
                    p1 = p;
                    break;
                }
            }
            if (id != p1.getId()) {
                System.out.println("This ID does not exist, please try again!");
            }

            System.out.println("Product information");
            System.out.printf("%5s %5s %12s %9s %12s %5s %17s %8s %10s%n", "ID", "|", "Name", "|",
                    "Quantity", "|", "Description", "|", "Price");
            System.out.println("-----------------------------------------------------------------" +
                    "--------------------------------");
            System.out.printf("%5s %5s %12s %9s %10s %7s %17s %8s %10s%n", p1.getId(), "|", p1.getProductName(), "|",
                    p1.getProductQuantity(), "|", p1.getProductDescription(), "|", p1.getPrice());
            for (int i = 0; i < App.PRODUCTS.size(); i++) {
                if (id == App.PRODUCTS.get(i).getId()) {

                    input.nextLine();

                    System.out.println("Enter product's name:");
                    String name = input.nextLine();

                    System.out.println("Enter product's quantity:");
                    int quantity = input.nextInt();

                    input.nextLine();

                    System.out.println("Enter product's description:");
                    String description = input.nextLine();

                    System.out.println("Enter product's price:");
                    double price = input.nextDouble();

                    App.PRODUCTS.get(i).setProductName(name);
                    App.PRODUCTS.get(i).setProductQuantity(quantity);
                    App.PRODUCTS.get(i).setProductDescription(description);
                    App.PRODUCTS.get(i).setPrice(price);

                }
            }
        } catch (InputMismatchException ex) {
            System.err.println("Invalid input! Please choose again.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter product's ID: ");
            int id = input.nextInt();
            Product p2 = new Product();

            for (Product p : App.PRODUCTS) {
                if (p.getId() == id) {
                    p2 = p;
                    break;
                }
            }

            if (id != p2.getId()) {
                System.out.println("This ID does not exist, please try again!");
            }

            for (int i = 0; i < App.PRODUCTS.size(); i++) {
                if (id == App.PRODUCTS.get(i).getId()) {
                    App.PRODUCTS.remove(p2);
                }
            }
        } catch (InputMismatchException ex) {
            System.err.println("Invalid input! Please choose again.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Product getById(int id) {
        Product product = new Product();

        for (Product p : App.PRODUCTS) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }

}
