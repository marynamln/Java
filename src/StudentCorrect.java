import java.util.Objects;

public class StudentCorrect {
    private String name;
    private int course;

    StudentCorrect(String name, int course){
        this.name = name;
        this.course = course;
    }

    public int hashCode(){
        return Objects.hash(name, course);
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        StudentCorrect that = (StudentCorrect) obj;
        return course == that.course && name.equals(that.name);
    }

    public String toString() {
        return "Name: " + name + ", course: " + course;
    }
}
