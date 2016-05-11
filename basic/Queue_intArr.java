// Use int array to implement Queue

/**
 * Created by xiaoyaoworm on 4/16/16.
 */

public class Queue{
	int maxSize;
	int[] arr;
	int head;
	int tail;
	int nItems;

	public Queue(int size){
		maxSize = size;
		arr = new int[size];
		head = 0;
		tail = -1;
		nItems = 0;
	}

	public void enqueue(int num){
		if(tail == arr.length-1){
			tail = -1;
		} 
		if(nItems == maxSize){
			System.out.println("Queue is full, cannot enqueue.");
		}
		else {
			tail++；
			arr[tail] = num;
			nItems++;
		}
	}

	public int dequeue(){
		if(head == -1){
			head = arr.length-1;
		}
		if(nItems == 0){
			System.out.println("Queue is empty, cannot dequeue.");
			return -1;
		} else {
			int res= arr[head];
			head--;
			return res;
		}
	}

	public int peek(){
		if(head == -1){
			head = arr.length-1;
		}
		if(nItems == 0){
			System.out.println("Queue is empty, cannot peek.");
			return -1;
		} else {
			int res= arr[head];
			return res;
		}
	}

	public boolean isEmpty(){
		return nItems == 0;
	}
}