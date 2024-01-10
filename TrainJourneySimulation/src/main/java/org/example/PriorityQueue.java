package org.example;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue{

    //return the head value
    public static Train peek(Node head){
        return (head).train;
    }

    //remove the element with the highest priority from the queue
    public static Node pop(Node head){
        Node temp = head;
        head = head.next;
        return head;
    }

    //push according to priority
    public static Node push(Node head, Train t, int p){
        Node start =  head;

        Node temp = new Node(t,p);

        if(head.priority > p){
            temp.next = head;
            head = temp;
        }else{
            while(start.next != null && start.next.priority < p){
                start = start.next;
            }

            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    //check the list is empty
    public static int isEmpty(Node head){
        return head == null ? 1 : 0;
    }
}
