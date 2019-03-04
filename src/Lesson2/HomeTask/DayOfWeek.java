package Lesson2.HomeTask;
//Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
//С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заданному текущему дню.
//
// Возвращает кол-во оставшихся рабочих часов до конца
// недели по заданному текущему дню. Считается, что
// текущий день ещё не начался, и рабочие часы за него
// должны учитываться.

public enum DayOfWeek{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class DayOfWeekMain{
    public static void main(final String[] args) {
        getWorkingHours(DayOfWeek.MONDAY);
//        getWorkingHours(DayOfWeek.TUESDAY);
//        getWorkingHours(DayOfWeek.WEDNESDAY);
//        getWorkingHours(DayOfWeek.THURSDAY);
//        getWorkingHours(DayOfWeek.FRIDAY);
//        getWorkingHours(DayOfWeek.SATURDAY);
//        getWorkingHours(DayOfWeek.SUNDAY);
    }

    static void getWorkingHours(DayOfWeek dayOfWeek){
        int workingHours = 0;

        switch (dayOfWeek){
            case SATURDAY:
            case SUNDAY:
                workingHours = 0;
                System.out.println("Поздравляем, сейчас выходной!");
                break;
            case MONDAY:
                workingHours = 40;
                break;
            case TUESDAY:
                workingHours = 32;
                break;
            case WEDNESDAY:
                workingHours = 24;
                break;
            case THURSDAY:
                workingHours = 16;
                break;
            case FRIDAY:
                workingHours = 8;
                break;
        }

        System.out.println("До конца рабочей недели осталось " + workingHours + " часов.");

    }
}
