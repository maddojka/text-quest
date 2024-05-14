package textQuest;

public class SaveGameCommand extends Command {


    public SaveGameCommand(String code) {
        super(code);

    }

    @Override
    public void execute(Menu menu) {
        menu.saveGame();
    }

}
