import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// An iterator is an interface to traverse the elements of a collection (like lists, sets, and maps) sequentially.
// iterators provide a way to traverse through a collection of elements without exposing the underlying implementation of the collection.
// The primary methods of the Iterator interface are hasNext() and next().

public class IteratorExample{
    public static void main(String[] args){
        List<String> myList = Arrays.asList("apple", "banana", "orange");
    Iterator<String> iterator = myList.iterator();

while (iterator.hasNext()) {
    String element = iterator.next();
    System.out.println(element);
    }
}
}