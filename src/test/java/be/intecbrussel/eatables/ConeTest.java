package be.intecbrussel.eatables;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class ConeTest {
    //properties
    //required for testing void methods
    ByteArrayOutputStream outContent;
    PrintStream originalOut;


    //pre-test
    @BeforeEach
    void beforeEach() {
        //required for testing void methods
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }


    //post-test
    @AfterEach
    void afterEach() {
        //required for testing void methods
        System.setOut(originalOut);
    }


    //constructors
    //no args
    @Test
    @DisplayName("Cone - no args constructor")
    void shouldReturnDoesNotEqualWhenCreatingConeWithNoArgsConstructor() {
        //given
        Cone cone = new Cone();

        //then
        assertNotEquals(null, cone);
    }

    //all args
    @Test
    @DisplayName("Cone - all args constructor")
    void shouldReturnDoesNotEqualWhenCreatingConeWithAllArgsConstructor() {
        //given
        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.VANILLA});

        //then
        assertNotEquals(cone, null);
    }


    //custom methods
    //eat
    @Test
    @DisplayName("Cone - eat()")
    void shouldReturnEqualsWhenComparingMethodPrint() {
        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        cone.eat();
        assertEquals("I'm eating a cone with vanilla", outContent.toString());
    }

    @Test
    @DisplayName("Cone - equals()")
    void shouldReturnEqualsWhenComparingIdenticalObjects() {
        Cone coneA = new Cone();
        Cone coneB = new Cone();

        assertEquals(coneA, coneB);
    }

    @Test
    @DisplayName("Cone - hashcode()")
    void shouldReturnEqualsWhenComparingHashcodesOfTwoIdenticalObjects() {
        Cone coneA = new Cone();
        Cone coneB = new Cone();

        assertEquals(coneA.hashCode(), coneB.hashCode());
    }
}