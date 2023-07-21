package class04;

import heap.IntensifyHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IntensifyHeapTest {


    public static class Student {
        public int age;
        public int id;

        public Student(int a, int i) {
            age = a;
            id = i;
        }

    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static void main(String[] args) {
        Student s1 = null;
        Student s2 = null;
        Student s3 = null;
        Student s4 = null;
        Student s5 = null;
        Student s6 = null;

        s1 = new Student( 50, 11111);
        s2 = new Student(60, 22222);
        s3 = new Student( 10, 33333);
        s4 = new Student( 20, 44444);
        s5 = new Student( 72, 55555);
        s6 = new Student( 14, 66666);

        PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);
        while (!heap.isEmpty()) {
            Student cur = heap.poll();
            System.out.println(cur.age + "," + cur.id);
        }

        System.out.println("===============");

        IntensifyHeap<Student> myHeap = new IntensifyHeap<>(new StudentComparator());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);
        while (!myHeap.isEmpty()) {
            Student cur = myHeap.pop();
            System.out.println(cur.age + "," + cur.id);
        }

        System.out.println("===============");

        s1 = new Student(50, 11111);
        s2 = new Student( 60, 22222);
        s3 = new Student( 10, 33333);
        s4 = new Student( 20, 44444);
        s5 = new Student( 72, 55555);
        s6 = new Student( 14, 66666);

        heap = new PriorityQueue<>(new StudentComparator());

        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);

        s2.age = 6;
        s4.age = 12;
        s5.age = 10;
        s6.age = 84;

        while (!heap.isEmpty()) {
            Student cur = heap.poll();
            System.out.println(cur.age + "," + cur.id);
        }

        System.out.println("===============");

        s1 = new Student(50, 11111);
        s2 = new Student( 60, 22222);
        s3 = new Student( 10, 33333);
        s4 = new Student( 20, 44444);
        s5 = new Student( 72, 55555);
        s6 = new Student( 14, 66666);

        myHeap = new IntensifyHeap<>(new StudentComparator());

        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);

        s2.age = 6;
        myHeap.resign(s2);
        s4.age = 12;
        myHeap.resign(s4);
        s5.age = 10;
        myHeap.resign(s5);
        s6.age = 84;
        myHeap.resign(s6);

        while (!myHeap.isEmpty()) {
            Student cur = myHeap.pop();
            System.out.println(cur.age + "," + cur.id);
        }


    }

}
