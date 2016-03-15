package by.givebook.entities.library;

import by.givebook.entities.IdEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "work")
public class Work extends IdEntity {

//    @OneToMany(targetEntity = WorkTitle.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    @JoinColumn(name = "work_id")
//    public List<WorkTitle> titles;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_authors",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns= @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_genres",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns= @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public Work() {}

    public Work(String name, List<Author> authors, List<Genre> genres) {
        this.name = name;
        this.authors = authors;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
