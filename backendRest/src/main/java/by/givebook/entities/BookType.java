package by.givebook.entities;

import by.givebook.entities.superEntity.DictionaryEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "book_type")
public class BookType extends DictionaryEntity {
}
