package by.it_academy.jd2.Mk_JD2_103_23;

public class Genre implements Comparable<Genre> {
    private int point;
    private String name;

    public Genre(String name) {
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

        Genre genre = (Genre) o;

        if (point != genre.point) return false;
        return name != null ? name.equals(genre.name) : genre.name == null;
    }

    @Override
    public int hashCode() {
        int result = point;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Genre o) {
        int result = o.point - this.point;
        if (result == 0) {
            o.name.compareTo(this.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + point + ")";
    }
}
