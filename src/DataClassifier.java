import java.util.*;

public class DataClassifier {
    private List<Integer> integers = new ArrayList<>();
    private List<Double> floats = new ArrayList<>();
    private List<String> strings = new ArrayList<>();

    public void classify(String line, StatisticsCollector collector) {
        try {
            Integer integer = Integer.parseInt(line);
            integers.add(integer);
            collector.addInteger(integer);
        } catch (NumberFormatException e1) {
            try {
                Double floating = Double.parseDouble(line);
                floats.add(floating);
                collector.addFloat(floating);
            } catch (NumberFormatException e2) {
                strings.add(line);
                collector.addString(line);
            }
        }
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public List<Double> getFloats() {
        return floats;
    }

    public List<String> getStrings() {
        return strings;
    }
}
