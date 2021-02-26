package seventh.lesson.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seventh.lesson.homework.entity.Student;
import seventh.lesson.homework.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findOneById(id);
    }

    public Student findByName(String name) {
        return studentRepository.findOneByName(name);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void remove(Integer id) {
        studentRepository.deleteById(id);
    }
}
