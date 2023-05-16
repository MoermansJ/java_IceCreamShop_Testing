package be.intecbrussel.eatables;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MagnumTest {
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
    //no-args
    @Test
    @DisplayName("Magnum - no args constructor")
    void shouldReturnNotEqualsWhenCreatingInstanceWithNoArgsConstructor() {
        //when
        Magnum magnum = new Magnum();

        //then
        assertNotEquals(magnum, null);
    }

    //all args
    @Test
    @DisplayName("Magnum - all args constructor")
    void shouldReturnNotEqualsWhenCreatingInstanceWithAllArgsConstructor() {
        //when
        Magnum magnum = new Magnum(Magnum.MagnumType.ALPINENUTS);

        //then
        assertNotEquals(magnum, null);
    }


    //getters & setters
    //getType()
    @Test
    @DisplayName("Magnum - getType()")
    void shouldReturnEqualsWhenGettingType() {
        //given
        Magnum magnum = new Magnum();

        //then
        assertEquals(magnum.getType(), Magnum.MagnumType.MILKCHOCOLATE);
    }


    //custom methods
    //eat()
    @Test
    @DisplayName("Magnum - eat()")
    void shouldReturnEqualsWhenComparingMethodPrint() {
        Magnum magnum = new Magnum();
        magnum.eat();
        assertEquals("I'm eating milkchocolate", outContent.toString());
    }
}