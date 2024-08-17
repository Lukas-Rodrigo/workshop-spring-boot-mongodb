package com.lucasteixeira.workshopmongodb.resources;

import com.lucasteixeira.workshopmongodb.Services.PostService;
import com.lucasteixeira.workshopmongodb.domain.Post;
import com.lucasteixeira.workshopmongodb.resources.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService PostService;


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(PostService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(PostService.findByTitle(text));
    }


}
