// ****** Adapted from class code

/**
 * Array based queue used to hold values of type T.
 * @param <T> Type of value queue will hold
 */
public class MyQueueArray<T> {
    private int maxSize;
    private T[] queueArray;

    private int front;
    private int rear;

    private int nItems;

    /**
     * Constructor to initialize queue
     * @param s size of queue
     */
    public MyQueueArray(int s){
        maxSize = s;
        queueArray = (T[])new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * add to beginning of queue
     * @param j item to add to queue
     */
    public void enqueue(T j){
        if(rear == maxSize -1){
            rear = -1;
        }

        queueArray[++rear] = j;
        nItems++;
    }


    /**
     * removes and returns item from front of queue
     * @return item first in line of queue
     */
    public T dequeue(){
        T temp = queueArray[front++];

        // wraparound
        if (front==maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    /**
     * returns but does not remove item from beginning of queue
     * @return item at front of queue
     */
    public T peekFront(){
        return queueArray[front];
    }


    /**
     * Checks if queue is empty
     * @return boolean if queue is empty
     */
    public boolean isEmpty(){
        return (nItems==0);
    }

    /**
     * Checks if queue is full
     * @return boolean if queue is full
     */
    public boolean isFull(){
        return (nItems==maxSize);
    }

    /**
     * gives size of queue as integer
     * @return size of queue as int
     */
    public int size(){
        return nItems;
    }


}
