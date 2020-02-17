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
    public AccessHardDisk() {
        try {
            this.readFile = new Scanner(new File(path));
        } catch (FileNotFoundException error) {
            System.out.println(error);
            System.exit(0);
        }
    }
    public ArrayList<Task> readTasksFromFile() {
        ArrayList<Task> data = new ArrayList<>();
        while (readFile.hasNextLine()) {
            String input = readFile.nextLine();
            String[] line = input.split("\\|");
            if (line[0].equals("T")) {
                data.add(new Todo(line[2]));
            } else if (line[0].equals("D")) {
                LocalDate date = LocalDate.parse(line[3]);
                data.add(new Deadline(line[2], date));
                System.out.println(line[2]);
            } else if (line[0].equals("E")) {
                LocalDate date = LocalDate.parse(line[3]);
                data.add(new Event(line[2], date));
            }
            if (line[1].equals("1")) {
                data.get(data.size()-1).markDone();
            }
        }
        return data;
    }
    public void saveFile(ArrayList<Task> data) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(path));
        for (Task task : data) {
            int binaryInx = (task.isDone()) ? 1 : 0;
            pw.println(task.getType() + "|" + binaryInx + "|" + task.getDescription() + "|" + task.getTime().toString());
        }
        pw.close();
    }
}
