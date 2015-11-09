class MyStack {
    
    LinkedList<Integer> one = new LinkedList<Integer>();
    LinkedList<Integer> two = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        two.add(x);
        while(!one.isEmpty()){
            two.add(one.remove());
        }
        LinkedList<Integer> temp = two;
        two = one;
        one = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        one.remove();
    }

    // Get the top element.
    public int top() {
        return one.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return one.isEmpty();
    }
}