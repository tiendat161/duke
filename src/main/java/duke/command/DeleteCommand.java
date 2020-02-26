package duke.command;

import duke.task.*;
import duke.util.*;
import java.io.IOException;

public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        tasks.delete(index, storage);
    }
}
