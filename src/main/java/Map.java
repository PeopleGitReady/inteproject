import java.awt.*;
import java.util.ArrayList;

public class Map extends Rectangle {

    public Map(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    private ArrayList<Monster> monsters = new ArrayList<>();

    public void moveCharacter(Character c) {
        if (super.contains(c) && !c.getIsDead()) {
            switch (c.getDirection()) {
                case UP:
                    moveY(c, 1);
                    break;
                case DOWN:
                    moveY(c, -1);
                    break;
                case RIGHT:
                    moveX(c, 1);
                    break;
                case LEFT:
                    moveX(c, -1);
                    break;
            }
        }
    }


    private void moveY(Character c, int i) {
        Point newPos = new Point((int) c.getX(), (int) c.getY() + i);
        if (super.contains(newPos)) {
            c.setLocation(newPos);
        }
    }

    private void moveX(Character c, int i) {
        Point newPos = new Point((int) c.getX() + i, (int) c.getY());
        if (super.contains(newPos)) {
            c.setLocation(newPos);
        }
    }
}