package Lesson5.HomeTask;

public class MyThread extends Thread {
    private float[] array;

    MyThread(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Main.reCalculate(array);
    }
}
