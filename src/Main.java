public class Main {
    public static void main(String[] args) {
        CommandParsing parser = new CommandParsing(args);
        FileProcessor processor = new FileProcessor(parser);
        processor.processFiles();
    }
}
