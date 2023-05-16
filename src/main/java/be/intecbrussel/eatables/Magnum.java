package be.intecbrussel.eatables;

import java.util.Objects;

public class Magnum implements Eatable {
    //properties
    private MagnumType type;


    //constructors
    public Magnum() {
        this.type = MagnumType.MILKCHOCOLATE;
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }


    //getters & setters
    public MagnumType getType() {
        return type;
    }


    //custom methods
    @Override
    public void eat() {
        System.out.print("I'm eating " + this.getType().name().toLowerCase());
    }

    //innerclasses
    public enum MagnumType {
        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRIES;
    }
}
