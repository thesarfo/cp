import java.util.Dictionary;
import java.util.Hashtable;

public class Practice{
    public static void main(String[] args) {
        Dictionary<Integer, String> dict = new Hashtable<>();

        dict.put(1, "hello");
        dict.put(2, "world");

        System.out.println("Value at key 1: " + dict.get(1));
        System.out.println("Value at key 2: " + dict.get(2));
    }
}
