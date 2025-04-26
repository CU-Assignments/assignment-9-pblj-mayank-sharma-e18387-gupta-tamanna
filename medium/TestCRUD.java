package medium;

public class TestCRUD {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        // Create
        Student student = new Student();
        student.setName("Alice");
        student.setAge(22);
        dao.saveStudent(student);

        // Read
        Student s = dao.getStudent(student.getId());
        System.out.println("Student: " + s.getName());

        // Update
        s.setAge(23);
        dao.updateStudent(s);

        // Delete
        dao.deleteStudent(s.getId());
    }
}