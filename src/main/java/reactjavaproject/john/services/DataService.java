package reactjavaproject.john.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactjavaproject.john.models.Data;
import reactjavaproject.john.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    @Autowired
    private PostRepository repo;

    public List<Data> getAllData() {
        return repo.findAll();
    }

    public List<Data> getMovies() {
        return repo.findByCategory("movie");
    }

    public List<Data> getSeries() {
        return repo.findByCategory("series");
    }

    public Data getItemById(String id) {
        Optional<Data> result = repo.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Data not found with ID: " + id));
    }

    public List<Data> getItemsByGenre(List<String> genres) {
        List<Data> filteredItems = repo.findByGenreIn(genres);
        if (filteredItems.isEmpty()) {
            throw new RuntimeException("No items found for genres: " + String.join(", ", genres));
        }
        return filteredItems;
    }
}
