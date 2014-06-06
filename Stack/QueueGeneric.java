/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3;

/**
 *
 * @author zhapqingpei
 */
public class QueueGeneric<T> {
    private T[] items = (T[]) new Object[10];
    private int numItems = 0;
    
    public void add( T i ){
        items[numItems] = i;
        numItems ++;
    }
    
    public T next(){
        T n = items[0];
        shift();
        numItems--;
        return n;
    }
    private void shift(){
        for ( int i = 0; i+1 < numItems; i++ )
        {
            items[i] = items[i+1];
        }
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public static void main(String[] args){
        QueueGeneric<Integer> q = new QueueGeneric<Integer>();
        q.add(24);
        System.out.println("first in queue is: " + q.next());
    }    
}
