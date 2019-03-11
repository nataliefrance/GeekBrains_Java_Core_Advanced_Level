package Lesson3;

public class Test {

//    1
//    public static void main(String[] args) {
//        float d = 12.3;
//        System.out.println(d);
//    }


//---------------------------------------------------

//    2
//    public static void main(String[] args) {
//      System.out.println(1 % 2 == 1);
//    }


//---------------------------------------------------

//   3
//    public static void main(String[] args) {
//        String str = "abc";
//
//        switch (str) {
//            case "ab":
//                System.out.println("ab");
//            case "abc":
//                System.out.println("abc");
//            default:
//                System.out.println("break");
//            case "abcd":
//                System.out.println("abcd");
//        }
//    }


//---------------------------------------------------


//    4
//    public static void main(String[] args) {
//        for (int i = 0; i < 5; i+=2) {
//            System.out.println(i++);
//        }
//    }


//---------------------------------------------------



//   5
//    public static void main(String[] args) {
//        {
//            int i = 20;
//        }
//        int i = 15;
//
//        System.out.println(i);
//    }


//---------------------------------------------------



//    6
//    public static void main(String[] args) {
//        int i = 2;
//
//        do {
//            System.out.println(++i);
//        } while (i == 3);
//    }



//---------------------------------------------------


//     7
//    public static void main(String[] args) {
//        while (true) {
//            int i = 5;
//            System.out.println(i);
//            if(i++ == 6) {
//                break;
//            }
//        }
//    }



//---------------------------------------------------



//    8
//    public static void main(String[] args) {
//        for (int i = -1; i < 10; i+=2) {
//            if(i == 2) {
//                continue;
//            }
//            if (i > 5) {
//                break;
//            }
//            System.out.println(++i);
//        }
//    }


//    9
//        public static void main(String[] args) {
//            System.out.println(11/0);
//        }
//


    //    10
    public static void main(String[] args) {
        double d1 = 11./0;
        double d2 = 15./0;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1 - d2);
    }

}

//class TestNew {
//    public static void main(String[] args) {
//        String strA = "text";
//        String strB = "text";
//        strA += "1";
//        strB += "1";
//        System.out.println(strA == strB);
//        strA = "text1";
//        strB = "text1";
//        System.out.println(strA == strB);
//    }
//}
//


/////////////////////////////////



//
//interface I {
//    public final static int EASY = 5;
//}
//
//class Main2 implements I {
//    public static void main(String[] args) {
//        int a = 5;
//        test(++a);
//    }
//
//    static void test(int a) {
//        a += EASY + a++;
//        System.out.println(a);
//    }
//
//}
//




/////////////////////////////



//class Main3 {
//    public static void main(String[] args) {
//        for (int i = 0; i <= 10 ; i++) {
//            if(i > 6) break;
//        }
//        System.out.println(i);
//    }
//}
