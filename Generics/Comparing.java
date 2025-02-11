
package Generics;

import java.util.Arrays;
import java.util.Comparator;

public class Comparing {
    static class Student implements Comparable<Student> {
        int rollNo;
        float marks;

        Student(int rollNo, float marks) {
            this.marks = marks;
            this.rollNo = rollNo;
        }

        @Override
        public int compareTo(Student o) {
            return (int) (this.marks - o.marks);
        }

        @Override
        public String toString() {
            return rollNo + "";
        }
    }

    public static void main(String[] args) {
        Student pankaj = new Student(2, 85.5f);
        Student nirmal = new Student(25, 93.5f);
        Student Monika = new Student(1, 99.5f);
        Student Kunal = new Student(5, 97.5f);
        Student Hiren = new Student(6, 98.5f);

        Student[] list = { pankaj, Monika, nirmal, Kunal, Hiren };
        System.out.println(Arrays.toString(list));
        // Arrays.sort(list);
        // Arrays.sort(list, new Comparator<Student>() {
        //     @Override
        //     public int compare(Student o1, Student o2) {
        //         return o1.rollNo - o2.rollNo;
        //     }
        // });

        Arrays.sort(list , (s1 , s2) -> s1.rollNo - s2.rollNo);
        System.out.println(Arrays.toString(list));


        
        // if (pankaj.compareTo(nirmal) < 0) {
        // System.out.println("nirmal has more score");
        // }
    }
}
