//Programmer: Marvell Suhali, Farrel Harten, Rachit Khanderwal, Tam Nguyen
//Class: CS145
//Date: 05/31/2023
//Assignment: Lab 6: Binary Search Tree
//Purpose: Program runs binary search tree
 
import java.util.Scanner;
public class BinarySearchTree
 {
     public static void main(String[] args)
    {    
        //Scanner             
        Scanner scan = new Scanner(System.in);
        BST bst = new BST(); 
        System.out.println("Binary Search Tree Test\n");          
        char ch;
        do    
        { // list of options to choose
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. count no. of values");
 
            int choice = scan.nextInt();            
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                bst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Nodes = "+ bst.countNodes());
                break;               
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            //Display the results
            System.out.print("\nPost order : ");
            bst.postOrder();
            System.out.print("\nPre order : ");
            bst.preOrder();
            System.out.print("\nIn order : ");
            bst.inOrder();
 
            System.out.println("\nDo you want to continue? (Y/N) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
 }