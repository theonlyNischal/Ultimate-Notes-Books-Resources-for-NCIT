// Class for the stack
class Stack {
  // Array to store the stack
  int[] stack;
  
  // Index of the top element of the stack
  int top;
  
  // Constructor to initialize the stack
  public Stack(int size) {
    stack = new int[size];
    top = -1;
  }
  
  // Method to push an element onto the stack
  public void push(int element) {
    // Check if the stack is full
    if (top == stack.length - 1) {
      System.out.println("Stack overflow!");
      return;
    }
    
    // Increment the top index and add the element
    stack[++top] = element;
  }
  
  // Method to pop an element from the stack
  public int pop() {
    // Check if the stack is empty
    if (top == -1) {
      System.out.println("Stack underflow!");
      return Integer.MIN_VALUE;
    }
    
    // Return the top element and decrement the top index
    return stack[top--];
  }
  
  // Method to return the top element of the stack
  public int peek() {
    // Check if the stack is empty
    if (top == -1) {
      System.out.println("Stack is empty!");
      return Integer.MIN_VALUE;
    }
    
    // Return the top element
    return stack[top];
  }
  
  // Method to check if the stack is empty
  public boolean isEmpty() {
    return top == -1;
  }
public static void main(String[] args)
{
    Stack s=new Stack(5);
    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
}
}
