package by.givebook.entities;

import javax.persistence.*;

/**
 * Created by operb_000 on 12.10.2015.
 */
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String langname;

    public Language(String langname) {
        this.langname = langname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLangname() {
        return langname;
    }

    public void setLangname(String langname) {
        this.langname = langname;
    }
}
