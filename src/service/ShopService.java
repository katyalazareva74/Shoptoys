package service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import shop.Shop;
import shop.ShopToys;
import toys.Toys;

public class ShopService implements Service {
    private Deque<String> queue;
    private Deque<Toys> qu;
    private Shop shop;

    public ShopService() {
        this.queue = new ArrayDeque<String>();
        this.shop = new ShopToys();
        this.qu = new ArrayDeque<Toys>();
    }

    public ShopService(Deque<String> queue, ShopToys shop, Deque<Toys> qu) {
        this.queue = queue;
        this.shop = shop;
        this.qu = qu;
    }

    public void putlot(String str) {
        String[] s1 = str.split(" ");
        int n = Integer.parseInt(s1[2]);
        Random rand = new Random();
        int rnd = rand.nextInt(0, 2);
        for (int i = 0; i < n; i++) {
            rnd = rand.nextInt(0, 2);
            if (rnd == 0)
                this.queue.addFirst(str);
            else
                this.queue.addLast(str);
        }
        System.out.println(this.queue);
    }

    public void getLott() {
        Random rand = new Random();
        int rnd = rand.nextInt(0, 2);
        String n;
        if (rnd == 0)
            n = this.queue.pollFirst();
        else
            n = this.queue.pollLast();

        this.qu.add(shop.getqueue(n));
    }

    public Deque<Toys> show() {
        return this.qu;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.queue);
        return str.toString();
    }

    @Override
    public void addt(String str) {
        shop.put(str);
    }
}
