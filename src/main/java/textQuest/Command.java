package textQuest;


abstract public class Command {
    private String code;

    public Command(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    abstract void execute(Menu menu);
}
