package by.givebook.entities;

import javax.persistence.*;

/**
 * Created by operb_000 on 12.10.2015.
 */
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String genrename;


    public Genre(String genrename) {
        this.genrename = genrename;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenrename() {
        return genrename;
    }

    public void setGenrename(String genrename) {
        this.genrename = genrename;
    }
}
