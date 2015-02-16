package edu.csupomona.cs480.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.Movie;
import edu.csupomona.cs480.util.ResourceResolver;

public class LocalMovieManager implements MovieManager {

    private static final ObjectMapper JSON = new ObjectMapper();

    public LocalMovieManager() {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Document doc;
                try {
                    // need http protocol
                    doc = Jsoup.connect("http://www.amazon.com/s/ref=sr_nr_p_n_format_browse-bi_mrr_0?sf=qz&fst=as%3Aoff&rh=n%3A2625373011%2Ck%3Amovies%2Cp_n_format_browse-bin%3A2650306011&keywords=movies&ie=UTF8&qid=1423252689&rnid=2650303011").get();

                    // get page title
                    String title = doc.title();
                    System.out.println("title : " + title);

                    Set<Movie> titles = new HashSet<Movie>();

                    // get all links
                    boolean isPriceReady  = false;
                    Elements links = doc.select("h2.a-size-medium.s-inline.s-access-title.a-text-normal");
                    List<String> imgUrls = new ArrayList<String>();
                    Elements imgs = doc.select("img");
                    for (Element img : imgs) {
                        if (img.attr("alt").equals("Product Details")) {

                            imgUrls.add(img.absUrl("src"));
                        }
                    }

                    int index = 0;
                    for (Element link : links) {
                        System.out.println("text : " + link.text());
                        Movie m = new Movie();
                        m.setName(link.text());
                        m.setImgUrl(imgUrls.get(index));
                        m.setProvider("Amazon Instance Video");
                        titles.add(m);
                        index++;
                    }

                    // save to the file
                    JSON.writeValue(ResourceResolver.getMovieFile(),
                            titles);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }}, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public List<Movie> searchMovies(String keyword) {
        // load the movies from the file
        Set<Movie> movies = new HashSet<Movie>();
        try {
            movies = JSON.readValue(ResourceResolver.getMovieFile(),
                    new TypeReference<Set<Movie>>() {});
            System.out.println(movies);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // search
        List<Movie> res = new ArrayList<Movie>();
        for(Movie m : movies) {
            System.out.println(m.getName() + " " + keyword);
            if (m.getName().toLowerCase().contains(keyword.toLowerCase())) {
                res.add(m);
            }
        }

        return res;
    }

}
