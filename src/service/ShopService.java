package service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class ShopService implements Service {
    private Deque<String> queue;


    public ShopService() {
         this.queue= new ArrayDeque<String>();
    } 
    public ShopService(Deque<String> queue) {
        this.queue = queue;
     }
     public void putlot(String str) {
        String[] s1 = str.split(" ");
        int n = Integer.parseInt(s1[2]);
        Random rand = new Random();
        int rnd=rand.nextInt(0, 2);
        for (int i = 0; i < n; i++) {
            rnd = rand.nextInt(0, 2);
            if(rnd == 0)
                this.queue.addFirst(str); 
            else
                this.queue.addLast(str); 
        }
    }
    public String getLott() {
        Random rand = new Random();
        int rnd=rand.nextInt(0, 2);
        String n;
            if(rnd == 0)
                n = this.queue.pollFirst(); 
            else
                n = this.queue.pollLast(); 
        return n;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.queue);
        return str.toString();
    }
}
