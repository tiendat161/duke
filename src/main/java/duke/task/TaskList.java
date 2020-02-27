package duke.task;

import duke.exception.DukeException;
import duke.util.AccessHardDisk;

import java.io.IOException;
import java.util.ArrayList;

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
    public void markDone(int n, AccessHardDisk storage) throws IOException {
        tasks.get(n - 1).markDone();
        storage.saveFile(this);
        System.out.println("    Nice! I've marked this task as done: ");
        System.out.println("      " + tasks.get(n - 1));
    }

    /**
     * Delete a task in the list.
     * @param n         the index number of the task.
     * @param storage   storage that access hard disk to save any changes.
     */
    public void delete(int n, AccessHardDisk storage) throws IOException {
        Task removedTask = tasks.remove(n - 1);
        storage.saveFile(this);
        System.out.println("    Noted. I've removed this task: ");
        System.out.println("      " + removedTask);
    }

    /**
     * Add a task into the list.
     * @param task      the task that need to be added.
     * @param storage   storage that access hard disk to save any changes.
     */
    public void addTask(Task task, AccessHardDisk storage) throws IOException {
        this.tasks.add(task);
        storage.saveFile(this);
        System.out.println("    Got it. I've added this task:");
        System.out.println("     " + this.tasks.size() + ": " + task);
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
    public void showTaskList() {
        int i = 1;
        for (Task task : this.tasks) {
            System.out.println("     " + i + ": " + task);
            i++;
        }
    }

    /**
     * Return the list of all the tasks.
     */
    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }
}
