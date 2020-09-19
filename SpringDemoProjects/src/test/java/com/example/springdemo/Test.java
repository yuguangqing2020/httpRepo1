package com.example.springdemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Key;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class Test {

    enum Week{
        one,
        two,
        three,
        four
    }

    public static void main(String[] args) throws Exception {
//        TreeMap<String,Integer> treeMap = new TreeMap<>();
//        treeMap.put("aa",1234);
//        treeMap.put("ee",1243);
//        treeMap.put("tt",1263);
//        treeMap.put("a45",1243);
//        treeMap.put("abc",123);
//        treeMap.forEach((k,v) -> System.out.println(k+"--"+v));
//        LinkedHashMap<String,Integer> linkedMap = new LinkedHashMap<>();
//        linkedMap.put("aa",1234);
//        linkedMap.put("ee",1243);
//        linkedMap.put("tt",1263);
//        linkedMap.put("a45",1243);
//        linkedMap.put("abc",123);
//        linkedMap.forEach((k,v) -> System.out.println(k+"--"+v));
//        System.out.println("_______");
//        ConcurrentHashMap<String,Integer> con = new ConcurrentHashMap<>();
//        con.put("aa",1234);
//        con.put("ee",1243);
//        con.put("tt",1263);
//        con.put("a45",1243);
//        con.put("abc",123);
//        con.forEach((k,v) -> System.out.println(k+"--"+v));

//        Stack stack = new Stack();
//        stack.push(12);
//        stack.push("yy");
//        stack.push(false);
//        stack.push('a');
//        stack.forEach(o -> System.out.println(o));
//        System.out.println(stack.peek());
//        System.out.println(stack.size());
//        IdentityHashMap identityHashMap = new IdentityHashMap<String ,Integer>();
//        identityHashMap.put(new String("A"), 1);
//        identityHashMap.put(new String("B"), 2);
//        identityHashMap.put(new String("A"), 3);
//        System.out.println(identityHashMap);
//        System.out.println(identityHashMap.size());
        PriorityBlockingQueue<Student> queue = new PriorityBlockingQueue<>();
        queue.add(new Student("甲同学",79.6));
        queue.add(new Student("乙同学",76.6));
        queue.add(new Student("丙同学",77.6));
        queue.add(new Student("丁同学",71.6));
        System.out.println(queue.peek().getName());
        queue.forEach(s -> System.out.println(s.getName()+"---"+s.getScore()));
        System.out.println(queue.poll().getName());
        System.out.println(queue.size());

//        Set set = new HashSet<Student>();
//        Student student1 = new Student("qq1",56.99);
//        Student student2 = new Student("qq2",56.98);
//        Student student3 = new Student("qq3",56.97);
//        set.add(student1);
//        set.add(student2);
//        set.add(student3);
//        System.out.println(set.size());
//        set.forEach(s -> System.out.println(s.toString()));
//        student3.setName("qq4");
//        set.remove(student3);
//        System.out.println(set.size());
//        set.forEach(s -> System.out.println(s.toString()));
//        set.add(student3);
//        System.out.println(set.size());
//        set.forEach(s -> System.out.println(s.toString()));

        final HashMap hashMap = new HashMap<String,String>(1);
        hashMap.put("a","a1");
        hashMap.putIfAbsent("b","b1");
        hashMap.putIfAbsent("c","c1");
        System.out.println(hashMap.hashCode());
        hashMap.forEach((k,v)-> System.out.println(k+"---"+v));




    }

}

class Student implements Comparable<Student> {
    String name;
    double score;

    public Student(String name,double score){
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore() - this.getScore() > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "名字：" + this.getName() + "--分数：" + this.getScore();
    }
}

class StudentComp implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return (o2.getScore() - o1.getScore()) > 0 ? 1 : -1;
    }
}