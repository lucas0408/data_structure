/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author lucas
 */
public class Queue {
    private Node first;
    private Node last;
    private int lenght;
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public Queue(int value){
        Node newValue = new Node(value);
        first = newValue;
        last = newValue;
        lenght ++;
    }
    
    public void getFirst(){
        if(first != null){
            System.out.println("first: " + first.value);
        }else{
            System.out.println("lista vazia");
        }
    }
    public void getLat(){
        if(last != null){
            System.out.println("last: " + last.value);
        }else{
            System.out.println("lista vazia");
        }
    }
    
    public void getLenght(){
         System.out.println("lenght: " + lenght);
    }
    
    public void print(){
        System.out.println("\nnew query");
        Node temp = first;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    
    public void enqueue(int value){
        Node novo = new Node(value);
        if (lenght == 0){
            return;
        }
        last.next = novo;
        last = novo;
            lenght ++;
    }
    
     public void dequeue(){
        if (lenght == 0){
            return;
        }
        if (lenght == 1){
            first = null;
            last = null;
            return;
        }
        Node tem = first;
        first = tem.next;
        tem = null;
        lenght --;
        
    }
     
     public static void main(String [] args){
         Queue fila = new Queue(1);
         fila.enqueue(2);
         fila.enqueue(3);
         fila.print();
         fila.getFirst();
         fila.getLat();
         fila.getLenght();
         fila.dequeue();
         fila.print();
         fila.getFirst();
         fila.getLat();
         fila.getLenght();
         
     } 
    
    
}
