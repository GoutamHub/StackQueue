package StackQueuePrograms;

import java.util.Stack;



/**
 * Created by Goutam on 9/9/2017.
 */
public class StackQ {

    /* class of queue having two stacks */
    static class Queue
    {
        Stack<Integer> stack1 ;
        Stack<Integer> stack2 ;
    }
    
    private static void push(Stack<Integer> s, int x) {
        s.push(x);
    }

    private static int pop(Stack<Integer> s) {
        
        if(s.isEmpty()){
            System.out.println("Stack is empty");
            System.exit(0); 
        }
        
        return s.pop();
    }

    /*Function to enqueue an item to the queue*/
    public static void enQueue(Queue q, int x)
    {
        /*Push x to stack1*/
        push(q.stack1, x);
    }


    private static int deQueue(Queue q) {
        int x;

        /*1) If both stacks are empty then error.*/
        if(q.stack1.isEmpty() && q.stack2.isEmpty()){
            System.out.println("Q is empty");
            System.exit(0);
        }
        
        /*2) If stack2 is empty
        While stack1 is not empty, push everything from stack1 to stack2.*/
        if(q.stack2.isEmpty() && !q.stack1.isEmpty()){
            
            while(!q.stack1.isEmpty()){
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }

        /*3) Pop the element from stack2 and return it.*/
        x = pop(q.stack2);
        return x;
    }

    


    public static void main(String args[]){
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);
        
         /* Dequeue items */
        System.out.print(deQueue(q)+ " ");
        System.out.print(deQueue(q)+ " ");
        System.out.print(deQueue(q)+ " ");
        
    }

    
}
