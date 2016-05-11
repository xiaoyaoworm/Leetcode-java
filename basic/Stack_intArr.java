// Use int array to implement Stack

/**
 * Created by xiaoyaoworm on 4/16/16.
 */
public class Stack {
    int maxSize;
    int[] arr;
    int top;

    public Stack(int size){
        maxSize = size;
        arr = new int[size];
        top = -1;
    }


    public void push(int num){
        if(top == arr.length - 1){
            System.out.println("Stack is full, cannot push.");
        } else {
            top++;
            arr[top] = num;
        }
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack is empty, cannot pop.");
            return -1;
        }
        else{
            int res = arr[top];
            arr[top] = 0;
            top--;
            return res;
        }
    }

    public boolean isEmpty(){
        if(top == -1) return true;
        else return false;
    }

    public int peek(){
        return arr[top];
    }
}

