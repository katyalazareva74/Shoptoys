package service;

import java.util.Deque;

import toys.Toys;

public interface Service {
    void putlot(String str);

    void addt(String str);

    Deque<Toys> show();

    void getLott();
}
