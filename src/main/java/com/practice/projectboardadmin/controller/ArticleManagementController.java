package com.practice.projectboardadmin.controller;

import com.practice.projectboardadmin.dto.response.ArticleResponse;
import com.practice.projectboardadmin.service.ArticleManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/management/articles")
@Controller
public class ArticleManagementController {

    private final ArticleManagementService articleManagementService;

    @GetMapping
    public String articles(Model model) {
        model.addAttribute(
                "articles",
                articleManagementService.getArticles().stream().map(ArticleResponse::withoutContent).toList()
        );

        return "management/articles";
    }

    @ResponseBody
    @GetMapping("/{articleId}")
    public ArticleResponse article(@PathVariable Long articleId) {
        return ArticleResponse.withContent(articleManagementService.getArticle(articleId));
    }

    @PostMapping("/{articleId}")
    public String deleteArticle(@PathVariable Long articleId) {
        articleManagementService.deleteArticle(articleId);

        return "redirect:/management/articles";
    }

}