package fifth.lesson.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class StudentDAO {

    SessionFactory sessionFactory;

    public StudentDAO() {
        sessionFactory = SessionFactoryGetter.getSessionFactory();
    }
// добавление
    public Student save (Student student){
        Session session = sessionFactory.openSession();
        int id = (int) session.save(student);
        session.close();
        return new Student(id, student.getName(), student.getMark());
    }
// удаление
    public void remove (Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.remove(student);
        session.flush();
        transaction.commit();
        session.close();
    }
// изменение
    public void update (Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(student);
        session.flush();
        transaction.commit();
        session.close();
    }
// выборка записи по ID
    public Optional<Student> findById (int id){
        Session session = sessionFactory.openSession();
        Student student = session.find(Student.class, id);
        session.close();
        return Optional.ofNullable(student);
    }
// Выборка всех записей
    public List<Student> findAll(){
        Session session = sessionFactory.openSession();
        List<Student> students = (List<Student>) session.createQuery("from Student").list();
        session.close();
        return students;
    }
}
