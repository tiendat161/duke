public class Ui {
    String line = "    ____________________________________________________________\n";

    public Ui() {
    }

    public void showLine() {
        System.out.println(this.line);
    }

    public void showWelcome() {
        showLine();
        System.out.println("    Hello I'm Dat\n" + "    What can I do for you?\n");
        showLine();
    }

    public void showBye() {
        showLine();
        System.out.println("    Bye. Hope to see you again soon!\n");
        showLine();
    }

    public void showLoadingError() {
        System.out.println("404-ERROR");
    }
}
