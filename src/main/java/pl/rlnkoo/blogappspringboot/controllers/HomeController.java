package pl.rlnkoo.blogappspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rlnkoo.blogappspringboot.models.Post;
import pl.rlnkoo.blogappspringboot.services.PostService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}