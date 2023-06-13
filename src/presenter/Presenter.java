package presenter;

import service.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addtoy(String str) {
        service.addt(str);
    }

    public void addstr(String str) {
        service.putlot(str);
    }

    public void lottery() {
        service.getLott();
    }

    public void showshop() {
        view.print(service.show());
    }
}
