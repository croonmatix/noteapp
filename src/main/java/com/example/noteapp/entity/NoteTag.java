package com.example.noteapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "note_tags")
public class NoteTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}