package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.util.AccessHardDisk;

import java.io.IOException;

public class AddCommand extends Command {

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }
    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        tasks.addTask(task, storage);
    }
}
