package org.example;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<Train extends Comparable<Train>> {

    private List<Train> trains;

    public PriorityQueue(){
        this.trains = new ArrayList<>();
    }

    public void enqueue(Train train){
        trains.add(train);

        trains.sort(null);
    }

    public Train dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        return trains.remove(0);
    }

    public boolean isEmpty(){
        return trains.isEmpty();
    }

    private int size(){
        return trains.size();
    }
}
