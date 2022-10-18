import java.util.*;

public class LinkedListExe {

    LinkedHashSet<Integer> linkedHashSet;

    LinkedListExe(){
        linkedHashSet = new LinkedHashSet<>();
        storeNumLinkedList();
        System.out.println("Enter a command(sort, shuffle, reserve) : ");
        Scanner scanner = new Scanner(System.in);
        String comm = scanner.next();
        System.out.println("\nResult: ");
        print(command(linkedHashSet, comm));
    }

    void storeNumLinkedList(){
        Scanner scanner = new Scanner(System.in);
        int count;
        System.out.print("Enter length of list: ");
        count = scanner.nextInt();
        System.out.println("Enter integer list: ");
        int i = 0;
        while( i <= count){
            linkedHashSet.add(scanner.nextInt());
            i++;
        };
    }

    LinkedHashSet<Integer> command(LinkedHashSet<Integer> linkedHashSet, String command){
        ArrayList<Integer> arrayList = new ArrayList<>(linkedHashSet);

        if(command.equals("sort")){
            Collections.sort(arrayList);
        }else if(command.equals("shuffle")){
            Collections.shuffle(arrayList);
        }else if(command.equals("reverse")){
            Collections.sort(arrayList, Collections.reverseOrder());
        }

        return new LinkedHashSet<>(arrayList);
    }

    void print(LinkedHashSet<Integer> linkedHashSet){
        Iterator<Integer> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        new LinkedListExe();
    }
}
