import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PhonebookManager {
    private LinkedList<ListNode> phoneBook;

    PhonebookManager() {
        this.phoneBook = new LinkedList<>();
    }
    public boolean addNewEntry(String firstName, String lastName, String address, String city, String mobile) {
        return this.phoneBook.add(new ListNode(firstName, lastName, address, city, mobile));
    }
    public void modifyEntry(String firstName, String val, int param) {
        for(ListNode contact: this.phoneBook) {
            if(contact.getFirstName().equals(firstName)) {
                if(param == 1) contact.setFirstName(val);
                else if(param == 2) contact.setLastName(val);
                else if(param == 3) contact.setAddress(val);
                else if(param == 4) contact.setMobile(val);
                else if(param == 5) contact.setCity(val);
                else {
                    System.out.println("Entry Modification Unsuccessful, Since Wrong Param Value Given!");
                    return;
                }

                System.out.println("Entry Modified Successfully!");
                return;
            }
        }
        System.out.println("Entry Modification Unsuccessful, Since User with Given Name Couldn't Be Found!");
    }
    public void deleteEntry(String firstName) {
        for(ListNode contact: this.phoneBook) {
            if(contact.getFirstName().equals(firstName)){
                this.phoneBook.remove(contact);
                System.out.println("Entry Deleted Successfully");
                return;
            }
        }
        System.out.println("Entry Deletion Unsuccessful, Since User with Given Name Couldn't Be Found!");
    }
    public void displayPhoneBook() {
        for(ListNode contact: this.phoneBook) {
            System.out.println(contact.toString());
        }
        System.out.println();
        System.out.println();
    }
    public void sortPhoneBookByLastName() {
        Collections.sort(this.phoneBook, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }
}