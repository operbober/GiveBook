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
    public String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_authors",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns= @JoinColumn(name = "work_id"))
    public List<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns= @JoinColumn(name = "work_id"))
    public List<Genre> genres;
}
