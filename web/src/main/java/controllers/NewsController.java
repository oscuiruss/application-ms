package controllers;

import entity.News;
import news.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.NewsService;
import utils.Utility;

public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public NewsDto findNewsById(@PathVariable("id") long id) {
        return Utility.newsConvertToDto(newsService.findNewsById(id));
    }

    @PostMapping("/create")
    @ResponseBody
    public NewsDto create(@RequestBody NewsDto newsDto) {
        News news = Utility.dtoConverterToNews(newsDto);
        return Utility.newsConvertToDto(news);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public NewsDto update(@RequestBody NewsDto newsDto, @PathVariable("id") long id) {
        News news = Utility.dtoConverterToNews(newsDto);
        return Utility.newsConvertToDto(newsService.update(news, id));
    }

    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        newsService.delete(id);
    }
}
