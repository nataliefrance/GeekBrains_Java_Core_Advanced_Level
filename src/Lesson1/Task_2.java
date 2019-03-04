package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "rp  cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj",
                "bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup",
                "wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz",
                "ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox",
                "f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf",
                "zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx",
                "ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz",
                "zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv",
                "ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c"));

        howMuchVowels(list);
    }

    public static void howMuchVowels(ArrayList<String> list) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int counter = 0;

        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toCharArray();
            for (char c : chars) {
                for (char vowel : vowels) {
                    if (c == vowel) {
                        counter++;
                    }
                }
            }
            System.out.println("Строка № " + (i + 1) + " содержит " + counter + " гласных.");
            counter = 0;
        }
    }
}

