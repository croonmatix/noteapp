package com.example.noteapp.service;

import com.example.noteapp.entity.Tag;
import com.example.noteapp.entity.User;
import com.example.noteapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag); // Guarda la etiqueta en la base de datos
    }

    public List<Tag> getTagsByUser(User user) {
        return tagRepository.findByUser(user);
    }

    public Tag getTagByNameAndUser(String name, User user) {
        return tagRepository.findByNameAndUser(name, user);
    }
}