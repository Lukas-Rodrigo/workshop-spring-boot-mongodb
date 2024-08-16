package com.lucasteixeira.workshopmongodb.config;

import com.lucasteixeira.workshopmongodb.domain.Post;
import com.lucasteixeira.workshopmongodb.domain.User;
import com.lucasteixeira.workshopmongodb.dto.AuthorDTO;
import com.lucasteixeira.workshopmongodb.repositories.PostRepository;
import com.lucasteixeira.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post pos1 = new Post(null, LocalDate.now(), "Partiu viagem", "Vou viajar para São paulo, abraços", new AuthorDTO(maria));
        Post pos2 = new Post(null, LocalDate.now(), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(pos1, pos2));
        maria.getPosts().addAll(Arrays.asList(pos1, pos2));
        userRepository.save(maria);
    }
}
