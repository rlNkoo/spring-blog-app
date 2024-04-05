package pl.rlnkoo.blogappspringboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.rlnkoo.blogappspringboot.models.Post;
import pl.rlnkoo.blogappspringboot.services.PostService;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();
        if (posts.size() == 0) {

            Post post1 = new Post();
            post1.setTitle("Title of post 1");
            post1.setBody("This is a body of post 1");

            Post post2 = new Post();
            post2.setTitle("Title of post 2");
            post2.setBody("This is a body of post 2");

            postService.save(post1);
            postService.save(post2);
        }

    }
}
