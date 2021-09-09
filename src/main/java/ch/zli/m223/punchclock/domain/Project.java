package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = false, name = "description")
    private String description;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<Ticket> ticket;

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

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }
}
