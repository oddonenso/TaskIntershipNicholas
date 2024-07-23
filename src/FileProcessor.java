import java.io.*;
import java.util.*;

public class FileProcessor {
    private CommandParsing parser;

    public FileProcessor(CommandParsing parser) {
        this.parser = parser;
    }

    public void processFiles() {
        DataClassifier classifier = new DataClassifier();
        StatisticsCollector collector = new StatisticsCollector();

        for (String filePath : parser.getInputFile()) {
            File file = new File(filePath);
            if (!file.exists()) {
                file = new File("src/" + filePath);
            }

            if (!file.exists()) {
                System.err.println("Ошибка при чтении файла: " + filePath);
                continue;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    classifier.classify(line, collector);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + filePath);
                e.printStackTrace();
            }
        }

        FileWriter fileWriter = new FileWriter(parser);
        fileWriter.writeOutput(classifier);
        collector.printStatic(parser.isFullStats());
    }
}
