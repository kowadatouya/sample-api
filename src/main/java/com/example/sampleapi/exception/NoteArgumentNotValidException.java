package com.example.sampleapi.exception;

import com.example.sampleapi.dto.Note;

public class NoteArgumentNotValidException extends RuntimeException {
    public NoteArgumentNotValidException(String message) {
        super(message);
    }

}
