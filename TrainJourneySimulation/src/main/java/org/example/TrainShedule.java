package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

//circular linked list
public class TrainShedule {

    public Train first = null;
    public Train last = null;

    private static final Logger logger = LoggerFactory.getLogger(TrainShedule.class);

    public void addTrain(Train train){
        //Train newTrain = new Train(train.getTrainNo(), train.getTrainType(), train.getTime());

        if(first == null){
            first = train;
            last = train;
            train.next = first;
        }else{
            last.next = train;
            last = train;
            train.next = first;
        }
    }

    public void displayTrains(){
        Train current = first;

        if (first == null) {
            logger.info("The list is empty");
        } else {
            do {
                System.out.print(current.getTrainNo() + " ");
                current = current.next;
            }while (current != first);
        }
    }

    public List<Train> getTrains(){
        List<Train> t1 = new ArrayList<>();
        Train current = first;

        if (first == null) {
            logger.info("The list is empty");
            t1 = null;
        } else {
            do {
                //System.out.print(current.getTrainNo() + " ");
                t1.add(current);
                current = current.next;
            }while (current != first);
        }
        return t1;
    }
}
