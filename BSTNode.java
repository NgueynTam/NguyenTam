//Programmer: Marvell Suhali, Farrel Harten, Rachit Khanderwal, Tam Nguyen
//Class: CS145
//Date: 05/31/2023
//Assignment: Lab 6: Binary Search Tree
//Purpose: Program runs binary search tree
import java.util.Scanner;
class BSTNode
 {
     BSTNode left, right;
     int data;
 
     //Constructor
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     //Setting left node
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     //Setting right node
     public void setRight(BSTNode n)
     {
         right = n;
     }
     //Getting left node
     public BSTNode getLeft()
     {
         return left;
     }
     //Getting right node
     public BSTNode getRight()
     {
         return right;
     }
     //Setting data
     public void setData(int d)
     {
         data = d;
     }
     //Get data
     public int getData()
     {
         return data;
     }     
 }
