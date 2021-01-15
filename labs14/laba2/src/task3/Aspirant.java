package task3;

class Aspirant extends Student {
    int hoursOfScienceWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, int hoursOfScienceWork) {
        super(firstName, lastName, group, averageMark);
        this.hoursOfScienceWork = hoursOfScienceWork;
    }

    public Aspirant(String firstName, String lastName, String group, double averageMark) {
        super(firstName, lastName, group, averageMark);
    }

    @Override
    public int getScholarship() {
        return (averageMark == 5) ? 200 : 180;
    }
}
