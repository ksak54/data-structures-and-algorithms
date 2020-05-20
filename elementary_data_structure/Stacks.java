
class Stack {
    static int MAX;
    int top = -1;
    int[] ar = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    Stack(int size) {
        MAX = size;
    }

    void pop() {
        if (top < 0) {
            System.out.println("The Stack is already empty (Stack Underflow)");

        } else {

            top--;

        }

    }

    void push(int m) {
        if (top >= (MAX - 1)) {
            System.out.println("The Stack is already full (Stack Overflow)");

        } else {

            ar[++top] = m;
        }

    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = ar[top];
            return x;
        }
    }

    void printArray() {
        System.out.println("");
        System.out.println("The Stack is: ");

        for (int i = 0; i <= top; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    public static void main(String[] args) {
        Stack ob = new Stack(10);
        // int[] ar = new int[10];
        for (int i = 0; i < 10; i++) {
            ob.push(i * 5);
            ob.printArray();

        }
        ob.push(55);
        ob.printArray();

        for (int i = 0; i < 10; i++) {

            ob.pop();
        }
        ob.printArray();
        ob.pop();

    }

}