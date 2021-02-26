package seventh.lesson.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seventh.lesson.homework.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findOneById(Integer id);

    Student findOneByName(String name);

}
