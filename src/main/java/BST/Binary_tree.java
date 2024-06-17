/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BST;


/**
 *
 * @author lucas
 */
public class Binary_tree {
    
    node root;

    public class node{
        int value;
        
        public node right;
        
        public node left;

        public node(int value) {
            this.value = value;
        }
    }
    private void insert(node root, int value) {
        if(root == null || value == root.value) return;
        if(value > root.value){
            if (root.right == null) root.right = new node(value);
            else insert(root.right, value);
        }else{
            if (root.left == null) root.left = new node(value);
            else insert(root.left, value);
        }
    }
    
    public void insert(int value){
        if (root == null){
            root = new node(value);
        }else{
            insert(root, value);
        }
    }
    
    public boolean contains(int value){
        return contains(root, value);
    }
    
    private boolean contains(final node root, final int value) {
        if (root == null)return false;
        if(root.value == value) return true;
        if(value > root.value){
            if (root.right != null) return contains(root.right, value);
        }else{
            if (root.left != null) return contains(root.left, value);
        }
        return false;
    }
    
    public int minValue(node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    
    public void deleteNode(int value){
        deleteNode(root, value);
    }
    public node deleteNode(node root, int value){
        if(root == null) return null;
        
        if(value < root.value) {
            root.left = deleteNode(root.left, value);
        }else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if((root.right == null) && (root.left == null)){
                return null;
            } else if (root.left == null){
                root = root.right;
            } else if (root.right == null){
                root = root.left;
            }else{
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }
    
     public void inOrder(){
        inOrder(root);
    }
    
    public void inOrder(node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
        
    
    public static void main (String [] args){
        Binary_tree tree = new Binary_tree();
        tree.insert(37);
        tree.insert(66);
        tree.insert(42);
        tree.insert(11);
        tree.insert(72);
        tree.insert(8);
        tree.insert(7);
        System.out.println(tree.contains(72));
        System.out.println(tree.contains(4));
        tree.inOrder();
        System.out.println("\nlist after remove 66:");
        tree.deleteNode(66);
        tree.inOrder();
        
    }
}
