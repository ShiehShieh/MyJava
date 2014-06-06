/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3;

/**
 *
 * @author Zhao Qinpei
 */
public class QueueTest {
    private int[] items = new int[10];
    private int numItems = 0;
    
    public void add( int i ){
        items[numItems] = i;
        numItems ++;
    }
    
    public int next(){
        int n = items[0];
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
        QueueTest q = new QueueTest();
        System.out.println(q.isEmpty());
        
        q.add(24);
        System.out.println("first in queue is: " + q.next());
    }
    
}
