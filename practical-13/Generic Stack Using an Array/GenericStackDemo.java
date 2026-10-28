
class GenericStack<T> {
    private Object[] stack;
    private int top;

    public GenericStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity must be positive");
        }

        stack = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }

        T value = (T) stack[top];
        stack[top] = null;
        top--;

        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        GenericStack<Integer> numbers =
            new GenericStack<>(3);

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Integer stack:");
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());

        GenericStack<String> names =
            new GenericStack<>(3);

        names.push("Rahul");
        names.push("Priya");

        System.out.println("String stack:");
        System.out.println(names.pop());
        System.out.println(names.pop());

        System.out.println("Empty stack test:");
        System.out.println(numbers.pop());
        System.out.println("Is empty: " + numbers.isEmpty());
    }
}
