package be.intecbrussel.sellers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    @Test
    @DisplayName("Stock - all-args constructor")
    void shouldReturnNotEqualsWhenCreatingInstanceWithConstructor() {
        Stock stock = new Stock(1, 1, 1, 1);
        assertNotEquals(null, stock);
    }

    @Test
    @DisplayName("Stock - getters & setters")
    void shouldReturnEqualsAllWhenCallingAllGettersAndSetters() {
        Stock stock = new Stock(0, 0, 0, 0);

        stock.setCones(1);
        stock.setIceRockets(1);
        stock.setBalls(1);
        stock.setMagni(1);

        assertAll(
                () -> assertEquals(1, stock.getIceRockets()),
                () -> assertEquals(1, stock.getBalls()),
                () -> assertEquals(1, stock.getMagni()),
                () -> assertEquals(1, stock.getCones())
        );
    }
}