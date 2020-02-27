package duke.util;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.Task;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to help access hard disk to read from file and write to file.
 */
public class AccessHardDisk {

    String path = "./data/duke.txt";
    Scanner readFile;

    /**
     * Constructor of an AccessHardDisk object.
     * Given a path to an .txt file, the programme try to connect to that path.
     * @param path the path of the .txt file.
     */
    public AccessHardDisk(String path) {
        try {
            this.readFile = new Scanner(new File(this.path = path));
        } catch (FileNotFoundException error) {
            System.out.println(error);
            System.exit(0);
        }
    }

    /**
     * Read a file to get the saved list of tasks.
     * @return a TaskList that have all the saved tasks.
     */
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
                data.get(data.size() - 1).markDone();
            }
        }
        return new TaskList(data);
    }

    /**
     * Save all the tasks to a file.
     */
    public void saveFile(TaskList tasks) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(path));
        for (Task task : tasks.getTaskList()) {
            int binaryInx = (task.isDone()) ? 1 : 0;
            pw.println(task.getType()
                    + "|" + binaryInx + "|" + task.getDescription()
                    + "|" + task.getTime().toString());
        }
        pw.close();
    }
}
