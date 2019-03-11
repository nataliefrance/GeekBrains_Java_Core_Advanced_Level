package Lesson3;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {
//        int[] mass = {1,2,3,4,5};
//
//        int[] mass2 = new int[20];
//
//        System.arraycopy(mass, 0, mass2, 0, mass.length);
//
//        System.out.println(Arrays.toString(mass2));
//        ArrayList<Integer> ai = new ArrayList<>();
//        ai.ensureCapacity(100);
//
//      //  System.out.println(ai.size());
//        ai.add(1222);
//        ai.add(2);
//        ai.add(3);
//        ai.add(1222);
//        ai.add(1222);
//        ai.add(1222);
//        ai.remove(2);
//
//        ai.trimToSize();
//
//        System.out.println(ai.remove((Integer)1222));

//        ArrayList<String> states = new ArrayList<>();
//
//        states.add("Германия");
//        states.add("Германия");
//        states.add("Франция");
//        states.add("Дания");
//        states.add("Россия");
//
//        Iterator<String> iter = states.iterator();
//        while (iter.hasNext()) {
//            if(iter.next().equalsIgnoreCase("Германия")) {
//                iter.remove();
//            }
//        }
//        System.out.println(states);
//
//        System.out.println(states.contains("Франция"));


//        LinkedList<String> ll = new LinkedList<>();
//
//        ll.addFirst("A");
//
//        ll.add("A");
//        ll.add("B");
//        ll.add("C");
//        ll.add("D");
//
//        ll.addLast("END");
      // ll.re
//        System.out.println(ll);
//
//
//        System.out.println(ll.get(2));
//System.out.println(ll.size());
//        System.out.println(ll.size());
//        ll.remove(2);
//
//        System.out.println(ll.get(0));
//        System.out.println(ll.get(1));
//        System.out.println(ll.get(2));
//        System.out.println(ll.size());
//
//        System.out.println(ll);
//
//        System.out.println(ll.get(2));


//        for (int i = 0; i < states.size(); i++) {
//            if(states.get(i).equalsIgnoreCase("Германия")) {
//                states.remove(i);
//                i--;
//            }
//        }
//
//        System.out.println(states);


//        LinkedList<String> ll = new LinkedList<>();
//
//        ll.add("a");
//        ll.add("b");
//        ll.add("c");
//        ll.add("d");
//
//        System.out.println(ll);
//
//        ll.add(1, "asd");
//
//        System.out.println(ll);
////        System.out.println(ai.size());
////
//    //    System.out.println(ai);
//
//        Box box1 = new Box("name");
//        Box box2 = new Box("name");
//
//        System.out.println(box1.hashCode() + " " + box2.hashCode());

//        HashMap<String, String> hm = new HashMap<>();
//
//        hm.put("Васька", "красный");
//        hm.put("Васька", "черный");
//        hm.put("Васька", "синий");
//        hm.put("Борис", "белый");

//        System.out.println(hm);
//
//
//        System.out.println(hm.containsValue("синий"));

//        Set<Map.Entry<String, String>> set = hm.entrySet();
//        for (Map.Entry<String, String> me : set) {
//            if(me.getValue().equalsIgnoreCase("синий")) {
//                System.out.println(me.getKey());
//            }
//        }



//        HashSet<String> hs = new HashSet<>();
//
//        hs.add("Acvsds");
//        hs.add("Bcs");
//        hs.add("Dcs123");
//        hs.add("Zwsd");
//
////
////        System.out.println(hs);
//        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
////        hm.put(1, new Box("box1"));
////        hm.put(2, new Box("box2"));
////        hm.put(3, new Box("box3"));
//
//        System.out.println(hm);

        TreeSet<Worker> ts = new TreeSet<>(new MyComp());

        ts.add(new Worker("name1", 1000));
        ts.add(new Worker("name2", 200));
        ts.add(new Worker("name3", 300));

        for (Worker w: ts) {
            System.out.println(w.getSalary());
        }

       // ts.comparator()

    }
}

class MyComp implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
        if(o1.getSalary() > o2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }

}

class Worker {
    String name;
    int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

//class Box {
//    String name;
//
//
//
//    public Box(String name) {
//        this.name = name;
//    }
//
//
//}