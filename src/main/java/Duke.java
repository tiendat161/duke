import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String line = "    ____________________________________________________________\n";
        System.out.println(line + "    Hello I'm Dat\n" + "    What can I do for you?\n" + line);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] data = new String[100];
        int a = 0;
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.print(line);
                for (int i = 1; i <= a; i ++) {
                    System.out.println("    " + i + ". " + data[i]);
                }
                System.out.print(line);
            } else {
                a++;
                data[a] = input;
                System.out.println(line + "    added: " + input + "\n" + line);
            }
            input = sc.nextLine();
        }
        System.out.println(line + "    Bye. Hope to see you again soon!\n" + line);
    }
}
