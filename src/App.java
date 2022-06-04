import java.lang.reflect.Method;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите левую границу функции: ");
        int l = scanner.nextInt();
        System.out.println();
        System.out.print("Введите правую границу функции: ");
        int r = scanner.nextInt();
        System.out.println();

        double xMax = ternMax(l,r,0.1);
        double maxValue = f(xMax);

        double xMin = ternMin(l,r,0.1);
        double minValue = f(xMin);

        System.out.println("Значение X для максимального занчения функции " + Math.round(xMax));
        System.out.println("Максимальное значение функции "+ Math.round(maxValue));

        System.out.println("Значение X для минимального занчения функции " + Math.round(xMin));
        System.out.println("Минимальное значение функции "+ Math.round(minValue));


    }



    //функция параболы, для которой проводятся поиски экстремумов
    public static double f(double x){
        return -x*x;
    }


    //поиск минимума заданной функции f()
    public static double ternMin(double l , double r, double eps){
        double m1, m2; // объявление двух точке на промежутке от правой и левой границы на функции
        while (r - l > eps){
             m1 = l + (r-l)/3; // присвоение координат точкам относительно границ
             m2 = r - (r-l)/3;
             if(f(m1)<f(m2))
                 r = m2;
             else
                 l = m1;
        }
        return ((l+r)/2);
    }

    //поиск максимума заданной функции f()
    public static double ternMax(double l ,double r, double eps){
        double m1, m2;
        while (r - l > eps){
            m1 = l + (r-l)/3;
            m2 = r - (r-l)/3;

            if(f(m1) < f(m2))
                l = m1;
            else
                r = m2;

        }
        return ((l+r)/2);
    }


    //функция нахождения индекса заданного числа в массиве тернарным поиском
    public static int ternarySearch(int[] array, int toFind){
        int r = array.length - 1;
        int l = 0;
        for (;l<=r;){
            int h = (r - l)/3;
            int m1 = l + h;
            int m2 = r - h;

            if (array[m1]==toFind)
                return m1;

            if (array[m2] == toFind)
                return m2;

            if (array[m1]<toFind && toFind<array[m2]){
                l = m1 + 1;
                r = m2 - 1;
            }

            else if(array[m1]>toFind)
                r = m1 - 1;

            else l = m2 + 1;

        }
        return  ((r-l)/2);
    }



    //функция сортировки пузырьком для ternarySearch() функции.
    public static int[] sort(int[]a){

        for (int i = 1;i<a.length;i++)
            for (int j = 0;j<a.length-1;j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
        }
        return a;
    }
}
