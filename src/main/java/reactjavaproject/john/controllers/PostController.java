package reactjavaproject.john.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactjavaproject.john.models.Data;
import reactjavaproject.john.services.DataService;  // Inject the interface


import java.util.List;

@RestController
@RequestMapping("/api/media")
public class PostController {

    @Autowired
    private DataService postService;  // Now inject the interface

    @GetMapping("/alldata")
    public List<Data> getAllData() {
        return postService.getAllData();
    }

    @GetMapping("/movies")
    public List<Data> getMovies() {
        return postService.getMovies();
    }

    @GetMapping("/series")
    public List<Data> getSeries() {
        return postService.getSeries();
    }

    @GetMapping("/item")
    public Data getItemById(@RequestParam String id) {
        return postService.getItemById(id);
    }

    @GetMapping("/genre")
    public List<Data> getItemsByGenre(@RequestParam List<String> genres) {
        return postService.getItemsByGenre(genres);
    }
}
