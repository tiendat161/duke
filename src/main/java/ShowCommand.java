public class ShowCommand extends Command {

    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) {
        tasks.showTaskList();
    }
}
