package com.example.noteapp.service;

import com.example.noteapp.entity.Note;
import com.example.noteapp.entity.User;
import com.example.noteapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note); // Guarda la nota en la base de datos
    }

    public List<Note> getNotesByUser(User user) {
        return noteRepository.findByUser(user);
    }

    public List<Note> searchNotes(String query) {
        return noteRepository.findByTitleContainingOrContentContaining(query, query);
    }
}