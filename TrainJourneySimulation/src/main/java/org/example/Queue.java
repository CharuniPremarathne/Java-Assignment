package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Queue {

    private int maxSize;
    private int front;
    private int rear;
    private int nPassengers;
    private Passenger[] passengers;

    private static final Logger logger = LoggerFactory.getLogger(Queue.class);

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
            logger.info("Train is full");
        } else {
            passengers[++rear] = passenger;
            nPassengers++;
        }
    }

    public Passenger peekFront(){
        if(nPassengers == 0){
            logger.info("Queue is empty");
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
