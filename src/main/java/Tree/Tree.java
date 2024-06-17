
package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucas
 */
public class Tree {
    
    public node root;
    
    public static class node{
        public int value;
        public node left;
        public node right;
        
        private node(int value){
            this.value = value;
        }
        public boolean isLeaf(node node){
            return (this.left == null) && (this.right == null);
        }
    }
    
    public void insrt(int value){
        if (root == null) root = new node(value);
        else{
            node newNode = new node (value);
            Queue<node> queue = new LinkedList<>();
            queue.add(root);    
            while (queue.size() > 0){
                node currentNode = queue.remove();
                if(currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                }else{
                    queue.add(currentNode.left);
                }
                if(currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                }else{
                    queue.add(currentNode.right);
                }
            }
            
            
        }
    }
    
    public void posOrder(){
        posOrder(root);
    }
    
    public void posOrder(node node){
        if(node == null){
            return;
        }
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
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
    
    public void preOrder(){
        preOrder(root);
    }
    
    public void preOrder(node node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void BFS(){
        //busca em profundidade
        if (root == null) return;
        else{
            Queue<node> queue = new LinkedList<>();
            queue.add(root);    
            while (queue.size() > 0){
                node currentNode = queue.remove();
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                System.out.println(currentNode.value);
            }
            
            
        }
    }
    
    public static void main(String [] args){
        Tree tree = new Tree();
        tree.insrt(37);
        tree.insrt(11);
        tree.insrt(66);
        tree.insrt(8);
        tree.insrt(17);
        tree.insrt(42);
        tree.insrt(72);
        System.out.println("\npre order:");
        tree.preOrder();
        System.out.println("\nin order:");
        tree.inOrder();
        System.out.println("\npos order:");
        tree.posOrder();
        System.out.println("\ndepth search:");
        tree.BFS();
        
    }
}
