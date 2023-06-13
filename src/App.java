import java.util.ArrayDeque;
import java.util.Deque;

import service.ShopService;
import shop.Shop;
import shop.ShopToys;
import toys.Toys;

public class App {
    public static void main(String[] args) throws Exception {
        Shop sh1 = new ShopToys();
        ShopService qq = new ShopService();
        String s, g, t;
        Deque<String> qstr = new ArrayDeque<String>();
        String str1 = "0 car 2";
        String str2 = "1 boat 2";
        String str3 = "2 doll 6";
        qstr.add(str1);
        qstr.add(str2);
        qstr.add(str3);
        sh1.put(str3);
        qq.putlot(str3);
        sh1.put(str1);
        qq.putlot(str1);
        sh1.put(str2);
        qq.putlot(str2);
        System.out.println(sh1);
        System.out.println(qq);
        s = qq.getLott();
        g = qq.getLott();
        t = qq.getLott();
        System.out.println(s);
        System.out.println(g);
        System.out.println(t);

        Deque<Toys> qu = new ArrayDeque<Toys>();
        qu.add(sh1.getqueue(s));
        qu.add(sh1.getqueue(g));
        qu.add(sh1.getqueue(t));
        System.out.println(qu);
    }
}
