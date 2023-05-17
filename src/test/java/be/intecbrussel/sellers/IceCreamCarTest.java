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
        iceCreamCar = new IceCreamCar(new PriceList(1, 1, 1), new Stock(2, 1, 1, 1));
    }


    //testing methods
    @Test
    @DisplayName("IceCreamCar - orderCone() with stock")
    void shouldReturnEqualsWhenOrderingConeWithOneScoopOfVanilla() {
        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        Cone result = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        assertEquals(cone, result);
    }

    @Test
    @DisplayName("IceCreamCar - orderCone() with stock - not null")
    void shouldReturnNotNullWhenOrderingConeWithOneScoopOfVanilla() {
        Cone result = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        assertNotNull(result);
    }

    @Test
    @DisplayName("IceCreamCar - orderIceRocket() with stock")
    void shouldNotNullWhenOrderingIceRocket() {
        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        assertNotNull(iceRocket);
    }

    @Test
    @DisplayName("IceCreamCar - orderMagnum() with stock")
    void shouldReturnNotNullWhenOrderingMagnum() {
        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        assertNotNull(magnum);
    }

    @Test
    @DisplayName("IceCreamCar - orderMagnum() without stock")
    void shouldReturnNullWhenOrderingMagnumWithoutStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 0, 0));
        Magnum magnum = iceCreamCarNoStock.orderMagnum(Magnum.MagnumType.ALPINENUTS);

        assertNull(magnum);
    }

    @Test
    @DisplayName("IceCreamCar - orderCone() without cone stock")
    void shouldReturnNullWhenOrderingConeWithOneScoopOfVanillaWithoutConeStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 1, 0, 0));
        Cone result = iceCreamCarNoStock.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        assertNull(result);
    }

    @Test
    @DisplayName("IceCreamCar - orderCone() without balls stock")
    void shouldReturnNullWhenOrderingConeWithOneScoopOfVanillaWithoutBallsStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 1, 0));
        Cone result = iceCreamCarNoStock.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        assertNull(result);
    }

    @Test
    @DisplayName("IceCreamCar - orderIceRocket() without stock")
    void shouldReturnNullWhenOrderingIceRocketWithoutStock() {
        IceCreamCar iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 0, 0));
        IceRocket iceRocket = iceCreamCarNoStock.orderIceRocket();

        assertNull(iceRocket);
    }

    @Test
    @DisplayName("IceCreamCar - getProfit()")
    void shouldReturnEqualsWhenGettingTotalProfit() {
        iceCreamCar.orderIceRocket();
        iceCreamCar.orderIceRocket();
        assertEquals(0.4, iceCreamCar.getProfit());
    }
}