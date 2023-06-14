package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import savefile.OutInput;
import savefile.SaveLoad;
import shop.Shop;
import shop.ShopToys;
import toys.Toys;

public class ShopService implements Service {
    private Deque<String> queue;
    private Deque<Toys> qu;
    private Shop shop;
    private OutInput svloadf;

    public ShopService() {
        this.queue = new ArrayDeque<String>();
        this.shop = new ShopToys();
        this.qu = new ArrayDeque<Toys>();
        this.svloadf = new SaveLoad();
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

    public int number(String str) {
        String[] s1 = str.split(" ");
        int n = Integer.parseInt(s1[2]);
        int percent = Integer.parseInt(s1[3]);
        return n * 100 / percent;
    }

    public int check(String str, int k) {
        String[] s1 = str.split(" ");
        int n = Integer.parseInt(s1[2]);
        int percent = Integer.parseInt(s1[3]);
        int num = n * 100 / percent;
        return (num == k) ? num : 0;
    }

    public int check1(String str, int k) {
        String[] s1 = str.split(" ");
        int percent = Integer.parseInt(s1[3]);
        percent = percent + k;
        System.out.println(percent);
        return (percent == 100) ? 0 : percent;
    }
    public void savequeue() throws FileNotFoundException, IOException {
        svloadf.savefile(this.qu);
    } 
    public void loadqueue() throws FileNotFoundException, ClassNotFoundException, IOException {
        Object loadtoy = new Object();
        loadtoy=svloadf.loadfile();
        System.out.println(loadtoy);
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
