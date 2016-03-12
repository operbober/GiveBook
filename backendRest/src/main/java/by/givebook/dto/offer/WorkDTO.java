package by.givebook.dto.offer;

import java.util.List;

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
}
