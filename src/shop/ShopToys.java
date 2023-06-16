package shop;

import java.util.Iterator;
import java.util.PriorityQueue;

import toys.Toys;

public class ShopToys implements Shop {
    private int id;
    private PriorityQueue<Toys> shop;

    public ShopToys() {
        this.shop = new PriorityQueue<>();
    }

    public ShopToys(PriorityQueue<Toys> shop) {
        this.shop = shop;
    }

    public void put(String str) {
        String[] s1 = str.split(" ");
        int n = Integer.parseInt(s1[2]);
        int m = Integer.parseInt(s1[0]);
        for (int i = 0; i < n; i++) {
            Toys toy = new Toys(m, s1[1], n);
            toy.setId(id++);
            shop.add(toy);
        }
    }

    public Toys getqueue(String str) {
        PriorityQueue<Toys> queue1 = new PriorityQueue<>();
        String[] s1 = str.split(" ");
        int n = Integer.parseInt(s1[2]);
        int m = Integer.parseInt(s1[0]);
        Toys toyprize = new Toys(m, s1[1], n);
        int count = 0;
        for (Toys toy : this.shop) {
            if ((s1[1].equals(toy.getName())) && (count == 0)) {
                toyprize.setId(toy.getId());
                count++;
            } else {
                queue1.add(toy);
            }
        }
        this.shop.clear();
        this.shop.addAll(queue1);
        return toyprize;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.shop);
        return str.toString();
    }

    @Override
    public Iterator<Toys> iterator() {
        return new ToysIterator(this.shop);
    }
}
