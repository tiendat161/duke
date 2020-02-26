package duke.command;

import duke.task.*;
import duke.util.*;
import java.io.IOException;

public abstract class Command {
    protected boolean isExit = false;

    public boolean isExit() {
        return false;
    }

    public abstract void execute(TaskList tasks, AccessHardDisk storage) throws IOException;
}
