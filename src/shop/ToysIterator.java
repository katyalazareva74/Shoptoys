package shop;

import java.util.Iterator;
import java.util.PriorityQueue;

import toys.Toys;

public class ToysIterator implements Iterator<Toys> {
    private int index;
    private PriorityQueue<Toys> shop;

    public ToysIterator(PriorityQueue<Toys> shop2) {
        this.shop=shop2;
    }

    @Override
    public boolean hasNext() {
        return index < shop.size();
    }

    @Override
    public Toys next() {
        return shop.poll();
    }
}
