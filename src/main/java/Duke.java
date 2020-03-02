import duke.command.Command;
import duke.exception.DukeException;
import duke.exception.EmptyArgumentException;
import duke.task.TaskList;
import duke.util.AccessHardDisk;
import duke.util.Parser;
import duke.util.Ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

/** Duke class. The main class for project Duke
 */
public class Duke {

    private TaskList tasks;
    private Ui ui;
    private AccessHardDisk storage;
    private Parser parser;
    boolean isExit = false;

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /** Constructor for a Duke object.
     */
    public Duke() throws DukeException {
        storage = new AccessHardDisk("./data/duke.txt");
        tasks = storage.readTasksFromFile();
        ui = new Ui();
        this.parser = new Parser(tasks);
    }

    /** Constructor for a Duke object.
     * @param path      the path to read and save from a .txt file
     */
    public Duke(String path) throws DukeException {
        storage = new AccessHardDisk(path);
        tasks = storage.readTasksFromFile();
        ui = new Ui();
        this.parser = new Parser(tasks);
    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        return run(input);
    }

    /** Method to run a Duke Programme.
     */
    public String run(String fullCommand) {
        try {
            Command c = parser.parse(fullCommand);
            if (c.isExit()) {
                this.isExit = true;
            }
            return (c.execute(tasks, storage));
        } catch (IOException | DukeException e) {
            return (ui.showError(e.getMessage()));
        }
    }

    /** Method to run a Duke Programme.
     */
    public boolean isExit() {
        return isExit;
    }

    /** Method to get a welcome message.
     */
    public String getWelcomeMessage() {
        return this.ui.showWelcome();
    }

    /** Method to get a goodbye message.
     */
    public String getGoodbyeMessage() {
        return this.ui.showGoodbye();
    }

    /** Method to get a remind message.
     */
    public String getReminder() {
        String message = "";
        message = "Currently you have "
                + String.valueOf(this.tasks.checkSize())
                + " tasks in the list" + "\n"
                + this.tasks.showTaskList();
        return message;
    }

}