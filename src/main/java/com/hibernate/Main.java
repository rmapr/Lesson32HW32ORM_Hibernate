package com.hibernate;

import com.hibernate.entity.Student;
import com.hibernate.entity.StudentService;
import com.hibernate.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate");
        StudentService studentService = new StudentServiceImpl();
        Student student1 = new Student("Rm", "rm@mail.com");
        Student student2 = new Student("Roman", "roman@mail.com");

        System.out.println("Add 1-st Student");
        studentService.create(student1);

        System.out.println("Add 2-nd Student");
        studentService.create(student2);

        System.out.println("View all Students");
        studentService.getAll().forEach(System.out::println);

        System.out.println("Update Student");
        student2.setEmail("Change email for Email@Email.com");
        student2.setName("Change name for Roman");
        System.out.println(studentService.update(student2));

        System.out.println("View Student in number 1");
        student1 = studentService.get(1L);
        if (student1 !=null) {
            System.out.println("Find: " + student1);
        }else {
            System.out.println("Student not found!");
        }
        System.out.println("Delete Student in number 1");
        studentService.delete(student1);
    }
}