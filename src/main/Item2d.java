package main;

import java.io.Serializable;

/**
 * Хранит исходные данные и результат вычислений.
 *
 * @author Скорик Артем
 */
public class Item2d implements Serializable {
    /**
     * Аргумент
     */
    // transient
    private double x;
    /**
     * Результат обчислення
     */
    private double y;

    /**
     * Згенерована константа
     */
    private static final long serialVersionUID = 1L;

    public Item2d() {
        x = .0;
        y = .0;
    }

    public Item2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double setY(double y) {
        return this.y = y;
    }

    public double getY() {
        return y;
    }

    public Item2d setXY(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Представляє результат обчислень у вигляді рядку
     */
    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }

    /**
     * Згенерований метод перевірки об'єктів на рівність
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Item2d other = (Item2d) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;

        return !(Math.abs(Math.abs(y) - Math.abs(other.y)) > .1e-10);
    }
}