import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList(AccessHardDisk storage) throws DukeException {
        tasks = storage.readTasksFromFile().getTaskList();
    }

    public void markDone(int n, AccessHardDisk storage) throws IOException {
        tasks.get(n-1).markDone();
        storage.saveFile(this);
        System.out.println("    Nice! I've marked this task as done: ");
        System.out.println("      " + tasks.get(n - 1));
    }

    public void delete(int n, AccessHardDisk storage) throws IOException {
        Task removedTask = tasks.remove(n-1);
        storage.saveFile(this);
        System.out.println("    Noted. I've removed this task: ");
        System.out.println("      " + removedTask);
    }

    public void addTask(Task task, AccessHardDisk storage) throws IOException {
        this.tasks.add(task);
        storage.saveFile(this);
        System.out.println("    Got it. I've added this task:");
        System.out.println("     "+ this.tasks.size() + ": " + task);
    }

    public Task checkTask(int n) {
        return tasks.get(n-1);
    }

    public int checkSize() {
        return tasks.size();
    }

    public void showTaskList() {
        int i = 1;
        for (Task task : this.tasks) {
            System.out.println("     " + i + ": " + task); i++;
        }
    }

    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }
}
