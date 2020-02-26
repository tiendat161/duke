import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AccessHardDisk {

    String path = "./data/duke.txt";
    Scanner readFile;

    public AccessHardDisk(String path) {
        try {
            this.readFile = new Scanner(new File(this.path = path));
        } catch (FileNotFoundException error) {
            System.out.println(error);
            System.exit(0);
        }
    }
    public TaskList readTasksFromFile() throws DukeException {
        ArrayList<Task> data = new ArrayList<>();
        while (readFile.hasNextLine()) {
            String input = readFile.nextLine();
            String[] line = input.split("\\|");
            if (line[0].equals("T")) {
                data.add(new Todo(line[2]));
            } else if (line[0].equals("D")) {
                data.add(new Deadline(line[2], line[3]));
                System.out.println(line[2]);
            } else if (line[0].equals("E")) {
                data.add(new Event(line[2], line[3]));
            }
            if (line[1].equals("1")) {
                data.get(data.size()-1).markDone();
            }
        }
        return new TaskList(data);
    }
    public void saveFile(TaskList tasks) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(path));
        for (Task task : tasks.getTaskList()) {
            int binaryInx = (task.isDone()) ? 1 : 0;
            pw.println(task.getType() + "|" + binaryInx + "|" + task.getDescription() + "|" + task.getTime().toString());
        }
        pw.close();
    }
}
