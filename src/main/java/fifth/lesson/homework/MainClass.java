package fifth.lesson.homework;

import java.util.List;
import java.util.Random;

public class MainClass {

    private static List<Student> students;
    private static StudentDAO studentDAO;
    private static final int STUDENTS_QUANTITY;

    static {
        STUDENTS_QUANTITY = 1_000;
    }

    private static void fillStudents(){
        Random random = new Random();
        for (int i = 1; i <= STUDENTS_QUANTITY; i++) {
            studentDAO.save(new Student(i, "Student " + i, random.nextInt(6)));
        }
    }

    private static void updateStudents(){
        students = studentDAO.findAll();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (i%2 != 0){
                student.setName("Student uneven " + i);
                studentDAO.update(student);
            }
        }
    }

    private static void removeStudents(){
        students = studentDAO.findAll();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (i%3 != 0){
                studentDAO.remove(student);
            }
        }
    }

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        fillStudents();
        updateStudents();
        removeStudents();

        Student st1 = new StudentDAO().findById(123).orElse(new Student(123, "Strange student", 3));
        System.out.println(st1.getId() + " " + st1.getName() + " " + st1.getMark());

        Student st2 = students.get(789);
        System.out.println(st2.getId() + " " + st2.getName() + " " + st2.getMark());

    }

}
