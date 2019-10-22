import java.awt.*;

public class Map extends Rectangle {
    public Map(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void handleMovement(Character c) {
        if (!super.contains(c)) {
            return;
        } else {
            switch (c.getDirection()) {
                case UP:
                    moveY(c, 1);
                    break;
                case DOWN:
                    c.moveY(-1);
                    break;
                case RIGHT:
                    c.moveX(1);
                    break;
                case LEFT:
                    c.moveX(-1);
                    break;
            }
        }
    }

    public void moveY(Character c, int i) {
        Point newPos = new Point((int) c.getX(), (int) c.getY() + i);
        if (!super.contains(newPos)) {
            return;
        } else {
            c.setLocation(newPos);
        }
    }
}