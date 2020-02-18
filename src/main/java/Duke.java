import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Duke {

    private Ui ui;
    private AccessHardDisk storage;
    ArrayList<Task> data;

    public Duke(String filePath) throws DukeException {
        ui = new Ui();
        storage = new AccessHardDisk(filePath);
        data = storage.readTasksFromFile();
    }
    public void run() throws IOException, DukeException {
        ui.showWelcome();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            ui.showLine();
            String[] action = input.split(" ");
            if (input.equals("list")) {
                for (int i = 0; i <data.size(); i ++) {
                    System.out.println("    " + (i + 1) + ". " + data.get(i));
                }
            } else if (action[0].equals("done")) {
                int numOfTask = (int) Double.parseDouble(action[1]);
                data.get(numOfTask - 1).markDone();
                storage.saveFile(data);
                System.out.println("    Nice! I've marked this task as done: ");
                System.out.println("      " + data.get(numOfTask - 1));
            } else if (action[0].equals("delete")) {
                int numOfTask = (int) Double.parseDouble(action[1]);
                System.out.println("    Noted. I've removed this task: ");
                System.out.println(data.get(numOfTask - 1));
                data.remove(numOfTask - 1);
                storage.saveFile(data);
                System.out.println("    Now you have " + data.size() + " tasks in the list.");
            } else {
                String prefix = input.split(" ")[0];
                switch (prefix) {
                    case "deadline": {
                        System.out.println("    Got it. I've added this task:");
                        String[] newTask = input.split("/by");
                        String time = newTask[1].trim();
                        String command = newTask[0].substring("deadline".length());
                        if (newTask[1] == null) {
                            throw new EmptyArgumentException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        } else {
                            LocalDate date = LocalDate.parse(time);
                            data.add(new Deadline(command.trim(), date));
                            storage.saveFile(data);
                        }
                        break;
                    }
                    case "event": {
                        try {
                            String[] newTask = input.split("/at");
                            String time = newTask[1].trim();
                            String command = newTask[0].substring("event".length());
                            LocalDate date = LocalDate.parse(time);
                            data.add(new Event(command.trim(), date));
                            storage.saveFile(data);
                        } catch(NoSuchElementException m) {
                            System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                        }
                        break;
                    }
                    case "todo": {
                        String[] newTask = input.split("todo");
                        if (newTask[1] == null) {
                            throw new EmptyArgumentException("☹ OOPS!!! The description of a todo cannot be empty.");
                        } else {
                            data.add(new Todo(newTask[1].trim()));
                            storage.saveFile(data);
                        }
                        break;
                    }
                    default: {
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                }
                System.out.println(data.get(data.size() - 1));
                System.out.println("    Now you have " + data.size() + " tasks in the list.");
            }
            ui.showLine();
            input = sc.nextLine();
        }
        ui.showBye();
    }

    public static void main(String[] args) throws DukeException, IOException {
        new Duke("data/duke.txt").run();
    }
}
