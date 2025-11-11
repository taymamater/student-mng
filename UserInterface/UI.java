package UserInterface;

import java.util.Scanner;
import ManagementLayer.*;
import java.util.Vector;

public class UI {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Operations o = new Operations();
        int choice = -1;

        while (choice != 0) {
            System.out.println("1:Add | 2:ViewID | 3:All | 4:SearchName | 0:Exit");
            if (!s.hasNextInt()) {
                s.next();  // discard invalid input
                continue;
            }
            choice = s.nextInt();
            s.nextLine(); // consume newline after the number

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = s.nextLine();
                    System.out.print("Name: ");
                    String name = s.nextLine();
                    System.out.print("Major: ");
                    String major = s.nextLine();
                    System.out.println(o.addStudent(id, name, major) ? "Added" : "Fail");
                    break;

                case 2:
                    System.out.print("ID: ");
                    String searchId = s.nextLine();
                    // Call viewStudent() twice rather than storing in an Object
                    if (o.viewStudent(searchId) == null) {
                        System.out.println("NotFound");
                    } else {
                        System.out.println(o.viewStudent(searchId));
                    }
                    break;

                case 3:
                    Vector all = o.getAll(); // raw Vector, no generic type
                    if (all.isEmpty()) {
                        System.out.println("None");
                    } else {
                        for (int i = 0; i < all.size(); i++) {
                            // Each element’s toString() is called implicitly
                            System.out.println(all.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.print("Name: ");
                    Vector matches = o.searchByName(s.nextLine()); // raw Vector
                    if (matches.isEmpty()) {
                        System.out.println("No");
                    } else {
                        for (int i = 0; i < matches.size(); i++) {
                            System.out.println(matches.get(i));
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Unknown option.");
                    break;
            }
        }
        s.close();
    }
}