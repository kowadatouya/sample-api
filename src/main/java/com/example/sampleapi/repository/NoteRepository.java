package com.example.sampleapi.repository;

import com.example.sampleapi.dto.Note;
import com.example.sampleapi.exception.NoteNotFound;
import com.example.sampleapi.mapper.NoteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository {
    private final NoteMapper notemapper;

    public NoteRepository(NoteMapper notemapper) {
        this.notemapper = notemapper;
    }

    public List<Note> findAll() {
        return notemapper.findAll();
    }

    public int insertNote(Note note){
        return notemapper.insert(note);
    }

//    public Note findById(long id){
//        return notemapper.findById(id);
//    }

    public boolean delete(long id){
        return notemapper.delete(id) == 1;
    }

    public Note update(Note note){
        if(notemapper.update(note) == 0){
//            throw new NoteNotFound(note.getId());
        }
        return note;
    }
}
