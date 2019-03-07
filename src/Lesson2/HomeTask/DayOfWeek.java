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
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }

    static String getWorkingHours(DayOfWeek dayOfWeek){

        DayOfWeek[] days = new DayOfWeek[2];

        int num = 5 - dayOfWeek.ordinal();
        return (num > 0) ? String.valueOf(num*8) + " hours" : "Weekend!";
    }
}
