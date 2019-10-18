import java.awt.*;

public abstract class Item {

    private String name;
    private Point point;

    public Item(String name, Point point) {
        this.name = name;
        this.point = point;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }

}
