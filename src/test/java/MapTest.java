import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map map = new Map(0, 0, 100, 100);

    @Test
    void characterAddedToMap() {
        Player p = new Player("Frida");
        map.add(p);
        assertTrue(map.contains(p));
    }

    // check drops
    // check terrain


}
