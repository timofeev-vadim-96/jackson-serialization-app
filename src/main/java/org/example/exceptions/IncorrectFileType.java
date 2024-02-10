package org.example.exceptions;

import java.io.IOException;

public class IncorrectFileType extends IOException {
    public IncorrectFileType() {
        super("Unexpected file type");
    }
}
