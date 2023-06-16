import presenter.Presenter;
import service.Service;
import service.ShopService;
import ui.ConsoleUi;
import ui.View;

public class App {
    public static void main(String[] args) throws Exception {
        View view = new ConsoleUi();
        Service service = new ShopService();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
