package org.example;

import org.example.converter.Converter;
import org.example.model.Student;

import java.util.Arrays;

public class Main {

    public static final String FILE_JSON = "student.json";
    public static final String FILE_BIN = "student.bin";
    public static final String FILE_XML = "student.xml";

    public static void main(String[] args) {
        Converter converter = new Converter();
        Student student = new Student("Alan", 20, 5.0);

        String [] files = {FILE_BIN, FILE_JSON, FILE_XML};

        Arrays.stream(files).forEach(file -> converter.saveStudentToFile(file, student));

        Arrays.stream(files).forEach(file -> {
            System.out.printf("Returned from %s: %s\n", file, converter.loadStudentFromFile(file, Student.class));
        });
    }
}