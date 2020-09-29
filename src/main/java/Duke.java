import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * initialize duke
     * @param filePath String. The path of the local data file.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        File f = new File("data");
        f.mkdir();
        try {
            tasks = new TaskList(Storage.load());
        } catch (FileNotFoundException e) {
            Ui.showLoadingError();
            tasks = new TaskList(new ArrayList<>());
        }
    }

    /**
     * run the program
     */
    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            Command c = Parser.parse(fullCommand);
            c.execute();
            isExit = c.isExit();
        }
        ui.goodbye();
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}