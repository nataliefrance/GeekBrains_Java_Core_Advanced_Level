package Lesson5.HomeTask;

import java.util.Arrays;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main {
    private final int SIZE = 10000000;
    private final int THREADS_COUNT = 4;
    private final int PART_SIZE = SIZE / THREADS_COUNT;
    private final float[] ARRAY = new float[SIZE];

    public static void main(String[] args) {
        Main main = new Main();
        Arrays.fill(main.ARRAY, 1f);

        main.simpleMethod(main.ARRAY);
        main.methodWithThreads(main.ARRAY);
    }

    private void methodWithThreads(float[] array){
        long startTime = System.currentTimeMillis();
        float[][] splittedArray = new float[THREADS_COUNT][PART_SIZE];
        Thread[] threadArray = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            // будем копировать в двумерный массив данные из основного потока со сдвигом
            //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
            //массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
            System.arraycopy(array, PART_SIZE * i, splittedArray[i], 0, PART_SIZE);
            int u = i;
            threadArray[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // считаем массив со сдвигом
                    int n = u * PART_SIZE;
                    for (int j = 0; j < PART_SIZE; j++, n++) {
                        splittedArray[u][j] = (float) (splittedArray[u][j] * sin(0.2f + n / 5) * cos(0.2f + n / 5) * cos(0.4f + n / 2));
                    }
                }
            });
            threadArray[i].start();
        }
        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                threadArray[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // складываем массив обратно в исходный массив
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(splittedArray[i], 0, array, i * PART_SIZE, PART_SIZE);
        }
        // определяем время
        System.out.println("Время работы methodWithThreads: " + (System.currentTimeMillis() - startTime));
    }

    private void simpleMethod(float[] array){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы simpleMethod: " + (System.currentTimeMillis() - startTime));
    }
}

