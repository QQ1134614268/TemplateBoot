package com.it.sim.test.generic;

import java.awt.*;

/**
 * 边界 边界作用： 可以用于在泛型地参数上设置限制条件。 你可以按照自己的边界类型来调用方法。
 * 因为擦除移除了类型，所以你可以用泛型参数调用的方法只是Object调用的方法。
 * 但是，如果能够将这个参数限制在某个类型子类，那么你就可以用这些类型子集来调用方法。 为了执行这种限制，Java泛型重用了extends关键字
 */
interface HasColor {
    Color getColor();
}

class Dimension {
    public int x, y, z;
}

interface Weight {
    int weight();
}

class HoldItem<T> {
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

class Colored<T extends HasColor> {
    T item;

    Colored(T item) {
        this.item = item;
    }

    Color getColor() {
        return item.getColor();
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {
    Colored2(T item) {
        super(item);
    }

    Color getColor() {
        return item.getColor();
    }
}

class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    Color getColor() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {
    ColoredDimension2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}

class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    Color getColor() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {
    @Override
    public int weight() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> s = new Solid<>(new Bounded());
        Solid2<Bounded> s2 = new Solid2<>(new Bounded());
        s.getColor();
        s.getX();
        s2.getColor();
        s2.getY();
    }
}
