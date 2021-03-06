package duke.util;
import java.util.Scanner;

/**
 * A class to help handle all the User Interface.
 */
public class Ui {

    protected String line = "____________________________________________\n";
    protected Scanner sc = new Scanner(System.in);

    public Ui() {
    }

    /**
     * A method to print a line.
     * @return a line in string format.
     */
    public String showLine() {
        return (this.line);
    }

    /**
     * A method to print a welcome message.
     * @return in string format.
     */
    public String showWelcome() {
        return this.showLine()
                + ("Hello I'm Dat\n" + "What can I do for you?\n")
                + this.showLine();
    }

    /**
     * A method to print a goodbye message.
     * @return in string format.
     */
    public String showGoodbye() {
        String string = "GOODBYE! See you again!";
        return string;
    }

    /**
     * A method to print an error message.
     * @return in string format.
     */
    public String showError(String errorMessage) {
        return ("OOPS!!! I'm sorry, but there is an error: ")
                + (errorMessage);
    }
}