package by.givebook.entities.library;

import by.givebook.entities.NamedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "work_title")
public class WorkTitle extends NamedEntity {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
