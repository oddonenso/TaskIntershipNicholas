import java.util.*;

public class StatisticsCollector {
    private int integerCount = 0;
    private int floatCount = 0;
    private int stringCount = 0;

    private Integer minInteger = null;
    private Integer maxInteger = null;
    private Double sumInteger = 0.0;

    private Double minFloat = null;
    private Double maxFloat = null;
    private Double sumFloat = 0.0;

    private Integer minLengthString = null;
    private Integer maxLengthString = null;

    public void addInteger(int value) {
        integerCount++;
        sumInteger += value;
        if (minInteger == null || value < minInteger) {
            minInteger = value;
        }
        if (maxInteger == null || value > maxInteger) {
            maxInteger = value;
        }
    }

    public void addFloat(double value) {
        floatCount++;
        sumFloat += value;
        if (minFloat == null || value < minFloat) {
            minFloat = value;
        }
        if (maxFloat == null || value > maxFloat) {
            maxFloat = value;
        }
    }

    public void addString(String value) {
        stringCount++;
        int length = value.length();
        if (minLengthString == null || length < minLengthString) {
            minLengthString = length;
        }
        if (maxLengthString == null || length > maxLengthString) {
            maxLengthString = length;
        }
    }

    public void printStatic(boolean fullStats) {
        System.out.println("Целые числа: " + integerCount);
        if (fullStats && integerCount > 0) {
            System.out.println("  Минимум: " + minInteger);
            System.out.println("  Максимум: " + maxInteger);
            System.out.println("  Сумма: " + sumInteger);
            System.out.println("  Среднее: " + (sumInteger / integerCount));
        }

        System.out.println("Дробные числа: " + floatCount);
        if (fullStats && floatCount > 0) {
            System.out.println("  Минимум: " + minFloat);
            System.out.println("  Максимум: " + maxFloat);
            System.out.println("  Сумма: " + sumFloat);
            System.out.println("  Среднее: " + (sumFloat / floatCount));
        }

        System.out.println("Строки: " + stringCount);
        if (fullStats && stringCount > 0) {
            System.out.println("  Минимальная длина: " + minLengthString);
            System.out.println("  Максимальная длина: " + maxLengthString);
        }
    }
}
