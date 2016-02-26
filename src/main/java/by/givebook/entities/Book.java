package by.givebook.entities;

import javax.persistence.*;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 26.02.2016
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

}
