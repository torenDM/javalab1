import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Methods {
    // 1.1
    public double fraction(double x) {
        return x - (int) x; // Из вещественного x вычитаем целое значение x, оставляя только дробную часть
    }

    // 1.3
    public int charToNum(char x) {
        return x - '0'; // Из символа вычитается значения символа '0', оставляя только соответствующее число
    }

    // 1.5
    public boolean is2Digits(int x) {
        return (x >= 10 && x <= 99) || (x <= -10 && x >= -99);
    }

    // 1.7
    public boolean isInRange(int a, int b, int num) {
        return (num >= a && num <= b || num >= b && num <= a);
    }

    // 1.9
    public boolean isEqual(int a, int b, int c) {
        return (a == b && b == c);
    }

    // 2.1
    public int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }

    // 2.3
    public boolean is35(int x) {
        return ((x % 3 == 0) || (x % 5 == 0)) && !(x % 3 == 0 && x % 5 == 0);
    }

    // 2.5
    public int max3(int x, int y, int z) {
        if (x > y && x > z) return x;
        if (y > x && y > z) return y;
        return z;
    }

    // 2.7
    public int sum2(int x, int y) {
        if (x + y < 10 || x + y > 20) return x + y;
        else return 20;
    }

    // 2.9
    public String day(int x) {
        return switch (x) {
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            case 7 -> "воскресенье";
            default -> "это не день недели";
        };
    }

    // 3.1
    public String listNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i++)
            result.append(i).append(" ");
        return result.toString();
    }

    // 3.3
    public String chet(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i += 2)
            result.append(i).append(" ");
        return result.toString();
    }

    // 3.5
    public int numLen(long x) {
        x = Math.abs(x);
        int length = 1;
        while (x >= 10) {
            x /= 10;
            length++;
        }
        return length;
    }

    // 3.7
    public void square(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < x; i++)
            result.append("*");
        System.out.println("Ответ:");
        for (int i = 0; i < x; i++)
            System.out.println(result);
    }

    // 3.9
    public void rightTriangle(int x) {
        String result = "*";
        System.out.println("Ответ:");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x - i - 1; j++)
                System.out.print(" ");
            for (int j = x - i - 1; j < x; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 4.1
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x) return i;
        return -1;
    }

    // 4.3
    public int maxAbs(int[] arr) {
        int max = arr[0];
        int indexResult = 0;
        for (int i = 0; i < arr.length; i++)
            if (Math.abs(arr[i]) > max) {
                max = Math.abs(arr[i]);
                indexResult = i;
            }
        return arr[indexResult];
    }

    // 4.5
    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        int count = 0;
        for (int i = 0; i < arr.length + ins.length; i++) {
            if (i == pos) for (int in : ins) result[i++] = in;
            result[i] = arr[count++];
        }
        return result;
    }

    // 4.7
    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    // 4.9
    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i : arr) if (i == x) count++;
        int[] result = new int[count];
        count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x) result[count++] = i;
        return result;
    }

}

public class Main {
    public static void main(String[] args) {
        Methods object = new Methods();
        System.out.println("Программа запускает методы по запросу <x.y>. Для завершения работы напишите <end>.");

        boolean running = true;
        Scanner inputTask = new Scanner(System.in);
        Scanner inputDouble = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        Scanner inputChar = new Scanner(System.in);
        Scanner inputLong = new Scanner(System.in);

        while (running) {
            System.out.print("\nВведите номер задания: ");
            String n = inputTask.nextLine();
            switch (n) {
                // Задание 1
                case "1.1":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public double fraction (double x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал только
                            дробную часть числа х. Подсказка: вещественное число может быть
                            преобразовано к целому путем отбрасывания дробной части""");
                    try {
                        System.out.print("Введите число: ");
                        double x = inputDouble.nextDouble();
                        System.out.println("Ответ: " + object.fraction(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "1.3":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int charToNum (char x);
                            Метод принимает символ х, который представляет собой один из “0 1 2 3 4 5 6 7
                            8 9”. Необходимо реализовать метод таким образом, чтобы он преобразовывал
                            символ в соответствующее число. Подсказка: код символа ‘0’ — это число 48""");
                    try {
                        System.out.print("Введите число: ");
                        char x = inputChar.next().charAt(0);
                        if (x == '0' || x == '1' || x == '2' || x == '3' || x == '4' || x == '5' || x == '6' ||
                                x == '7' || x == '8' || x == '9') System.out.println("Ответ: " + object.charToNum(x));
                        else System.out.println("Ошибка: Введено неверное значение");
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "1.5":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public bool is2Digits (int x);
                            Необходимо реализовать метод таким образом, чтобы он принимал число x и
                            возвращал true, если оно двузначное.""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        System.out.println("Ответ: " + object.is2Digits(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "1.7":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public bool isInRange (int a, int b, int num);
                            Метод принимает левую и правую границу (a и b) некоторого числового
                            диапазона. Необходимо реализовать метод таким образом, чтобы он возвращал
                            true, если num входит в указанный диапазон (включая границы). Обратите
                            внимание, что отношение a и b заранее неизвестно (неясно кто из них больше, а
                            кто меньше)""");
                    try {
                        System.out.print("Введите первую границу: ");
                        int x1 = inputInt.nextInt();
                        System.out.print("Введите вторую границу: ");
                        int x2 = inputInt.nextInt();
                        System.out.print("Введите число для проверки границ: ");
                        int num = inputInt.nextInt();
                        System.out.println("Ответ: " + object.isInRange(x1, x2, num));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "1.9":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public bool isEqual(int a, int b, int c);
                            Необходимо реализовать метод таким образом, чтобы он возвращал true, если
                            все три полученных методом числа равны""");
                    try {
                        System.out.print("Введите первое число: ");
                        int x1 = inputInt.nextInt();
                        System.out.print("Введите второе число: ");
                        int x2 = inputInt.nextInt();
                        System.out.print("Введите третье число: ");
                        int x3 = inputInt.nextInt();
                        System.out.println("Ответ: " + object.isEqual(x1, x2, x3));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                // Задание 2
                case "2.1":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int abs (int x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал модуль
                            числа х (если оно было положительным, то таким и остается, если он было
                            отрицательным – то необходимо вернуть его без знака минус).""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        System.out.println("Ответ: " + object.abs(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "2.3":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public bool is35 (int x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал true, если
                            число x делится нацело на 3 или 5. При этом, если оно делится и на 3, и на 5, то
                            вернуть надо false. Подсказка: оператор % позволяет получить остаток от
                            деления.""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        System.out.println("Ответ: " + object.is35(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "2.5":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int max3 (int x, int y, int z);
                            Необходимо реализовать метод таким образом, чтобы он возвращал
                            максимальное из трех полученных методом чисел. Подсказка: идеальное
                            решение включает всего две инструкции if и не содержит вложенных if.""");
                    try {
                        System.out.print("Введите первое число: ");
                        int x = inputInt.nextInt();
                        System.out.print("Введите второе число: ");
                        int y = inputInt.nextInt();
                        System.out.print("Введите третье число: ");
                        int z = inputInt.nextInt();
                        System.out.println("Ответ: " + object.max3(x, y, z));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "2.7":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int sum2 (int x, int y);
                            Необходимо реализовать метод таким образом, чтобы он возвращал сумму
                            чисел x и y. Однако, если сумма попадает в диапазон от 10 до 19, то надо вернуть
                            число 20.""");
                    try {
                        System.out.print("Введите первое число: ");
                        int x = inputInt.nextInt();
                        System.out.print("Введите второе число: ");
                        int y = inputInt.nextInt();
                        System.out.println("Ответ: " + object.sum2(x, y));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "2.9":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public String day (int x);
                            Метод принимает число x, обозначающее день недели. Необходимо реализовать
                            метод таким образом, чтобы он возвращал строку, которая будет обозначать
                            текущий день недели, где 1- это понедельник, а 7 – воскресенье. Если число не
                            от 1 до 7 то верните текст “это не день недели”. Вместо if в данной задаче
                            используйте switch.\s""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        System.out.println("Ответ: " + object.day(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "3.1":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public String listNums (int x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал строку, в
                            которой будут записаны все числа от 0 до x (включительно).""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        if (x < 0) System.out.println("Ошибка: Введено отрицательное значение");
                        else System.out.println("Ответ: " + object.listNums(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "3.3":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public String chet (int x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал строку, в
                            которой будут записаны все четные числа от 0 до x (включительно). Подсказа
                            для обеспечения качества кода: инструкцию if использовать не следует.""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        if (x < 0) System.out.println("Ошибка: Введено отрицательное значение");
                        else System.out.println("Ответ: " + object.chet(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "3.5":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int numLen (long x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал количество
                            знаков в числе x.\s""");
                    try {
                        System.out.print("Введите число: ");
                        long x = inputLong.nextLong();
                        System.out.println("Ответ: " + object.numLen(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "3.7":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public void square (int x);
                            Необходимо реализовать метод таким образом, чтобы он выводил на экран
                            квадрат из символов ‘*’ размером х, у которого х символов в ряд и х символов в
                            высоту.\s""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        if (x < 0) System.out.println("Ошибка: Введено отрицательное значение");
                        else object.square(x);
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "3.9":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public void rightTriangle (int x);
                            Необходимо реализовать метод таким образом, чтобы он выводил на экран
                            треугольник из символов ‘*’ у которого х символов в высоту, а количество
                            символов в ряду совпадает с номером строки, при этом треугольник выровнен
                            по правому краю. Подсказка: перед символами ‘*’ следует выводить
                            необходимое количество пробелов""");
                    try {
                        System.out.print("Введите число: ");
                        int x = inputInt.nextInt();
                        if (x < 0) System.out.println("Ошибка: Введено отрицательное значение");
                        else object.rightTriangle(x);
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "4.1":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int findFirst (int[] arr, int x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал индекс
                            первого вхождения числа x в массив arr. Если число не входит в массив –
                            возвращается -1.""");
                    try {
                        System.out.print("Введите длину массива: ");
                        int length = inputInt.nextInt();
                        if (length <= 0) System.out.println("Ошибка: Введено неверное значение");
                        else {
                            System.out.print("Введите массив: ");
                            int[] arr = new int[length];
                            for (int i = 0; i < length; i++) {
                                arr[i] = inputInt.nextInt();
                            }
                            System.out.print("Введите значение x: ");
                            int x = inputInt.nextInt();
                            System.out.println("Ответ: " + object.findFirst(arr, x));
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "4.3":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int maxAbs (int[] arr);
                            Необходимо реализовать метод таким образом, чтобы он возвращал
                            наибольшее по модулю (то есть без учета знака) значение массива arr.""");
                    try {
                        System.out.print("Введите длину массива: ");
                        int length = inputInt.nextInt();
                        if (length <= 0) System.out.println("Ошибка: Введено неверное значение");
                        else {
                            System.out.print("Введите массив: ");
                            int[] arr = new int[length];
                            for (int i = 0; i < length; i++) {
                                arr[i] = inputInt.nextInt();
                            }
                            System.out.println("Ответ: " + object.maxAbs(arr));
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "4.5":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int[] add (int[] arr, int[] ins, int pos);
                            Необходимо реализовать метод таким образом, чтобы он возвращал новый
                            массив, который будет содержать все элементы массива arr, однако в позицию
                            pos будут вставлены значения массива ins""");
                    try {
                        System.out.print("Введите длину основного массива: ");
                        int length1 = inputInt.nextInt();
                        System.out.print("Введите длину дополнительного массива: ");
                        int length2 = inputInt.nextInt();
                        if (length1 <= 0 || length2 <= 0) System.out.println("Ошибка: Введено неверное значение");
                        else {
                            System.out.print("Введите основной массив: ");
                            int[] arr1 = new int[length1];
                            for (int i = 0; i < length1; i++) {
                                arr1[i] = inputInt.nextInt();
                            }
                            System.out.print("Введите дополнительный массив: ");
                            int[] arr2 = new int[length2];
                            for (int i = 0; i < length2; i++) {
                                arr2[i] = inputInt.nextInt();
                            }
                            System.out.print("Введите позицию для вставки: ");
                            int pos = inputInt.nextInt();
                            if (pos > length1 || pos < 0) System.out.println("Ошибка: Введено неверное значение");
                            else System.out.println("Ответ: " + Arrays.toString(object.add(arr1, arr2, pos)));
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "4.7":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int[] reverseBack (int[] arr);
                            Необходимо реализовать метод таким образом, чтобы он возвращал новый
                            массив, в котором значения массива arr записаны задом наперед.""");
                    try {
                        System.out.print("Введите длину массива: ");
                        int length = inputInt.nextInt();
                        if (length <= 0) System.out.println("Ошибка: Введено неверное значение");
                        else {
                            System.out.print("Введите массив: ");
                            int[] arr = new int[length];
                            for (int i = 0; i < length; i++) {
                                arr[i] = inputInt.nextInt();
                            }
                            System.out.println("Ответ: " + Arrays.toString(object.reverseBack(arr)));
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "4.9":
                    System.out.println("""
                            Задание: Дана сигнатура метода: public int[] findAll (int[] arr, int x);
                            Необходимо реализовать метод таким образом, чтобы он возвращал новый
                            массив, в котором записаны индексы всех вхождений числа x в массив arr.""");
                    try {
                        System.out.print("Введите длину массива: ");
                        int length = inputInt.nextInt();
                        if (length <= 0) System.out.println("Ошибка: Введено неверное значение");
                        else {
                            System.out.print("Введите массив: ");
                            int[] arr = new int[length];
                            for (int i = 0; i < length; i++) {
                                arr[i] = inputInt.nextInt();
                            }
                            System.out.print("Введите значение x: ");
                            int x = inputInt.nextInt();
                            System.out.println("Ответ: " + Arrays.toString(object.findAll(arr, x)));
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено неверное значение");
                        running = false;
                    }
                    break;

                case "end":
                    running = false;
                    break;

                default:
                    System.out.println("Ошибка: Введен неверный номер задания - " + n);
                    break;
            }

        }
        inputInt.close();
        inputDouble.close();
        inputChar.close();
        inputTask.close();
        System.out.println("Завершение работы программы...");
    }
}