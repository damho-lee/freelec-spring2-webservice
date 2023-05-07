package com.damo.book.springboot.web.dto;

import com.damo.book.springboot.config.auth.LoginUser;
import com.damo.book.springboot.config.auth.dto.SessionUser;
import com.damo.book.springboot.domain.posts.Posts;
import com.damo.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    //private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null) {
            model.addAttribute("loginUserName", user.getName());
        }
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    @GetMapping("/posts/search")
    public String search(String keyword, Model model) {
        List<Posts> searchList = postsService.search(keyword);

        model.addAttribute("searchList", searchList);

        return "posts-search";
    }
    @GetMapping
    public String getLoginPage(Model model, @LoginUser SessionUser user) throws Exception {
        return "oauth/login";
    }
}
