package app.jdbcJPA.data.dao.impl;

import app.jdbcJPA.data.dao.StudentDAO;
import app.jdbcJPA.data.entities.Student;
import app.jdbcJPA.exceptions.IllegalEmailException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class StudentService implements StudentDAO {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Student addStudent(Student student) {
        em.persist(student);
        return student;
    }

//    @Override
//    public Student addStudent(Student student) {
//        try {
//            em.getTransaction().begin();
//            em.persist(student);
//            em.getTransaction().commit();
//            return student;
//
//        }
//        catch (Exception e) {
//            em.getTransaction().rollback();
//            return null;
//        }
//    }

    @Override
    @Transactional
    @Cacheable("customersCache")
    public Student getStudentById(Long id) {
        System.out.println(ANSI_PURPLE + "called CustomerService.getStudentById(" + id + ")" + ANSI_RESET);
        return em.find(Student.class, id);
    }

    @Override
    @Transactional
    @Cacheable("customersCache")
    public List<Student> getStudentsByName(String name) {
        System.out.println(ANSI_PURPLE +"called StudentService.getStudentsByName(" + name + ")" + ANSI_RESET);
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("fname", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    @Cacheable("customersCache")
    public List<Student> getStudents() {
        System.err.println(ANSI_PURPLE +"called StudentService.getStudents()"+ANSI_RESET);
        Query query = em.createNamedQuery("Student.findAll", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveStudent(final Student student) throws IllegalEmailException {
        if (!validateEmail(student.getEmail()))
            throw new IllegalEmailException("Email is not valid");
        em.merge(student);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
