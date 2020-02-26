package duke.util;

import java.util.Scanner;

public class Ui {

    protected String line = "    ____________________________________________________________\n";
    protected Scanner sc = new Scanner(System.in);

    public Ui() {
    }

    public void showLine() {
        System.out.println(this.line);
    }

    public void showWelcome() {
        this.showLine();
        System.out.println("    Hello I'm Dat\n" + "    What can I do for you?\n" );
        this.showLine();
    }

    public void showGoodbye() {
        this.showLine();
        System.out.println("    Goodbye, see you again!\n");
        this.showLine();
    }

    public void showError(String errorMessage) {
        this.showLine();
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        System.out.println(errorMessage);
        this.showLine();
    }

    public String readCommand() {
        return this.sc.nextLine();
    }
}
