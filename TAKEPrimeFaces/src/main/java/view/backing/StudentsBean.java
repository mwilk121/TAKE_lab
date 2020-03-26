package view.backing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import view.backing.MyManagedBean;

/**
 *
 * @author mw121
 */
@Named(value = "studentsBean")
@RequestScoped
public class StudentsBean {

    private final int size = 4;
    private List<StudentsBean.Student> students;

    private final static String[] names;
    private final static String[] lastNames;
    private final static String[] grades;

    static {
        final int size1 = 4;
        names = new String[size1];
        names[0] = "Ada";
        names[1] = "Maria";
        names[2] = "Pierre";
        names[3] = "Fryderyk";

        lastNames = new String[size1];
        lastNames[0] = "Lovelace";
        lastNames[1] = "Sklodowska";
        lastNames[2] = "Curie";
        lastNames[3] = "Chopin";

        grades = new String[size1];
        grades[0] = "4.95";
        grades[1] = "4.70";
        grades[2] = "4.64";
        grades[3] = "4.22";

    }

    public class Student {

        public String name, lastName, grade;

        public Student(String _name, String _lastName, String _grade) {
            name = _name;
            lastName = _lastName;
            grade = _grade;
            //grade = String.format("%.2f", 4.0 + (5.0 - 4.0) * rand.nextDouble()); //everyone is very smart
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @return the grade
         */
        public String getGrade() {
            return grade;
        }
    }

    /**
     * Creates a new instance of StudentsBean
     */
    public StudentsBean() {
        students = generateStudents();
    }

    public List<Student> generateStudents() {
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < size; i++) {
            students.add(new Student(names[i], lastNames[i], grades[i]));
            //students.add(generateStudent());
        }
        return students;
    }

    /*public Student generateStudent() {
        String name = names[rand.nextInt(size)];
        String lastName = lastNames[rand.nextInt(size)];
        return new Student(name, lastName);
    }*/
    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

}
