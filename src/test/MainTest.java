package test;

import main.Calc;
import org.junit.Test;
import junit.framework.Assert;
import java.io.IOException;

/** Тестування
 * @author Скорик Артем
 * @version 1.0
 */
public class MainTest {
    /** Перевірка основного функціоналу {@linkplain Calc} */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        calc.init(0.0);
        org.junit.Assert.assertEquals(0.0, calc.getResult().getY(), .1e-10);
        calc.init(90.0);
        org.junit.Assert.assertEquals(1.0, calc.getResult().getY(), .1e-10);
        calc.init(180.0);
        org.junit.Assert.assertEquals(0.0, calc.getResult().getY(), .1e-10);
        calc.init(270.0);
        org.junit.Assert.assertEquals(-1.0, calc.getResult().getY(), .1e-10);
        calc.init(360.0);
        org.junit.Assert.assertEquals(0.0, calc.getResult().getY(), .1e-10);
    }

    /**  Перевірка серіалізації. Корректність відновлення даних. */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        double x, y;
        for(int ctr = 0; ctr < 1000; ctr++) {
            x = Math.random() * 360.0;
            y = calc.init(x);
            try {
                calc.save();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
            calc.init(Math.random() * 360);
            try {
                calc.restore();
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
            org.junit.Assert.assertEquals(y, calc.getResult().getY(), .1e-10);

            org.junit.Assert.assertEquals(x, calc.getResult().getX(), .1e-10);
        }
    }
}