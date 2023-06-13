package ui;

import java.io.IOException;
import java.util.Deque;

import presenter.Presenter;
import toys.Toys;

public interface View {
    void start() throws ClassNotFoundException, IOException;

    void setPresenter(Presenter pr);

    void print(Deque<Toys> show);
}
