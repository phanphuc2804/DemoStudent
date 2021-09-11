package repository;

import entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    //save


//    private void insertStudent( StudentRepository repository) {
//        Student student= Student.builder()
//                .fistName("Phan")
//                .lastName("Phuc")
//                .email("phanphuc@gmail.com")
//                .build();
//        repository.save(student);
//    }
//
//    @Bean
//    public CommandLineRunner run(StudentRepository repository) {
//        return (args -> {
//            insertStudent(repository);
//            System.out.println(repository.findAll());
//        });
//    }

    //read
    //CRUD
    public List<Student>findStudentByLastName(String lastName);
    public List<Student>findAll();
    public Student findStudentByEmail(String email);

    //JPQL
    @Query("select s from Student s where s.lastName= ?1")
    public Student findStudentByLastNameJPQL(String lastName);

    @Query("select s from Student s where s.lastName= ?1 and s.email= ?2")
    public Student findStudentByLastNameAndEmailJPQL(String lastName, String email);

    //Native
    @Query(value = "select s from Student s where s.StudentID=?1", nativeQuery = true)
    public Student findStudentByIDNative(Long id);

    @Query(value = "select s from Student s", nativeQuery = true)
    public List<Student> findAllStudent();


    //update
    //CRUD

    //JPQL
    @Transactional
    @Modifying
    @Query("update Student s set s.fistName= ?2 where s.StudentID = ?1")
    public void updateById(Long id, String firstName);

    //delete
    //CRUD

    //JPQL
    @Transactional
    @Modifying
    @Query("delete from Student s  where s.StudentID = ?1")
    public void deleteStudentById(Long id);


    @Transactional
    @Modifying
    @Query("delete from Student s  where s.email = ?1")
    public void deleteStudentByEmail(String email);

}
