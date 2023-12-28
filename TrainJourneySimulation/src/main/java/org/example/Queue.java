package org.example;

public class Queue {

    private int maxSize;
    private int front;
    private int rear;
    private int nPassengers;
    private Passenger[] passengers;

    public Queue(int max) {
        maxSize = max;
        passengers = new Passenger[max];
        front = 0;
        rear = -1;
        nPassengers = 0;
    }

    public void setnPassengers(int nPassengers) {
        this.nPassengers = nPassengers;
    }

    public int getnPassengers() {
        return nPassengers;
    }

    public void insertPassenger(Passenger passenger) {
        if (rear == maxSize - 1) {
            System.out.println("Train is full");
        } else {
            passengers[++rear] = passenger;
            nPassengers++;
        }
    }

    public Passenger peekFront(){
        if(nPassengers == 0){
            System.out.println("Queue is empty");
            return null;
        }
        else{
            return passengers[front];
        }
    }

    public int getMaxSize() {
        return maxSize;
    }
}
