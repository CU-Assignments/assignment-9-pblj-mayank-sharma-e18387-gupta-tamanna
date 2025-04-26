package easy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Spring Framework", 3);
    }

    @Bean
    public Student student() {
        Student student = new Student(course());
        student.setName("John Doe");
        return student;
    }
}