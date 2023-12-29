package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue q = new Queue(5);

    @Test
    void testConstructor() {
        q.setnPassengers(4);

        assertEquals(4, q.getnPassengers());
        assertEquals(5, q.getMaxSize());
    }

    @Test
    void testQueue() {
        Passenger p1 = new Passenger(0, 3);

        q.insertPassenger(p1);

        assertNotNull(q);

        assertEquals(p1,q.peekFront());
    }

    @Test
    void testNullQueue(){
        Queue q1 = new Queue(0);

        assertEquals(null, q1.peekFront());
    }

}