public class Citizen {

    private String nationalId;
    private int age;
    private boolean hasLearnersPermit;

    public Citizen(String nationalId, int age, boolean hasLearnersPermit) {
        this.nationalId = nationalId;
        this.age = age;
        this.hasLearnersPermit = hasLearnersPermit;
    }

    public String getNationalId() {
        return nationalId;
    }

    public int getAge() {
        return age;
    }

    public boolean hasLearnersPermit() {
        return hasLearnersPermit;
    }
}
