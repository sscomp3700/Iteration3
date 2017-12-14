import java.util.*;

public class Memory {
    private static Memory instance;

    Map<String, Integer> values = new HashMap<String, Integer>();

    public static Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    public void setValue(String variable, Integer value) {
        values.put(variable, value);
    }

    public int getValue(String variable) {
        return values.get(variable);
    }
}
