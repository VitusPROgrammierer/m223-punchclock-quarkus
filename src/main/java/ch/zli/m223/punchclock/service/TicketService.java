package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TicketService {
    @Inject
    private EntityManager entityManager;

    public TicketService() {
    }

    @Transactional
    public Ticket createTicket(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }

    @Transactional
    public void delete(long id) {
        entityManager.remove(entityManager.find(Ticket.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> findAll() {
        var query = entityManager.createQuery("FROM Ticket");
        return query.getResultList();
    }

    @Transactional
    public void update(Ticket ticket) {
        entityManager.merge(ticket);
    }
}
