package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    public EntryService() {
    }

    @Transactional 
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    @Transactional
    public void delete(long id) {
        entityManager.remove(entityManager.find(Entry.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry");
        return query.getResultList();
    }

    @Transactional
    public void update(Entry entry) {
        entityManager.merge(entry);
    }
}
