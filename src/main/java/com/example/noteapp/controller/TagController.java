package com.example.noteapp.controller;

import com.example.noteapp.entity.Tag;
import com.example.noteapp.entity.User;
import com.example.noteapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<String> createTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.createTag(tag);
        System.out.println("Etiqueta creada: " + createdTag.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Etiqueta creada correctamente: " + createdTag.getName());
    }

    @GetMapping
    public List<Tag> getTags(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return tagService.getTagsByUser(user);
    }
}