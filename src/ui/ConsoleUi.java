package ui;

import java.io.IOException;
import java.util.Deque;
import java.util.Scanner;

import presenter.Presenter;
import toys.Toys;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void start() throws ClassNotFoundException, IOException {
        System.out.println("Введите игрушку по формату:"
                + "\nid игрушки, название игрушки, количество игрушек, процент выпадения игрушки, в одну строку через пробел:");
        String str = scanner.nextLine();
        presenter.addtoy(str);
        presenter.addstr(str);
        presenter.lottery();
        presenter.showshop();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(Deque<Toys> queue) {
        for (Toys toy : queue) {
            System.out.println(toy);
        }
    }
}
