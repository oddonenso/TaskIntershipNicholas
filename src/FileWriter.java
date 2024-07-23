import java.io.*;
import java.util.List;

public class FileWriter {
    private CommandParsing parser;

    public FileWriter(CommandParsing parser) {
        this.parser = parser;
    }

    public void writeOutput(DataClassifier classifier) {
        writeToFile(parser.getOutput() + parser.getPrefix() + "integers.txt", classifier.getIntegers());
        writeToFile(parser.getOutput() + parser.getPrefix() + "floats.txt", classifier.getFloats());
        writeToFile(parser.getOutput() + parser.getPrefix() + "strings.txt", classifier.getStrings());
    }

    private <T> void writeToFile(String filePath, List<T> data) {
        if (data.isEmpty()) {
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, parser.isAppendMode()), "UTF-8"))) {
            for (T item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + filePath);
            e.printStackTrace();
        }
    }
}
