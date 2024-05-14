package textQuest;

public class ReturnGameCommand extends Command {

    public ReturnGameCommand(String code) {
        super(code);
    }

    @Override
    public void execute(Menu menu) {
        menu.returnGame();
    }
}
