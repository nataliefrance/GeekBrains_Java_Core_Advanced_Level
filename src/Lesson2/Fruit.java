package Lesson2;

public enum Fruit {
    ORANGE("Аппельсин",5), APPLE("Яблоко",8), BANANA("Банан",1), CHERRY("Вишня",3);

    private String rus;
    private int weight;

    Fruit(String rus, int weight) {
        this.rus = rus;
        this.weight = weight;
    }

    public String getRus() {
        return rus;
    }

    public int getWeight() {
        return weight;
    }
}

class MainEnum {
    public static void main(String[] args) {
        //Fruit f = Fruit.APPLE;

        System.out.println(Fruit.APPLE);

        Fruit f = Fruit.APPLE;
        System.out.println(f.ordinal());

//        for (Fruit o: Fruit.values()) {
//            System.out.println(o.getRus() + " " + o.getWeight() + " " + o);
//        }

       // System.out.println(Fruit.valueOf("APPLE").ordinal());

    }
}
