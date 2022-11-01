package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.StudentNotExistException;
import ru.hogwarts.school.models.Student;

import java.util.*;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();

    private Long numberId = 0l;

    public Student create(String name, int age) {
        Student student = new Student(numberId, name, age);
        students.put(numberId, student);
        numberId++;
        return student;
    }

    public Student read(Long id) {
        existValidator(id);
        Student student = students.get(id);
        return student;
    }

    public Student update(Long id, String name, int age) {
        Student student = new Student(id, name, age);
        existValidator(id);
        students.put(id, student);
        return student;
    }

    public Student delete(Long id) {
        existValidator(id);
        Student student = students.get(id);
        students.remove(id);
        return student;
    }

    public Collection<Student> filterByAge(int age) {
        List<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
    private void existValidator(Long id) {
        if (!students.containsKey(id)) {
            throw new StudentNotExistException();
        }
    }
}
