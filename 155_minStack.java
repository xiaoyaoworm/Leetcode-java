class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        if(stack.isEmpty()){
            minStack.push(x);
        } else{
            minStack.push(Math.min(x,minStack.peek()));
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.isEmpty()) return;
        else {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
