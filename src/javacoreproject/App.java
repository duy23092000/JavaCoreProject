package javacoreproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<Order>();

    public static void menu()  {
        int function = 0;
        do {
            Scanner userChoice = new Scanner(System.in);
            System.out.println("<<<<<<<<<<<<<<<<<Welcome to Jayzer Shop>>>>>>>>>>>>>>>>");
            System.out.println("-------------------LIST OF FUNCTION-------------------");
            System.out.println("1. Add product");
            System.out.println("2. Display product");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Order product");
            System.out.println("6. Display order list");
            System.out.println("7. Exit");
            try {
                System.out.println("Choose a function: ");
                function = userChoice.nextInt();
                ProductSystem productSystem = new ProductSystem();
                OrderSystem orderSystem = new OrderSystem();
                if (function > 7) {
                    throw new InputMismatchException("Invalid input");
                }

                switch (function) {
                    case 1:
                        productSystem.add();
                        break;
                    case 2:
                        productSystem.show();
                        break;
                    case 3:
                        productSystem.update();
                        break;
                    case 4:
                        productSystem.delete();
                        break;
                    case 5:
                        orderSystem.order();
                        break;
                    case 6:
                        orderSystem.show();
                        break;
                    default:
                        break;
                }

            } catch (InputMismatchException ex) {
                System.err.println("Invalid input! Please choose again.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (function != 7);
        System.out.println("Thank you for shopping with us!");
    }


}

