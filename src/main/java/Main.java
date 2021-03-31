import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.showPhonebook();
    }
    void showPhonebook() {
        String contactInput = "";
        do {
            System.out.println("Welcome to the phonebook, please choose an option: ");
            System.out.println("Press 1 - To add new contact");
            System.out.println("Press 2 - To view all contacts");
            System.out.println("Press 3 - To view single contact");
            System.out.println("Press 4 - To update contact");
            System.out.println("Press 5 - To find contact by name");
            System.out.println("Press 6 - To find contact by phone");
            System.out.println("Press 7 - To find contact by email");
            System.out.println("Press 8 - To remove contact");
            System.out.println("Press 9 - To quit");

            System.out.println("Enter your choice:");
            contactInput = scanner.nextLine();

            switch (contactInput) {
                case "1":
                    addUser();
                    break;
                case "2":
                    viewAllUsers();
                    break;
                case "3":
                    viewSingleUser();
                    break;
                case "4":
                    updateUser();
                    break;
                case "5":
                    searchByName();
                    break;
                case "6":
                    searchByPhone();
                    break;
                case "7":
                    searchByEmail();
                    break;
                case "8":
                    deleteUser();
                    break;
                case "9":
                    System.out.println("Exiting phonebook!");
                    break;
            }

            System.out.print("\nPress 0 to continue\n");
            scanner.nextLine();

        } while (!contactInput.equalsIgnoreCase("9"));

        return;
    }

    void addUser() {
        System.out.println("\n Add contact\n");

        User user = new User();

        System.out.println("Enter contact name:");
        user.userName = scanner.nextLine();

        System.out.println("Enter contact phone number:");
        user.userPhone = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter contact email:");
        user.userEmail = scanner.nextLine();

        user.userId = UUID.randomUUID();

        String message = menu.addUser(user);
        System.out.println(message);
    }
    void viewAllUsers() {
        ArrayList<User> allUsers = menu.getAllUsers();
        System.out.println("\t\t All available contacts\n");
        System.out.println("Id\tName\t  Phone Number \t\t    Email");

        int counter = 0;
        for (User user: allUsers) {
            System.out.println(counter + ". \t" + user.userName + " \t\t" + user.userPhone + "\t\t" + user.userEmail);
            counter ++;
        }
    }
    void viewSingleUser() {
        System.out.println("View one contact\n");
        System.out.print("Enter contact ID: ");

        int userId = scanner.nextInt();
        User user = menu.getSingleUser(userId);

        System.out.println("Contact ID: " + user.userId );
        System.out.println("Contact name: " + user.userName);
        System.out.println("Contact phone number: " + user.userPhone);
        System.out.println("Contact email: " + user.userEmail);
    }
    void updateUser() {
        this.viewAllUsers();

        User user = new User();
        System.out.println("\nUpdate contact\n");

        System.out.println("Enter contact ID:");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new contact name: ");
        user.userName = scanner.nextLine();

        System.out.println("Enter new contact phone number: ");
        user.userPhone = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new contact email: ");
        user.userEmail = scanner.nextLine();

        String response = menu.updateUser(userId, user);
        System.out.println(response);
    }
    void searchByName(){
    }
    void searchByPhone(){
    }
    void searchByEmail(){
    }
    void deleteUser() {
        System.out.println("Which contact do you want to remove?");
        this.viewAllUsers();
        System.out.println("Enter contact ID: ");

        int userId = scanner.nextInt();
        String message = menu.removeUser(userId);
        System.out.println(message);
    }
}

