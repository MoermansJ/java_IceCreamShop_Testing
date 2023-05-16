package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamCarTest {
    //properties
    IceCreamCar iceCreamCar;


    //pre-testing
    @BeforeEach
    void setUp() {
        iceCreamCar = new IceCreamCar(new PriceList(1, 1, 1), new Stock(1, 1, 1, 1));
    }


    //testing methods
    @Test
    @DisplayName("IceCreamCar - orderCone() with stock")
    void shouldReturnEqualsWhenOrderingConeWithOneScoopOfVanilla() {
        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        Cone result = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        assertEquals(cone.hashCode(), result.hashCode());
    }

    @Test
    @DisplayName("IceCreamCar - orderIceRocket() with stock")
    void shouldReturnNotEqualsWhenOrderingIceRocket() {
        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        assertNotEquals(iceRocket, null);
    }

    @Test
    @DisplayName("IceCreamCar - orderMagnum() with stock")
    void shouldReturnNotEqualsWhenOrderingMagnum() {
        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);

        assertNotEquals(magnum, null);
    }

    @Test
    @DisplayName("IceCreamCar - orderMagnum() without stock")
    void shouldReturnEqualsWhenOrderingMagnumWithoutStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 0, 0));
        Magnum magnum = iceCreamCarNoStock.orderMagnum(Magnum.MagnumType.ALPINENUTS);

        assertEquals(magnum, null);
    }

    @Test
    @DisplayName("IceCreamCar - orderCone() without stock")
    void shouldReturnEqualsWhenOrderingConeWithOneScoopOfVanillaWithoutStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 0, 0));
        Cone result = iceCreamCarNoStock.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        assertEquals(result, null);
    }

    @Test
    @DisplayName("IceCreamCar - orderIceRocket() without stock")
    void shouldReturnEqualsWhenOrderingIceRocketWithoutStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 0, 0));
        IceRocket iceRocket = iceCreamCarNoStock.orderIceRocket();

        assertEquals(iceRocket, null);
    }

    @Test
    @DisplayName("IceCreamCar - getProfit()")
    void shouldReturnEqualsWhenGettingTotalProfit() {
        iceCreamCar.orderIceRocket();
        assertEquals(0.2, iceCreamCar.getProfit());
    }
}