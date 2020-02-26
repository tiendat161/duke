package duke.util;

import java.util.Scanner;

public class Ui {

    protected String line = "    ____________________________________________________________\n";
    protected Scanner sc = new Scanner(System.in);

    public Ui() {
    }

    public String showLine() {
        return(this.line);
    }

    public String showWelcome() {
        return this.showLine() +
            ("    Hello I'm Dat\n" + "    What can I do for you?\n" ) +
            this.showLine();
    }

    public void showGoodbye() {
        this.showLine();
        System.out.println("    Goodbye, see you again!\n");
        this.showLine();
    }

    public String showError(String errorMessage) {
        return
                this.showLine() +
                ("☹ OOPS!!! I'm sorry, but there is an error :-(") +
                (errorMessage) +
                this.showLine();
    }

    public String readCommand() {
        return this.sc.nextLine();
    }

    public String readCommand(String a) {
        return a;
    }
}
