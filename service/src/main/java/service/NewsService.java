package service;

import entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> findAll(){
        return newsRepository.findAll();
    }

    public News findNewsById(long id){
        return newsRepository.findById(id);
    }



    public News save(News news){
        return newsRepository.save(news);
    }

    public News update(News news, long id){
        News newsToBeUpdated = newsRepository.findById(id);

//        if (newsToBeUpdated == null){
//            throw new IllegalArgumentException();
//        }
        newsToBeUpdated.setText(news.getText());
        newsToBeUpdated.setTitle(news.getTitle());
        newsToBeUpdated.setAuthor(news.getAuthor());
        newsToBeUpdated.setAppId(news.getAppId());
        newsToBeUpdated.setCreateDate(news.getCreateDate());
        newsToBeUpdated.setUpdateDate(news.getUpdateDate());
        return newsRepository.save(news);
    }

    public void delete(long id){
        newsRepository.deleteById(id);
    }
}
