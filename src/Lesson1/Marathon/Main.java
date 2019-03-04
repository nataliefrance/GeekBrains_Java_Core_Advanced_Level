package Lesson1.Marathon;

public class Main {
    public static void main(String[] args) {
        Team team = new Team(new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        Course course = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120));

        course.doIt(team);
        team.showResults();
    }
}