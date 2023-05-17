package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {
    @Test
    @DisplayName("Pricelist - no-args constructor")
    void shouldReturnNotEqualsWhenCreatingInstanceWithNoArgsConstructor() {
        PriceList priceList = new PriceList();
        assertNotEquals(priceList, null);
    }

    @Test
    @DisplayName("Pricelist - all-args constructor")
    void shouldReturnNotEqualsWhenCreatingInstanceWithAllArgsConstructor() {
        PriceList priceList = new PriceList(1, 1, 1);
        assertNotEquals(priceList, null);
    }

    @Test
    @DisplayName("Pricelist - getters & setters")
    void shouldReturnEqualsAllWhenCallingAllGettersAndSetters() {
        PriceList priceList = new PriceList();

        priceList.setBallPrice(1);
        priceList.setMagnumStandardPrice(1);
        priceList.setRocketPrice(1);

        assertAll(
                () -> assertEquals(1, priceList.getRocketPrice()),
                () -> assertEquals(1.5, priceList.getMagnumPrice(Magnum.MagnumType.ROMANTICSTRAWBERRIES)),
                () -> assertEquals(1.5, priceList.getMagnumPrice(Magnum.MagnumType.ALPINENUTS)),
                () -> assertEquals(1.1, priceList.getMagnumPrice(Magnum.MagnumType.MILKCHOCOLATE)),
                () -> assertEquals(1.1, priceList.getMagnumPrice(Magnum.MagnumType.WHITECHOCOLATE)),
                () -> assertEquals(1.1, priceList.getMagnumPrice(Magnum.MagnumType.BLACKCHOCOLATE)),
                () -> assertEquals(1, priceList.getBallPrice())
        );
    }

}