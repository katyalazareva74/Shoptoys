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
        int number = 0, get = 1, proc = 0;
        boolean loop = true;
        String str = "";
        System.out.println("Результаты предыдущего розыгрыша");
        presenter.loadf();
        while (loop) {
            System.out.println("Введите игрушку по формату:"
                    + "\nid игрушки, название игрушки, количество игрушек, процент выпадения игрушки(без знака %),"
                    + "\nв одну строку через пробел:");
            str = scanner.nextLine();
            if (number == 0)
                number = presenter.tnumber(str);
            number = presenter.checks(str, number);
            if (number == 0) {
                System.out.println("Что-то пошло не так! Попробуйте еще раз!");
                System.exit(0);
            }
            proc = presenter.checksp(str, proc);
            System.out.println(proc);
            if (proc > 100) {
                System.out.println("Что-то пошло не так! Попробуйте еще раз!");
                System.exit(0);
            }
            System.out.println(number);
            if ((number != 0) && (proc == 0)) {
                loop = false;
            }
            System.out.println(loop);
            presenter.addtoy(str);
            presenter.addstr(str);
        }
        while (!loop) {
            System.out.println("Сколько игрушек участвует в лотерее?");
            get = scanner.nextInt();
            if (get <= number)
                loop = true;
        }
        while (get != 0) {
            presenter.lottery();
            get--;
        }
        presenter.showshop();
        presenter.savef();
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
