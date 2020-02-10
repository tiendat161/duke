import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String line = "    ____________________________________________________________\n";
        System.out.println(line + "    Hello I'm Dat\n" + "    What can I do for you?\n" + line);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Task> data = new ArrayList<>();
        while (!input.equals("bye")) {
            System.out.print(line);
            String[] action = input.split(" ");
            if (input.equals("list")) {
                for (int i = 0; i <data.size(); i ++) {
                    System.out.println("    " + (i + 1) + ". " + data.get(i));
                }
            } else if (action[0].equals("done")) {
                int numOfTask = (int) Double.parseDouble(action[1]);
                data.get(numOfTask - 1).markDone();
                System.out.println("    Nice! I've marked this task as done: ");
                System.out.println("      " + data.get(numOfTask - 1));
            } else {
                String prefix = input.split(" ")[0];
                switch (prefix) {
                    case "deadline": {
                        System.out.println("    Got it. I've added this task:");
                        String[] newTask = input.split("/by");
                        data.add(new Deadline(newTask[0], newTask[1]));
                        break;
                    }
                    case "event": {
                        String[] newTask = input.split("/at");
                        data.add(new Event(newTask[0], newTask[1]));
                        break;
                    }
                    case "todo": {
                        String[] newTask = input.split("todo ");
                        data.add(new Todo(newTask[1]));
                        break;
                    }
                    default: {
                        data.add(new Task(input));
                    }
                }
                System.out.println(data.get(data.size() - 1));
                System.out.println("    Now you have " + data.size() + " tasks in the list.");
            }
            System.out.print(line);
            input = sc.nextLine();
        }
        System.out.println(line + "    Bye. Hope to see you again soon!\n" + line);
    }
}
