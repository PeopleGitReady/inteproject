import java.awt.*;

public abstract class Item {

    private String name;
    private Point point;

    public Item(Point point) {
        this.point = point;
    }

    public Item(String name, Point point) {
        this.name = name;
        this.point = point;
    }

    public Item() {

    }
}
