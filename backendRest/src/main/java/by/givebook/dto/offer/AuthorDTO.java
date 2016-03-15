package by.givebook.dto.offer;

import by.givebook.entities.library.Author;

/**
 * Created by operb_000 on 10.03.2016.
 */
public class AuthorDTO {
    private String lastName;
    private String firstName;
    private String middleName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Author toAuthor(){
        return new Author(lastName, firstName, middleName);
    }
}
