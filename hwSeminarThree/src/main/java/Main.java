import view.ConsoleView;
import view.IView;

public class Main {
    public static void main(String[] args) {
        IView view = new ConsoleView();
        view.run();
    }
}
