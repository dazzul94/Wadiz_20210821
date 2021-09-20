package Hc;

import java.util.stream.*;
import java.util.*;

public class Test3
{
    public static class Student {
        private String name;
        private int score;
        
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int getScore() {
            return score;
        }
        
        public String getName() {
            return name;
        }
    }
    
    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
    	List<String> names = new ArrayList<String>();
    	
    	final Comparator<Student> comp = (p1, p2) -> Integer.compare( p2.getScore(), p1.getScore());
    	
    	students.sorted(comp).forEach(item->{
    		if(item.getScore() >= passingScore) {
    			names.add(item.getName());
    		}
    	});
		return names;
    }
    
    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);
    }
}