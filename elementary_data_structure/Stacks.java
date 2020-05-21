
class Stack {
    static int MAX;
    int top = -1;
    int[] ar = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    Stack(int size) {
        MAX = size;
    }

    boolean isEmpty() {
        if (top < 0) {
            System.out.println("The Stack is Empty");
            return true;
        } else
            return false;
    }

    int pop() {
        if (top < 0) {
            System.out.println("The Stack is already empty (Stack Underflow)");
            return 0;

        } else {
            int m = ar[top];
            top--;
            System.out.println("Popped From Stack: " + m);
            return m;
        }

    }

    void push(int m) {
        if (top >= (MAX - 1)) {
            System.out.println("The Stack is already full (Stack Overflow)");

        } else {
            System.out.println("Pushed to Stack:" + m);
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
        System.out.println("");

    }

    public static void main(String[] args) {
        Stack ob = new Stack(10);
        ob.push(5);
        ob.printArray();
        ob.push(17);
        ob.printArray();

        ob.push(14);
        ob.printArray();

        int c = ob.pop();
        ob.printArray();

        System.out.println("The element deleted was: " + c);

    }
}