/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLIst;

/**
 *
 * @author lucas
 */

public class LinkedList {
    
    private Node head;
    private Node tail;
    private int length;
    
    
    class Node{
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
        
    }
    
    public LinkedList(String data){
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead() {
        if(head == null){
            System.out.println("lista fazia");
        }else{
            System.out.println("head " + head.data);
        }
    }

    public void getTail() {
        if(tail == null){
            System.out.println("lista fazia");
        }else{
            System.out.println("tail " + tail.data);
        }
    }

    public void getLength() {
        System.out.println(length);
    }
    
    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }
    
    public void print(){
        Node temp = this.head;
            System.out.println("\nnew query");
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public void append(String data){
        Node novo = new Node(data);
        if (length == 0){
            head = novo;
            tail = novo;
        }else{
            tail.next = novo;
            tail = novo;
        }
        
        length ++;
    }
    
    public Node removeLast(){
        if(head == null){
            return null;
        }
        Node temp;
        Node pre = head;
        while(pre.next != tail){
            pre = pre.next;
        }
        temp = tail;
        pre.next = null;
        tail = pre;
        
        length --;
        if(length == 0){
            tail = null;
            head = null;
        }
        return temp;
    }
    
    public void prepend(String data){
        Node novo = new Node(data);
        if(length == 0){
            head = novo;
            tail = novo;
            return;
        }
        novo.next = head;
        head = novo;
        length ++;
    }
    
    public void removeFirst(){
        if(length == 0){
            return;
        }
        Node temp;
        temp = head.next;
        head.next = null;
        head = temp;
        length --;
    }
    
    public Node get(int index){
        if(index < 0 || index > length){
            return null;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }
    
    public boolean insert(int index, String data){
        if(index < 1 || index > length){
            return false;
        }
        if(index == 1){
            prepend(data);
            return true;
        }
        if(index == length){
            append(data);
            return true;
        }
        
        Node temp = head;
        for(int i = 1; i < index-1; i++){
            temp = temp.next;
        }
        Node novo = new Node(data);
        novo.next = temp.next;
        temp.next = novo;
        length ++;
        return true;
    }
    
    public void set(int index, String data){
        if(index < 1 || index > length){
            return;
        }
        Node temp = get(index);
        temp.data = data;
    }
    
    public void remove(int index){
        if(index < 1 || index > length){
            return;
        }
        if(index == 1){
            removeFirst();
            return;
        }
        if(index == length){
            removeLast();
            return;
        }
        
        Node temp = get(index -1);
        Node aux = temp.next;
        temp.next = aux.next;
        aux.next = null;
        length --;
    }

    public static void main(String [] args){
        LinkedList linkedList = new LinkedList("elemet 1");
        linkedList.getLength();
        linkedList.append("element 2");
        linkedList.append("element 3");
        linkedList.append("element 4");
        linkedList.append("element 5");
        linkedList.print();
        linkedList.removeLast();
        linkedList.prepend("element 0");
        linkedList.prepend("element -1");
        linkedList.print();
        linkedList.removeFirst();
        linkedList.print();
        linkedList.removeFirst();
        linkedList.print();
        linkedList.insert(3, "elemento 2.5");
        linkedList.set(2,"elemento 1.5");
        linkedList.print();
        System.out.println("\nthird position element query: " + linkedList.get(3).data);
        linkedList.getHead();
        linkedList.getTail();
        linkedList.remove(4);
        linkedList.print();
    }
    
}
