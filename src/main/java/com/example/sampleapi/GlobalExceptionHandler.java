package com.example.sampleapi;

import com.example.sampleapi.exception.NoteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(NoteNotFound e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus)
        return ResponseEntity.notFound().build();
    }


    public ResponseEntity<String>handleNoteArgumentNotValidException(NoteNotFound e){
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        noteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
