package Lesson1.Marathon;

import java.util.ArrayList;
import java.util.Arrays;

class Course {
    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    Course(Obstacle... list) {
        obstacles.addAll(Arrays.asList(list));
    }

    void doIt(Team team){
        for (Competitor c : team.getCompetitors()) {
           for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
