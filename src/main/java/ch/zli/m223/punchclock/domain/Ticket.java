package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = false, name = "description")
    private String description;

    @OneToMany
    @JoinColumn(name = "entry_id")
    private List<Ticket> entry;

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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ticket> getEntry() {
        return entry;
    }

    public void setEntry(List<Ticket> entry) {
        this.entry = entry;
    }
}
