package pl.rlnkoo.blogappspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.rlnkoo.blogappspringboot.models.Post;
import pl.rlnkoo.blogappspringboot.services.PostService;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        // Find the post by id
        Optional<Post> optionalPost = postService.getById(id);
        // If the post exists, then shove it into the model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }

    }
}
