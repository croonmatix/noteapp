package com.example.noteapp.repository;

import com.example.noteapp.entity.Tag;
import com.example.noteapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByUser(User user);
    Tag findByNameAndUser(String name, User user);
}