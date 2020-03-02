package duke.task;

import duke.exception.DukeException;
import duke.util.AccessHardDisk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Contains a list of tasks. It is a collection of current tasks.
 * It support a number of function with tasks, for example: add, markDone, delete a task.
 */
public class TaskList {
    protected ArrayList<Task> tasks;

    /**
     * Constructor for a new blank TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Constructor for a TaskList given an ArrayList of tasks.
     * @param tasks an ArrayList of Task that contains tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Constructor for a TaskList that read from a saved file.
     * @param storage a storage that access hard disk to get a saved task list.
     */
    public TaskList(AccessHardDisk storage) throws DukeException {
        tasks = storage.readTasksFromFile().getTaskList();
    }

    /**
     * Mark a task in the list as Done.
     * @param n         the index number of the task.
     * @param storage   storage that access hard disk to save any changes.
     */
    public String markDone(int n, AccessHardDisk storage) throws IOException {
        tasks.get(n - 1).markDone();
        storage.saveFile(this);
        return("Nice! I've marked this task as done:\n")
                + tasks.get(n - 1);
    }

    /**
     * Delete a task in the list.
     * @param n         the index number of the task.
     * @param storage   storage that access hard disk to save any changes.
     */
    public String delete(int n, AccessHardDisk storage) throws IOException {
        Task removedTask = tasks.remove(n - 1);
        storage.saveFile(this);
        return ("Noted. I've removed this task:\n")
                + removedTask;
    }

    /**
     * Add a task into the list.
     * @param task      the task that need to be added.
     * @param storage   storage that access hard disk to save any changes.
     */
    public String addTask(Task task, AccessHardDisk storage) throws IOException {
        this.tasks.add(task);
        storage.saveFile(this);
        return ("Got it. I've added this task:\n")
                + this.tasks.size() + ": " + task;
    }

    /**
     * Check the size of the list.
     * @return the size of the task in the form of an integer.
     */
    public int checkSize() {
        return tasks.size();
    }

    /**
     * Print all the task in the list in order.
     */
    public String showTaskList() {
        int i = 1;
        String string = "";
        for (Task task : this.tasks) {
            string += ("     " + i + ": " + task) + "\n";
            i++;
        }
        return string;
    }

    /**
     * Return the list of all the tasks.
     */
    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }

    /**
     * Print the list of all the tasks match the keyWord of FindCommand.
     */
    public String findTask(String keyWord) {
        keyWord = keyWord.trim().toLowerCase();
        int j = 1;
        boolean isFound = false;
        int count = 0;
        for (Task task : this.tasks) {
            if (task.description.trim().toLowerCase().contains(keyWord)) {
                isFound = true;
                count ++;
            }
        }
        String string = "";
        if (isFound) {
            string += ("Great, I have found " + count + " tasks that match your keyword: " + "\n");
            for (Task task : this.tasks) {
                if (task.description.trim().toLowerCase().contains(keyWord)) {
                    string += (" " + j + ": " + task + "\n");
                }
                j++;
            }
        } else {
            string += ("Sorry, I didn't find any results that match your keyword\n");
        }
        return string;
    }

    public String sort(Comparator<Task> comparator, AccessHardDisk storage) throws IOException {
        Collections.sort(this.tasks, comparator);
        storage.saveFile(this);
        return ("Got it. I've sort based on your request:") + "\n"
                + this.showTaskList();
    }

}
