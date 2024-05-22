import java.util.Objects;

public class StudentIncorrect {
    private String name;
    private int course;

    StudentIncorrect(String name, int course){
        this.name = name;
        this.course = course;
    }

    public int hashCode(){
        return course;
    }

    public boolean equals(Object obj){
        return false;
    }

    public String toString() {
        return "Name: " + name + ", course: " + course;
    }
}
