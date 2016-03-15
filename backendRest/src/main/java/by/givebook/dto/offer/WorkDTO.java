package by.givebook.dto.offer;

import by.givebook.entities.library.Author;
import by.givebook.entities.library.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 12.03.2016
 */
public class WorkDTO {
    private List<AuthorDTO> authorListDTO;

    private String workTitle;

    public List<AuthorDTO> getAuthorListDTO() {
        return authorListDTO;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public Work toWork(){
        List<Author> authors = null;
        if (authorListDTO != null) {
            authors = authorListDTO.stream().map(AuthorDTO::toAuthor).collect(Collectors.toList());
        }
        return new Work(workTitle, authors, null);
    }
}
