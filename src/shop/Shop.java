package shop;

import toys.Toys;

public interface Shop extends Iterable<Toys> {
    void put(String str);

    Toys getqueue(String str);
}
