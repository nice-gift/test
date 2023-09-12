package by.it_academy.jd2.Mk_JD2_103_23;

public class Musician implements Comparable {
    private int point;
    private String name;

    public Musician(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musician musician = (Musician) o;

        if (point != musician.point) return false;
        return name != null ? name.equals(musician.name) : musician.name == null;
    }

    @Override
    public int hashCode() {
        int result = point;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Object o) {
        Musician musician = (Musician) o;

        int result = this.point - musician.point;
        if (result == 0) {
            result = this.hashCode() - musician.hashCode();
        }

        return result;
    }

    @Override
    public String toString() {
        return name + " " + point + " point";
    }
}
