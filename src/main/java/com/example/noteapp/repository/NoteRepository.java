package com.example.noteapp.repository;

import com.example.noteapp.entity.Note;
import com.example.noteapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
    List<Note> findByTitleContainingOrContentContaining(String title, String content);
}