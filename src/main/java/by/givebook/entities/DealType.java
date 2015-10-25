package by.givebook.entities;

import javax.persistence.*;

/**
 * Created by operb_000 on 12.10.2015.
 */
@Entity
@Table(name = "anno_type")
public class DealType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;

    public DealType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
