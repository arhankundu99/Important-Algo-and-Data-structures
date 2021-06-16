//Design a stack that supports push, pop, top and retrieving the minimum element in constant time.

//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer>stack;
    Stack<Integer>auxStack;
    public MinStack() {
        stack = new Stack<>();
        auxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(auxStack.size()==0)auxStack.push(x);
        else auxStack.push(Math.min(x,auxStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        auxStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return auxStack.peek();
    }
}
