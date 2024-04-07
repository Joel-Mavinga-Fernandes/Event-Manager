package com.eventmanager.eventmanager.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "tb_activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
    private Double price;
    @ManyToOne
    @JoinColumn(name= "category_id")
    private Category category;
    @ManyToMany(mappedBy = "activities")
    private Set<Participant> participants = new HashSet<>();
    @OneToMany(mappedBy = "activity")
    private Set<Block> blocks = new HashSet<>();

    public Activity() {
    }

    public Activity(Long id, String name, String description, Double price, Category category, Set<Participant> participants, Set<Block> blocks) {
        this.id = id;
        this.name = name;
        Description = description;
        this.price = price;
        this.category = category;
        this.participants = participants;
        this.blocks = blocks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Block> getBlocks() {
        return blocks;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        return Objects.equals(id, activity.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
