public class UnknownCommand extends Command{

    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) {
        System.out.println("Unknown command, please try again");
    }
}
