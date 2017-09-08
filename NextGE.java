package StackQueuePrograms;

/**
 * Created by Goutam on 9/8/2017.
 */
public class NextGE {
    
    public static class Stack {
        public static int top;
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
    
    public static void printNGE(int a[], int n){
        Stack s = new Stack();
        s.top = -1;
        int stackPeekElement, arrayNextElement;
        
        s.push(a[0]);
        
        for(int i=1; i<n; i++){
            arrayNextElement = a[i];
            if(!s.isEmpty(s.top)){
                stackPeekElement = s.pop();
                
                while(stackPeekElement < arrayNextElement){
                    System.out.println(stackPeekElement + " === " + arrayNextElement);
                    if(s.isEmpty(s.top))
                        break;
                    s.pop();
                }
                
                if(stackPeekElement >= arrayNextElement){
                    s.push(stackPeekElement);
                }
            }
            s.push(arrayNextElement);
        }

        while (!s.isEmpty(s.top)) {
            stackPeekElement = s.pop();
            arrayNextElement = -1;
            System.out.println(stackPeekElement + " === " + arrayNextElement);
        }
    }
    
    public static void main(String args[]){
        int arr[] = new int[]{11,13,21,3};
        printNGE(arr, arr.length);
    }
}
