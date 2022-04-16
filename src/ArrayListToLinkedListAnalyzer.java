import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListToLinkedListAnalyzer {
    private static List<Integer> arrayList;
    private static List<Integer> linkedList;

    public static long compareByAdding100_000Elements() {
        LocalDateTime start = LocalDateTime.now();
        for(int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        LocalDateTime finish = LocalDateTime.now();
        long arrayListTime = ChronoUnit.MILLIS.between(start, finish);

        start = LocalDateTime.now();
        for(int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        finish = LocalDateTime.now();
        long linkedListTime = ChronoUnit.MILLIS.between(start, finish);

        System.out.println(arrayListTime + "        " + linkedListTime);
        return arrayListTime - linkedListTime;
    }

    // if index < 0, then 1000 elements will be added to the end
    public static long compareByAdding1000ElementsByIndex(int index) {
        LocalDateTime start = LocalDateTime.now();
        for(int i = 0; i < 1000; i++) {
            if(index < 0) {
                arrayList.add(i);
            } else {
                arrayList.add(index, i);
            }
        }
        LocalDateTime finish = LocalDateTime.now();
        long arrayListTime = ChronoUnit.MILLIS.between(start, finish);

        start = LocalDateTime.now();
        for(int i = 0; i < 1000; i++) {
            if(index < 0) {
                linkedList.add(i);
            } else {
                linkedList.add(index, i);
            }
        }
        finish = LocalDateTime.now();
        long linkedListTime = ChronoUnit.MILLIS.between(start, finish);
        System.out.println(arrayListTime + "        " + linkedListTime);
        return arrayListTime - linkedListTime;
    }

    // if index < 0, then 1000 elements will be updated in the end
    public static long compareByUpdating1000ElementsByIndex(int index) {
        LocalDateTime start = LocalDateTime.now();
        if(index < 0) {
            for(int i = arrayList.size() - 1; i >= arrayList.size() - 1 - 1000; i--) {
                arrayList.set(i, i);
            }
        } else {
            for(int i = 0; i < 1000; i++) {
                arrayList.set(index + i, i);
            }
        }
        LocalDateTime finish = LocalDateTime.now();
        long arrayListTime = ChronoUnit.MILLIS.between(start, finish);

        start = LocalDateTime.now();
        if(index < 0) {
            for(int i = linkedList.size() - 1; i >= linkedList.size() - 1 - 1000; i--) {
                linkedList.set(i, i);
            }
        } else {
            for(int i = 0; i < 1000; i++) {
                linkedList.set(index + i, i);
            }
        }
        finish = LocalDateTime.now();
        long linkedListTime = ChronoUnit.MILLIS.between(start, finish);
        System.out.println(arrayListTime + "        " + linkedListTime);
        return arrayListTime - linkedListTime;
    }

    // if index < 0, then 1000 elements will be deleted from the end
    public static long compareByDeleting1000ElementsByIndex(int index) {
        LocalDateTime start = LocalDateTime.now();
        for(int i = 0; i < 1000; i++) {
            if(index < 0) {
                arrayList.remove(arrayList.size() - 1);
            } else {
                arrayList.remove(index);
            }
        }
        LocalDateTime finish = LocalDateTime.now();
        long arrayListTime = ChronoUnit.MILLIS.between(start, finish);

        start = LocalDateTime.now();
        for(int i = 0; i < 1000; i++) {
            if(index < 0) {
                linkedList.remove(linkedList.size() - 1);
            } else {
                linkedList.remove(index);
            }
        }
        finish = LocalDateTime.now();
        long linkedListTime = ChronoUnit.MILLIS.between(start, finish);
        System.out.println(arrayListTime + "        " + linkedListTime);
        return arrayListTime - linkedListTime;
    }

    public static void creatreEmptyLists() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    public static void main(String[] args) {
        creatreEmptyLists();
        //1
        System.out.println("By adding 100 000 elements: " + compareByAdding100_000Elements());
        //2
        System.out.println("By adding 1000 elements to the begging: " + compareByAdding1000ElementsByIndex(0));
        System.out.println("By adding 1000 elements in the middle: " + compareByAdding1000ElementsByIndex(50499));
        System.out.println("By adding 1000 elements to the end: " + compareByAdding1000ElementsByIndex(-1));
        //3
        System.out.println("By updating 1000 elements in the begging: " + compareByUpdating1000ElementsByIndex(0));
        System.out.println("By updating 1000 elements in the middle: " + compareByUpdating1000ElementsByIndex(51499));
        System.out.println("By updating 1000 elements in the end: " + compareByUpdating1000ElementsByIndex(-1));
        //4
        System.out.println("By deleting 1000 elements from the begging: " + compareByDeleting1000ElementsByIndex(0));
        System.out.println("By deleting 1000 elements from the middle: " + compareByDeleting1000ElementsByIndex(49999));
        System.out.println("By deleting 1000 elements from the end: " + compareByDeleting1000ElementsByIndex(-1));
    }
}
