package com.survivingcodingbootcamp.blog.controller;



import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorageJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hashtags")
public class HashTagController {

    private HashTagStorage hashStorage;


    public HashTagController(HashTagStorage hashStorage) {
        this.hashStorage = hashStorage;
    }

    @GetMapping("/{id}")
    public String displaySingleHashTags(@PathVariable long id, Model model) {
        model.addAttribute("hashtags", hashStorage.retrieveHashTagById(id));
        return "single-hashTag-Template";
    }

    @GetMapping
    public String displayAllHashtags(Model model) {
        model.addAttribute("hashtags", hashStorage.retrieveAllHashTags());
        return "hashTag-template";
    }

    @PostMapping("/hashtags/{postId}")
    public String addHashtags(){
    }
}
