package com.example.sampleapi.service;

import com.example.sampleapi.dto.Note;
import com.example.sampleapi.exception.NoteArgumentNotValidException;
import com.example.sampleapi.exception.NoteNotFound;
import com.example.sampleapi.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository repository;
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository repository, NoteRepository noteRepository) {
        this.repository = repository;
        this.noteRepository = noteRepository;
    }
    public List<Note> findAll() {
        return repository.findAll();
    }

    public Note saveNote(Note note){
        noteRepository.insertNote(note);
        return note;
    }

    public Note findById(long id){
        return noteRepository.findById(id);
        if(note == null){
            throw new NoteNotFound(id);
        }
        return
    }

    public Note saveNot(Note note){
        if (note.getTitle() == null || note.getTitle().isEmpty()){
            throw new NoteArgumentNotValidException("title is empty");
        }
        if(note.getContent() == null || note.getContent().isEmpty()){
            throw new NoteArgumentNotValidException("content is empty");
        }
    }

    public boolean delete(long id){
        if (!noteRepository.delete(id)){
            throw new NoteNotFound(id);
        }
        return true;
    }

    @Transactional
    public Note update(Note note,long id){
        if (note.getTitle() == null || note.getTitle().isEmpty()){
            throw new NoteArgumentNotValidException("title is empty");
        }
        if(note.getContent() == null || note.getContent().isEmpty()){
            throw new NoteArgumentNotValidException("content is empty");
        }

        Note targetNote = noteRepository.findById(id);
        if (targetNote == null){
            throw new NoteNotFound(id);
        }

        note.setId(id);
        note.setCreatedAt(targetNote.getCreatedAt());
        return noteRepository.update(note);
    }
}
