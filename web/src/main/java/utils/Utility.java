package utils;

import entity.News;
import news.NewsDto;
import org.modelmapper.ModelMapper;

public class Utility {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static NewsDto newsConvertToDto(News news) {
        return modelMapper.map(news, NewsDto.class);
    }

    public static News dtoConverterToNews(NewsDto newsDto) {
        return modelMapper.map(newsDto, News.class);
    }

}
