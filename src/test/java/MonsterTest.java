import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class    MonsterTest {


    // Test klass för Monster liv

    // Test klass för drops av item
    @Test
    void checkIfItemdropIsNull() {
        Item item = new Item();
        testMonster.dropItem(item);
        // Ska Monstern ha en pre Inventory som den droppar ifrån eller är det randomized?
        assertTrue(testMonster.drop());

    }



    // Test klass för Monster attack

    // Monster Typ

    // Testklass för gå

    // Gå i X-led

    // Gå i Y-led

}