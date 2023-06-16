package toys;

import java.io.Serializable;

public class Toys implements Serializable, Comparable<Toys> {
    private String name;
    private int id;
    private int fraq;

    public Toys(int id, String name, int fraq) {
        this.name = name;
        this.fraq = fraq;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNmae(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFraq(int fraq) {
        this.fraq = fraq;
    }

    public int getId() {
        return id;
    }

    public int getFraq() {
        return fraq;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str.append("id -> " + this.id);
        str.append("  название -> " + this.name);
        str.append("  частота выпадения -> " + this.fraq);
        return str.toString();
    }

    @Override
    public int compareTo(Toys t) {
        return this.name.compareTo(t.getName());
    }
}
