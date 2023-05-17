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
    void shouldReturnNotNullWhenOrderingConeWithASingleScoopOfVanilla() {
        Cone result = iceCreamSalon.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        assertNotNull(result);
    }

    @Test
    @DisplayName("IceCreamSalon - orderIceRocket()")
    void shouldReturnNotNullWhenOrderingIceRocket() {
        IceRocket result = iceCreamSalon.orderIceRocket();
        assertNotNull(result);
    }

    @Test
    @DisplayName("IceCreamSalon - orderMagnum()")
    void shouldReturnNotNullEqualsWhenOrderingMagnum() {
        Magnum result = iceCreamSalon.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        assertNotNull(result);
    }

    @Test
    @DisplayName("IceCreamSalon - getProfit()")
    void shouldReturnEqualsWhenGettingTotalProfit() {
        iceCreamSalon.orderIceRocket();
        iceCreamSalon.orderIceRocket();
        assertEquals(0.4, iceCreamSalon.getProfit());
    }

    @Test
    @DisplayName("IceCreamSalon - toString()")
    void shouldReturnEqualsWhenCallingToStringMethod() {
        String result = iceCreamSalon.toString();
        String anticipatedResult = "IceCreamSalon{priceList=PriceList{ballPrice=1.0, rocketPrice=1.0, magnumStandardPrice=1.0}, totalProfit=0.0}";

        assertEquals(anticipatedResult, result);
    }

}