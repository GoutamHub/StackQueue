package StackQueuePrograms;

import static StackQueuePrograms.MinStack.Stack.isEmpty;
import static StackQueuePrograms.MinStack.Stack.isFull;
import static StackQueuePrograms.MinStack.Stack.top;

/**
 * Created by Goutam on 9/9/2017.
 */
public class MinStack {

    public static class Stack {
        public static int top =-1;
        public static int stack[] = new int[100];

        public static void push(int data){
            if(isFull(top)){
                System.out.println("Stack is Full");
                return;
            }
            stack[++top] = data;
        }

        public static int pop(){
            if(isEmpty(top)){
                System.out.println("Stack is Empty");
                return  -1;
            }
            return (stack[top--]);
        }

        public static boolean isFull(int top){
            return (top == 99);
        }

        public static boolean isEmpty(int top){
            return (top == -1);
        }

        public static int peek(int top){
            return stack[top];
        }
    }
    
    
    public static int minElement;
    public static Stack s = new Stack();
    
    public static void getMinElement(){
        if(isEmpty(top))
            System.out.println("The is no Min Element at present state");
        else
            System.out.println("The Min Element at present state is : " + minElement);
    }
    
    public static void peekElement(int top){
        if(isEmpty(top)){
            System.out.println("Stack is Empty.. nothing to pop out");
            return;
        }
        
        int topElement = s.peek(top);
        
        if(topElement > minElement)
            System.out.println("The Min Element at present state is : " + minElement);
        else
            System.out.println("The Min Element at present state is : " + topElement);
    }
    
    public static void pop(){
        if(isEmpty(top)){
            System.out.println("Stack is Empty.. nothing to pop out");
            return;
        }
        int y = s.pop();
        if(y < minElement){
            System.out.println("present Pop-Out Element is: " + minElement);
            minElement = 2*minElement-y;
            System.out.println("Present MinElement is: " + minElement);
            return;
        }
        System.out.println("Pop-Out Element is: " + y);
        return;
    }
    
    public static void push(int x){
        if(isFull(top)){
            System.out.println("Stack is Full!!");
            return; 
        }
        
        if(s.isEmpty(s.top)){
            System.out.println("present inserted element is: " + x);
            minElement = x;
            s.push(x);
            return;
        }
        
        if(x < minElement){
            s.push(2*x - minElement);
            System.out.println("present inserted element is: " + (2*x-minElement));
            minElement = x;
            return;
        } 
        
        s.push(x);
        System.out.println("present inserted element is: " + x);
    }
    
    public static void main(String args[]){
        MinStack ms = new MinStack();
        ms.push(3);
        ms.push(5);
        ms.getMinElement();
        ms.push(2);
        ms.push(1);
        ms.getMinElement();
        ms.pop();
        ms.getMinElement();
        ms.pop();
       // ms.peekElement(top);
    }
    
}
