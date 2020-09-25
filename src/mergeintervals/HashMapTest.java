package mergeintervals;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(10, 0.5f);
        hashMap.put("test", "test");
        System.out.println(hashMap.size());
    }
}
