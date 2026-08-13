package ru.itone.course_java.core.base_syntax;

public class BaseSyntax {

    // Реализовать логическое И
    public boolean and(boolean x, boolean y) {
        return x ? y : false;
    }

    // Реализовать логическое ИЛИ
    public boolean or(boolean x, boolean y) {
        return !x ? y : true;
    }

    // Реализовать логическое СТРОГОЕ ИЛИ
    public boolean xor(boolean x, boolean y) {
        return x != y;
    }

    // Реализовать сумму двух чисел типа short
    public int sum(short x, short y) {
        return x + y;
    }

    // Реализовать сумму двух чисел типа byte, если результат не вмещается в byte, бросить ошибку (Можно бросить просто RuntimeException)
    public byte sum(byte x, byte y) {
        int sum =  x + y;

        if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
            throw new ArithmeticException();
        }

        return (byte) sum;
    }

    // Реализовать произведение двух чисел типа short
    public int mult(short x, short y) {
        return x * y;
    }

    // Реализовать произведение двух чисел типа int
    public long mult(int x, int y) {
        return (long) x * y;
    }

    // Реализовать деление двух чисел типа int, если входные данные не корректные, бросить ошибку (Можно бросить просто RuntimeException)
    public int div(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException();
        }

        return x / y;
    }

    // Реализовать сравнение двух чисел типа float по МОДУЛЮ (без учёта знака), с точностью до 0.0001
    public boolean sameByMod(float x, float y) {
        float modX = Math.abs(x);
        float modY = Math.abs(y);

        float diff = Math.abs(modX - modY);

        return diff < 0.0001f;
    }

    // Реализовать сложение значения аргументов типа char в число
    public int sumCharValues(char... x) {
        int sum = 0;

        for (char i : x) { sum += i; }

        return sum;
    }

    // Реализовать вычисление факториала натурального числа x. В случае некорректных данных бросить ошибку
    public double factorial(int x) {
        if (x < 0) {
            throw new ArithmeticException();
        }

        double result = 1;

        for (int i = 1; i <= x; i++) { result *= i; }

        return result;
    }
}
