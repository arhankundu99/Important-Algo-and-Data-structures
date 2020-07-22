// https://www.geeksforgeeks.org/implement-stack-using-queue/
// stack using 2 queues
class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    /*The method pop which return the element poped out of the stack*/
    // O(N) time
    int pop()
    {
        if(q1.size() == 0)return -1;
        while(q1.size() != 1)q2.add(q1.poll());
        Queue<Integer>temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.poll();
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
	    q1.add(a);
    }
}

// https://www.geeksforgeeks.org/implement-stack-using-queue/
// queue using 2 stacks
class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element
       into the queue */
    void Push(int x)
    {
	   s1.push(x);
    }
	
    
    /* The method remove which return the
      element popped out of the queue*/
    int Pop()
    {
	   if(!s2.isEmpty())return s2.pop();
	   if(s1.size() == 0)return -1;
	   while(s1.size() != 1)s2.add(s1.pop());
	   return s1.pop();
    }
}
