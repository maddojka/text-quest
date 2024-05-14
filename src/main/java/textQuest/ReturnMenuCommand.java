package textQuest;

public class ReturnMenuCommand extends Command {

    public ReturnMenuCommand(String code) {
        super(code);
    }

    @Override
    public void execute(Menu menu) {
        menu.returnMenu();
    }
}
