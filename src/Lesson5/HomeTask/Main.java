package Lesson5.HomeTask;

public class Main {
    private static final int size = 10000000;
    private static final int half = size / 2;

    public static void main(String[] args) {
        //вынесла создание и инициализацию массива сюда, т.к. Идея ворчала из-за дублирования кода
        float[] array = new float[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        simpleMethod(array);
        methodWithThreads(array);

    }

    private static void simpleMethod(float[] array){
        long startTime = System.currentTimeMillis();
        reCalculate(array);
        System.out.println("Время работы simpleMethod: " + (System.currentTimeMillis() - startTime));
    }

    private static void methodWithThreads(float[] array){
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];

        //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
        //массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
        System.arraycopy(array, 0, arr1, 0, half);
        System.arraycopy(array, half, arr2, 0, half);

        MyThread t1 = new MyThread(arr1);
        MyThread t2 = new MyThread(arr2);

        t1.start();
        t2.start();

        System.arraycopy(arr1, 0, array, 0, half);
        System.arraycopy(arr2, 0, array, half, half);

        System.out.println("Время работы methodWithThreads: " + (System.currentTimeMillis() - startTime));
    }

    static void reCalculate(float[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}

