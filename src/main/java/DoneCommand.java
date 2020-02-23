import java.io.IOException;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        tasks.markDone(index, storage);
    }
}
