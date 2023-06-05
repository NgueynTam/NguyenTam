//Programmer: Marvell Suhali, Farrel Harten, Rachit Khanderwal, Tam Nguyen
//Class: CS145
//Date: 05/31/2023
//Assignment: Lab 6: Binary Search Tree
//Purpose: Program runs binary search tree

class BST
 {
     private BSTNode root;
 
     //Constructor
     public BST()
     {
         root = null;
     }//to check if there is no input
     public boolean isEmpty()
     {
         return root == null;
     }
     //Inserting data
     public void insert(int data)
     {
         root = insert(root, data);
     }
     //Inserting data recursively
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     //for when tree is empty
     public void delete(int k)
     {
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (search(k) == false)
             System.out.println("Sorry "+ k +" is not present");
         else
         {
             root = delete(root, k);
             System.out.println(k+ " deleted from the tree");
         }
     }//delete data
     private BSTNode delete(BSTNode root, int k)
     {
         BSTNode p, p2, n;
         if (root.getData() == k)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k < root.getData())
         {
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
     //counting number of values inputted
     public int countNodes()
     {
         return countNodes(root);
     }
     //counting values recursively
     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     //To search for number
     public boolean search(int val)
     {
         return search(root, val);
     }
     //Search recursively
     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     //Inorder traversal
     public void inOrder()
     {
         inOrder(root);
     }
     private void inOrder(BSTNode r)
     {
         if (r != null)
         {
             inOrder(r.getLeft());
             System.out.print(r.getData() +" ");
             inOrder(r.getRight());
         }
     }
     //Preorder traversal
     public void preOrder()
     {
         preOrder(root);
     }
     private void preOrder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preOrder(r.getLeft());             
             preOrder(r.getRight());
         }
     }
     //Postorder traversal
     public void postOrder()
     {
         postOrder(root);
     }
     private void postOrder(BSTNode r)
     {
         if (r != null)
         {
             postOrder(r.getLeft());             
             postOrder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }     
 }