import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String line = "    ____________________________________________________________\n";
        System.out.println(line + "    Hello I'm Dat\n" + "    What can I do for you?\n" + line);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Task[] data = new Task[100];
        int a = 0;
        while (!input.equals("bye")) {
            System.out.print(line);
            String[] action = input.split(" ");
            if (input.equals("list")) {
                for (int i = 1; i <= a; i ++) {
                    System.out.println("    " + i + ". " + data[i]);
                }
            } else if (action[0].equals("done")) {
                int numOfTask = (int) Double.parseDouble(action[1]);
                data[numOfTask].markDone();
                System.out.println("    Nice! I've marked this task as done: ");
                System.out.println("      " + data[numOfTask]);
            } else {
                a++;
                data[a] = new Task(input);
                System.out.println("    added: " + data[a] + "\n");
            }
            System.out.print(line);
            input = sc.nextLine();
        }
        System.out.println(line + "    Bye. Hope to see you again soon!\n" + line);
    }
}
