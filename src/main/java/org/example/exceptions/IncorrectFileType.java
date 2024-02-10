package org.example.exceptions;

import java.io.FileNotFoundException;

public class IncorrectFileType extends FileNotFoundException {
    public IncorrectFileType() {
        super("Unexpected file type");
    }
}
