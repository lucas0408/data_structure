/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilha;

/**
 *
 * @author lucas
 */
public class Stack {
    private Node top;
    private int height;
    
    public class Node{
        int value;
        Node next;
        
        Node(int value){
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newValue = new Node(value);
        this.height = 1;
        this.top = newValue;
    }
    
    public void getTop(){
        if(top == null){
            System.out.println("Pilha vazia");
        }else{
            System.out.println("top: " + top.value);
        }
    }
    
    public void getHight(){
        System.out.println("altura: " + height);
    }
    
    public void print(){
        Node test = top;
        while(test != null){
            System.out.println(test.value);
            test = test.next;
        }
    }
    
    public void push(int value){
        Node novo = new Node(value);
        if(height == 0){
            top = novo;
        }else{
            novo.next = top;
            top = novo;
        }
        height++;
    }
    
    public void pop(){
        if (top == null){
            return;
        }
        Node temp = top.next;
        top.next = null;
        top = temp;
        height --;
        
    }
    
    public static void main(String [] args){
        Stack stack = new Stack(6);
        System.out.println("add new items");
        stack.push(3);
        stack.push(4);
        stack.print();
        System.out.println("\nremove top");
        stack.pop();
        stack.print();
    }

}
