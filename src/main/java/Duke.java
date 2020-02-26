import duke.exception.DukeException;
import duke.task.TaskList;
import duke.util.AccessHardDisk;
import duke.util.Parser;
import duke.util.Ui;
import duke.command.*;

import java.io.IOException;


public class Duke {
    private TaskList tasks;
    private Ui ui;
    private AccessHardDisk storage;
    private Parser parser;

    Duke(String path) throws DukeException {
        storage = new AccessHardDisk(path);
        tasks = storage.readTasksFromFile();
        ui = new Ui();
        this.parser = new Parser(tasks);
    }

    public void run() {
        System.out.println(ui.showWelcome());
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                System.out.println(ui.showLine()); // show the divider line ("_______")
                Command c = parser.parse(fullCommand);
                c.execute(tasks, storage);
                isExit = c.isExit();
            } catch (DukeException | IOException e) {
                System.out.println(ui.showError(e.getMessage()));
            } finally {
                System.out.println(ui.showLine());
            }
        }
    }

    public static void main(String[] args) throws IOException, DukeException {
        Duke duke = new Duke("./data/duke.txt");
        duke.run();
    }
}
