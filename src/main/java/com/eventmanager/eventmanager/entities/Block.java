package com.eventmanager.eventmanager.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_block")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant start_moment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant end_moment;
    @ManyToOne
    @JoinColumn(name= "activity_id")
    private Activity activity;

    public Block() {
    }

    public Block(Long id, Instant star, Instant end, Activity activity) {
        this.id = id;
        this.start_moment = star;
        this.end_moment = end;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStart_moment() {
        return start_moment;
    }

    public void setStart_moment(Instant start_moment) {
        this.start_moment = start_moment;
    }

    public Instant getEnd_moment() {
        return end_moment;
    }

    public void setEnd_moment(Instant end_moment) {
        this.end_moment = end_moment;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        return Objects.equals(id, block.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
