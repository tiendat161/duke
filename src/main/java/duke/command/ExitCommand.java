import java.io.IOException;

public class ExitCommand extends Command {

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) throws IOException {
    }
}
