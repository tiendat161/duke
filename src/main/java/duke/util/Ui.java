package duke.util;

import java.util.Scanner;

/**
 * A class to help handle all the User Interface.
 */
public class Ui {

    protected String line = "    ____________________________________________________________\n";
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
                + ("    Hello I'm Dat\n" + "    What can I do for you?\n")
                + this.showLine();
    }

    /**
     * A method to print a goodbye message.
     */
    public void showGoodbye() {
        this.showLine();
        System.out.println("    Goodbye, see you again!\n");
        this.showLine();
    }

    /**
     * A method to print an error message.
     * @return in string format.
     */
    public String showError(String errorMessage) {
        return
                this.showLine()
                        + ("☹ OOPS!!! I'm sorry, but there is an error :-(")
                        + (errorMessage)
                        + this.showLine();
    }

    /**
     * A method to read the next command from user.
     * @return in string format the command from user.
     */
    public String readCommand() {
        return this.sc.nextLine();
    }

    /**
     * A method to read a given command.
     * @param a     a specific string of command.
     * @return      in string format the command from user.
     */
    public String readCommand(String a) {
        return a;
    }
}
