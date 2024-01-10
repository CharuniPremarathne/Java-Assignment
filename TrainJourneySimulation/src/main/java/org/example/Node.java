package org.example;

public class Node {
    Train train;

    int priority;

    Node next;

    public Node(Train train, int priority) {
        this.train = train;
        this.priority = priority;
        this.next = null;
    }
}
