package com.lucasteixeira.workshopmongodb.Services;

import com.lucasteixeira.workshopmongodb.Services.exception.ObjectNotFoundException;
import com.lucasteixeira.workshopmongodb.domain.Post;
import com.lucasteixeira.workshopmongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository PostRepository;

    public Post findById(String id) {
        return PostRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found with id" + id));
    }

    public List<Post> findByTitle(String text) {
        return PostRepository.findByTitleContainingIgnoreCase(text);
    }

}
