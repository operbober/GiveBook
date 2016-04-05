package by.givebook.dto.security;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 04.04.2016
 */
public class TokenDTO {

    public TokenDTO(String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }
}
