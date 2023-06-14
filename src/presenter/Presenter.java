package presenter;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    public int checks(String str, int n) {
        return service.check(str, n);
    }

    public int checksp(String str, int n) {
        return service.check1(str, n);
    }

    public int tnumber(String str) {
        return service.number(str);
    }

    public void lottery() {
        service.getLott();
    }

    public void showshop() {
        view.print(service.show());
    }

    public void savef() throws FileNotFoundException, IOException {
        service.savequeue();
    }

    public void loadf() throws FileNotFoundException, IOException, ClassNotFoundException {
        service.loadqueue();
    }
}
