package example.Main.message;

import java.util.Arrays;
import java.util.HashMap;

public class TestBody {

    public int[] nums;
    public HashMap<String, Integer> map = new HashMap<>();

    @Override
    public String toString() {

        return "TestBody{" +
                "nums=" + Arrays.toString(nums) +
                ", map=" + map +
                '}';
    }
}
