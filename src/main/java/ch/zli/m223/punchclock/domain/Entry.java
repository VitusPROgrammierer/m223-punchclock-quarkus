package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Entry")
public class Entry {

    @Id
    @Column(name = "entry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "checkIn")
    private LocalDateTime checkIn;

    @Column(nullable = false, name = "checkOut")
    private LocalDateTime checkOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}