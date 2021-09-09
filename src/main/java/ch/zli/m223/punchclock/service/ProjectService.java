package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProjectService {
    @Inject
    private EntityManager entityManager;

    public ProjectService() {
    }

    @Transactional
    public Project createProject(Project project) {
        entityManager.persist(project);
        return project;
    }

    @Transactional
    public void delete(long id) {
        entityManager.remove(entityManager.find(Project.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        var query = entityManager.createQuery("FROM Project");
        return query.getResultList();
    }

    @Transactional
    public void update(Project project) {
        entityManager.merge(project);
    }
}
