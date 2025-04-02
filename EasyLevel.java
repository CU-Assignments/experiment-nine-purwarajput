package com.example;

public class Course {
    private String courseName;
    private int duration; // in months

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void displayCourse() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months");
    }
}

package com.example;

public class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        course.displayCourse();
    }
}

package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course courseBean() {
        return new Course("Spring Framework", 3);
    }

    @Bean
    public Student studentBean() {
        return new Student("Purwa", courseBean());
    }
}

package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Student bean
        Student student = context.getBean(Student.class);

        // Display Student Information
        student.displayStudentInfo();
    }
}
