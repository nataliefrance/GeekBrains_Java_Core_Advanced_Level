package Lesson1.Marathon;

import java.util.ArrayList;
import java.util.Arrays;

class Team {
    private ArrayList<Competitor> competitors = new ArrayList<>();

    Team(Competitor... list){
        competitors.addAll(Arrays.asList(list));
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    void showResults(){
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
