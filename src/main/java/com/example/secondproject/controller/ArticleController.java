

package com.example.secondproject.controller;

import com.example.secondproject.dto.ArticleForm;
import com.example.secondproject.entity.Article;
import com.example.secondproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleController() {
    }

    @GetMapping({"/articles/new"})
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping({"/articles/create"})
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        Article article = form.toEntity();
        log.info(article.toString());
        Article saved = (Article)this.articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
    @GetMapping({"/articles/{id}"})
    public String show(@PathVariable Long id, Model model){ //URL 'id' 부분을 Long 타입의 'id' 변수에 할당
        log.info ("id = " + id);
        //1. id를 조회해서 데이터 가져오기 (데이터가 없으면 .orElse(null))
        Article articleEntity = articleRepository.findById(id).orElse(null); //id 값으로 데이터를 찾아 반환
        //2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll(); //(List<Article>) 형변환
        //2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        //3. 뷰 페이지 설정하기
        return "articles/index";
    }

}
