package org.example.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.exceptions.IncorrectFileType;
import org.example.model.Student;

import java.io.*;

/**
 * Класс для серриализации и дессериализации с использованием Jackson
 */
public class Converter {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    /**
     * Серриализация объекта в файл
     */
    public <T> void saveStudentToFile(String fileName, T object) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), object);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    outputStream.writeObject(object);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), object);
            }
            else throw new IncorrectFileType();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Дессериализация объекта из файла
     */
    public <T> T loadStudentFromFile(String fileName, Class<T> clazz) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    return objectMapper.readValue(file, clazz);
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                        return (T) inputStream.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    return xmlMapper.readValue(file, clazz);
                }
                else throw new IncorrectFileType();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
