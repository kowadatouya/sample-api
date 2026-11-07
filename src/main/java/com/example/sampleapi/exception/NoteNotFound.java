package com.example.sampleapi.exception;

public class NoteNotFound extends RuntimeException {
    public NoteNotFound(long id) {
        super("指定されたIDのノートが見つかりません: " + id);
    }
}