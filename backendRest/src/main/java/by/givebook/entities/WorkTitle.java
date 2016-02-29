package by.givebook.entities;

import by.givebook.entities.superEntity.DictionaryEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "work_title")
public class WorkTitle extends DictionaryEntity {
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
