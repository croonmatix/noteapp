package com.example.noteapp.controller;

import com.example.noteapp.entity.Note;
import com.example.noteapp.entity.User;
import com.example.noteapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<String> createNote(@RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        System.out.println("Nota creada: " + createdNote.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Nota creada correctamente: " + createdNote.getTitle());
    }

    @GetMapping
    public List<Note> getNotes(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return noteService.getNotesByUser(user);
    }

    @GetMapping("/search")
    public List<Note> searchNotes(@RequestParam String query) {
        return noteService.searchNotes(query);
    }
}
