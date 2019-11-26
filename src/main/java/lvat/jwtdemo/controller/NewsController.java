package lvat.jwtdemo.controller;

import lvat.jwtdemo.model.News;
import lvat.jwtdemo.util.FakeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @RequestMapping(path = "get-news", method = RequestMethod.GET)
    public List<News> getNews() {
        List<News> newsList = FakeUtil.getFakeNews();
        Collections.shuffle(newsList);
        return newsList;
    }
}
