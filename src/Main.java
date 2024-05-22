import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<StudentCorrect, Integer> mapCorrect = new HashMap<>();

        StudentCorrect st1 = new StudentCorrect("Maryna", 2);
        StudentCorrect st2 = new StudentCorrect("Iryna", 1);
        StudentCorrect st3 = new StudentCorrect("Andriy", 4);

        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
        System.out.println(st3.hashCode());

        System.out.println(st1.equals(st2));
        System.out.println(st1.equals(st1));

        mapCorrect.put(st1, 1);
        mapCorrect.put(st2, 2);
        mapCorrect.put(st3, 3);

        for(Map.Entry<StudentCorrect, Integer> entry : mapCorrect.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        System.out.println(mapCorrect.get(st1));

        System.out.println();

        HashMap<StudentIncorrect, Integer> mapIncorrect = new HashMap<>();

        StudentIncorrect st4 = new StudentIncorrect("Roman", 3);
        StudentIncorrect st5 = new StudentIncorrect("Olga", 1);
        StudentIncorrect st6 = new StudentIncorrect("Anna", 2);

        System.out.println(st4.hashCode());
        System.out.println(st5.hashCode());
        System.out.println(st6.hashCode());
        System.out.println(st4.equals(st5));
        System.out.println(st6.equals(st6));

        mapIncorrect.put(st4, 1);
        mapIncorrect.put(st5, 2);
        mapIncorrect.put(st6, 3);

        for(Map.Entry<StudentIncorrect, Integer> entry : mapIncorrect.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        System.out.println(mapIncorrect.get(st6));
    }
}
