package main;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Методи для обчислення та відображення результатів
 *
 * @author Скорик Артем
 */
public class Calc {

    /**
     * Ім'я файлу
     */
    private static final String FILE_NAME = "Item2d.bin";

    /**
     * Результат обчислень
     */
    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public void setResult(Item2d result) {
        this.result = result;
    }

    public Item2d getResult() {
        return result;
    }

    /**
     * Обчислює значення функція
     *
     * @param x - аргумент функції.
     * @return результат обчислення.
     */
    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);
    }

    /**
     * Обчислює значення функції та зберігає
     * результат в об'єкті {@linkplain Calc#result}
     *
     * @param x - аргумент функції.
     */
    public double init(double x) {
        result.setX(x);
        return result.setY(calc(x));
    }

    public void show() {
        System.out.println(result);
    }

    /**
     * Зберігає {@linkplain Calc#result}
     * в файлі {@linkplain Calc#FILE_NAME}
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FILE_NAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Відновлює {@linkplain Calc#result}
     * з файлу {@linkplain Calc#FILE_NAME}
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILE_NAME));
        result = (Item2d) is.readObject();
        is.close();
    }
}