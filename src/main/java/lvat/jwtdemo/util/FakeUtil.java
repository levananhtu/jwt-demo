package lvat.jwtdemo.util;

import lvat.jwtdemo.model.News;

import java.util.ArrayList;
import java.util.List;

public class FakeUtil {
    public static List<News> getFakeNews() {
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("26/11", "mua", "lvat"));
        newsList.add(new News("25/11", "mua", "levananhtu"));
        newsList.add(new News("26/11", "bao", "thang nao day"));
        return newsList;

    }
}
