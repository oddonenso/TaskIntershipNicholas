import java.util.ArrayList;
import java.util.List;

public class CommandParsing {

    private String[] _args;
    private List<String> inputFile = new ArrayList<>();
    private String output = "";
    private String prefix = "";
    private boolean apendMode = false;
    private boolean fullstats = false;

    public CommandParsing(String[] args) {
      _args = args;
        parseArgs();
    }

    private void parseArgs() {
        for (int i=0; i<_args.length; i++) {
            switch (_args[i]) {
                case "-o":
                    output = _args[++i];
                    break;
                case "-p":
                    prefix = _args[++i];
                    break;
                case "-a":
                    apendMode = true;
                    break;
                case "-s":
                    fullstats = false;
                    break;
                case "-f":
                    fullstats = true;
                    break;
                default:
                    inputFile.add(_args[i]);
                    break;
            }
        }
    }
    public List<String> getInputFile() {
        return  inputFile;
    }
    public String getOutput() {
        return output;
    }

    public String getPrefix() {
        return prefix;
    }
    public boolean isAppendMode() {
        return apendMode;
    }

    public boolean isFullStats() {
        return fullstats;
    }
}
