package by.givebook.entities;

import by.givebook.entities.superEntity.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "work")
public class Work extends IdEntity {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<WorkTitle> titles;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_authors",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns= @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_genres")
    private List<Genre> genres;

    @JsonIgnore
    @OneToMany(mappedBy = "work", fetch = FetchType.LAZY)
    private List<Book> books;

    public List<WorkTitle> getTitles() {
        return titles;
    }

    public void setTitles(List<WorkTitle> titles) {
        this.titles = titles;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
