package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamSalonTest {
    //properties
    IceCreamSalon iceCreamSalon;

    //pre-testing
    @BeforeEach
    void setUp() {
        iceCreamSalon = new IceCreamSalon(new PriceList(1, 1, 1));
    }

    //testing methods
    @Test
    @DisplayName("IceCreamSalon - orderCone()")
    void shouldReturnEqualsWhenOrderingConeWithASingleScoopOfVanilla() {
        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        Cone result = iceCreamSalon.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        assertEquals(cone, result);
    }

    @Test
    @DisplayName("IceCreamSalon - orderIceRocket()")
    void shouldReturnNotEqualsWhenOrderingIceRocket() {
        IceRocket result = iceCreamSalon.orderIceRocket();

        assertNotEquals(null, result);
    }

    @Test
    @DisplayName("IceCreamSalon - orderMagnum()")
    void shouldReturnEqualsWhenOrderingMagnum() {
        Magnum magnum = new Magnum(Magnum.MagnumType.MILKCHOCOLATE);
        Magnum result = iceCreamSalon.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);

        assertEquals(magnum, result);
    }

    @Test
    @DisplayName("IceCreamSalon - getProfit()")
    void shouldReturnEqualsWhenGettingTotalProfit() {
        iceCreamSalon.orderIceRocket();
        assertEquals(0.2, iceCreamSalon.getProfit());
    }

    @Test
    @DisplayName("IceCreamSalon - toString()")
    void shouldReturnEqualsWhenCallingToStringMethod() {
        String result = iceCreamSalon.toString();
        String anticipatedResult = "IceCreamSalon{priceList=PriceList{ballPrice=1.0, rocketPrice=1.0, magnumStandardPrice=1.0}, totalProfit=0.0}";

        assertEquals(anticipatedResult, result);
    }

}