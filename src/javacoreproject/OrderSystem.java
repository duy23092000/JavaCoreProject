package javacoreproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSystem {
    public void order() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------ORDER PRODUCT HERE!---------------");
        try {
            System.out.println("Enter order's ID:");
            int id = input.nextInt();

            input.nextLine();

            System.out.println("Enter customer's name:");
            String customerName = input.nextLine();

            System.out.println("Enter customer's phone number:");
            String customerPhoneNumber = input.nextLine();

            System.out.println("Enter customer's email address");
            String customerEmailAddress = input.nextLine();

            Order order = new Order(id, customerName, customerEmailAddress, customerPhoneNumber);

            int productId = -1;
            while (true) {
                input = new Scanner(System.in);

                System.out.println("Enter product's ID: ");
                productId = input.nextInt();

                if (productId == -1) {
                    break;
                }

                Product p3 = new Product();

                for (Product p : App.PRODUCTS) {
                    if (p.getId() == productId) {
                        p3 = p;
                        break;
                    }
                }
                if (productId != p3.getId()) {
                    System.out.println("This ID does not exist, please try again!");
                    break;
                }

                System.out.println("Enter product's quantity");
                int productQty = input.nextInt();

                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setId(1);
                orderDetails.setOrderId(order.getId());
                orderDetails.setPrice(p3.getPrice());
                orderDetails.setProductId(productId);
                orderDetails.setQuantity(productQty);

                order.getOrderDetails().add(orderDetails);

            }

            App.ORDERS.add(order);

        } catch (InputMismatchException ex) {
            System.err.println("Invalid input! Please choose again.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void show() {
        System.out.println("**Order list**");
        System.out.printf("%5s %5s %12s %9s %12s %5s %17s%n", "ID", "|", "Name", "|",
                "Phone No.", "|", "Email");
        System.out.println("-----------------------------------------------------------------" +
                "--------------------------------");
        ProductSystem productSystem = new ProductSystem();
        for (Order order : App.ORDERS) {
            System.out.printf("%5s %5s %12s %9s %12s %5s %17s%n", order.getId(), "|", order.getCustomerName(), "|",
                    order.getCustomerEmailAddress() , "|",order.getCustomerPhoneNumber()) ;

            System.out.println();

            System.out.println("**Order details**");
            System.out.printf("%5s %5s %12s %9s %12s %5s %17s%n", "No.", "|", "Product Name", "|",
                    "Price", "|", "Quantity");
            System.out.println("-----------------------------------------------------------------" +
                    "--------------------------------");
            int i = 1;
            for (OrderDetails orderDetails : order.getOrderDetails()) {

                Product p = productSystem.getById(orderDetails.getProductId());

                System.out.printf("%5s %5s %12s %9s %12s %5s %17s%n", i, "|", p.getProductName(), "|",
                        orderDetails.getPrice(), "|", orderDetails.getQuantity());
                i++;
            }
        }
        System.out.println();
    }


}
