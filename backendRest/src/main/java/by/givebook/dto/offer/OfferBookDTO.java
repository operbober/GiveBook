package by.givebook.dto.offer;

import by.givebook.entities.library.Work;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.BookCondition;
import by.givebook.entities.offer.BookType;
import by.givebook.entities.offer.BookLanguage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 09.03.2016
 */
public class OfferBookDTO {

    private BookType bookType;
    private BookCondition bookCondition;
    private BookLanguage bookLanguage;

    private List<WorkDTO> workListDTO;

    public Book toBook(){
        List<Work> works = null;
        if (workListDTO != null) {
            works = workListDTO.stream().map(WorkDTO::toWork).collect(Collectors.toList());
        }
        return new Book(works, bookLanguage, bookType, bookCondition);
    }

    public BookType getBookType() {
        return bookType;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public List<WorkDTO> getWorkListDTO() {
        return workListDTO;
    }
}
