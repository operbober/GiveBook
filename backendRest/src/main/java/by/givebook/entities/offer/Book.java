package by.givebook.entities.offer;

import by.givebook.entities.library.Work;
import by.givebook.entities.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
@Entity
@Table
public class Book extends IdEntity {
    @ManyToOne
    @JoinColumn(name = "work_id")
    public Work work;

    @ManyToOne
    @JoinColumn(name = "language_id")
    public Language language;

    @ManyToOne
    @JoinColumn(name = "book_type_id")
    public BookType bookType;

    @ManyToOne
    @JoinColumn(name = "book_condition_id")
    public BookCondition bookCondition;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    public List<Offer> offers;
}
