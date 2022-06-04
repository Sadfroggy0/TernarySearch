import java.lang.reflect.Method;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int [] a = {1,5,8,-777,160,-13,-33,23,35,9,-666,777};

        System.out.println(ternMax(0,5,0.1));
        System.out.println(ternMin(-2,5,0.1));

    }

    //функция параболы, для которой проводятся поиски экстремумов
    public static double f(double x){
        return x*x;
    }


    //поиск минимума заданной функции f()
    public static double ternMin(double l , double r, double eps){
        double m1, m2;
        while (r - l > eps){
             m1 = l + (r-l)/3;
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
