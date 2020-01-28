package com.java.spring.jdbc_to_jpa.dao;

import com.java.spring.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonEntity> findAll() {
        // Writing a simple JPQL - JAVA PERSISTENCE QUERY LANGUAGE
        return entityManager.createQuery("select p from PersonEntity p", PersonEntity.class).getResultList();
    }

    public List<PersonEntity> findAllUsingNamedQuery() {
        TypedQuery<PersonEntity> namedQuery = entityManager.createNamedQuery("find_all_persons_using_named_query", PersonEntity.class);
        return namedQuery.getResultList();
    }

    public PersonEntity findById(Integer id) {
        return entityManager.find(PersonEntity.class, id);
    }

    public PersonEntity update(PersonEntity personEntity) {
        return entityManager.merge(personEntity);
    }

    public PersonEntity insert(PersonEntity personEntity) {
        return entityManager.merge(personEntity);
    }

    public void delete(PersonEntity personEntity) {
        entityManager.remove(personEntity);
    }

    public void deleteById(Integer id) {
        PersonEntity personEntity = findById(id);
        entityManager.remove(personEntity);
    }
}
