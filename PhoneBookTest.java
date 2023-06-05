import java.util.LinkedList;
import java.util.Scanner;

public class PhoneBookTest {
    public static void printMainMenu() {
        System.out.println("When Creating a New Entry Input the information in the order of Name, Adresss, City, Mobile.");
        System.out.println("Choose (1-6): ");
        System.out.println("1: Add a New Entry");
        System.out.println("2: Edit Entry");
        System.out.println("3: Delete Entry");
        System.out.println("4: Sort Entries");
        System.out.println("5: Show Entries");
        System.out.println("6: Exit");
    }
    public static PhonebookManager showAddMenu(PhonebookManager manager) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter New Entry Details");
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        String address = sc.nextLine();
        String city = sc.nextLine();
        String mobile = sc.nextLine();

        manager.addNewEntry(firstName, lastName, address, city, mobile);
        return manager;
    }
    public static PhonebookManager showDeleteMenu(PhonebookManager manager) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name to Delete");
        String firstName = sc.nextLine();

        manager.deleteEntry(firstName);
        return manager;
    }
    public static PhonebookManager showModifyMenu(PhonebookManager manager) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter First Name to Modify Entry");
        String firstName = sc.nextLine();
        System.out.println("What Would You Lke to Modify - ");
        System.out.println("1: First Name");
        System.out.println("2: Last Name");
        System.out.println("3: Address");
        System.out.println("4: City");
        System.out.println("5: Mobile");
        System.out.println("Type (1-5): ");
        int param = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter New Value");
        String val = sc.nextLine();

        manager.modifyEntry(firstName, val, param);
        return manager;
    }
    public static PhonebookManager sortPhoneBook(PhonebookManager manager) {
        System.out.println("Sorted by Last Name");
        manager.sortPhoneBookByLastName();

        return manager;
    }
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner sc = new Scanner(System.in);
        while(true) {
            printMainMenu();
            int choice = sc.nextInt();
            if(choice > 6 || choice <= 0) {
                System.out.println("\n Wrong Input, Please Enter A Choice Between 1-6!!\n");
                continue;
            }
            if(choice == 1) manager = showAddMenu(manager);
            else if(choice == 2) manager = showModifyMenu(manager);
            else if(choice == 3) manager = showDeleteMenu(manager);
            else if(choice == 4) manager = sortPhoneBook(manager);
            else if(choice == 5) manager.displayPhoneBook();
            else break;
        }
        System.out.println("End");       
    }
}
