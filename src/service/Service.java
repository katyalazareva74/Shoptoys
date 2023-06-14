package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Deque;

import toys.Toys;

public interface Service {
    void putlot(String str);

    void addt(String str);

    int check(String str, int k);

    int check1(String str, int k);

    int number(String str);

    Deque<Toys> show();

    void savequeue() throws FileNotFoundException, IOException;

    void loadqueue() throws FileNotFoundException, ClassNotFoundException, IOException;

    void getLott();
}
