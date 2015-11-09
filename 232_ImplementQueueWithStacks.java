class MyQueue {
    
    Stack<Integer> first = new Stack<Integer>();
    Stack<Integer> second = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
       while(!second.isEmpty()){
           first.push(second.pop());
       }
       first.push(x);
       while(!first.isEmpty()){
           second.push(first.pop());
       }
    }

    // Removes the element from in front of queue.
    public void pop() {
        second.pop();
    }

    // Get the front element.
    public int peek() {
        return second.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return second.isEmpty();
    }
}