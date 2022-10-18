import java.util.*;

public class ConsecutiveIntegers {

    Stack<Integer> stack;

    ConsecutiveIntegers(){
        stack = new Stack<>();
        removeConsecutiveIntegers();
    }

    public static void main(String[] args) {
        new ConsecutiveIntegers();
    }

    void removeConsecutiveIntegers(){
        Scanner scanner = new Scanner(System.in);
        int count;
        System.out.print("Enter length of list: ");
        count = scanner.nextInt();
        System.out.println("Enter integer list: ");
        int i = 0;
        while( i <= count){
            stack.push(scanner.nextInt());
            i++;
        };

//        HashSet<Integer> hashSet = new HashSet<>(stack);
        print(stack);
    }

    void print(Stack<Integer> stack){
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
