package com.java.springboot.sms.repo;

import com.java.springboot.sms.dao.CricketerEntityDAO;
import com.java.springboot.sms.entity.Cricketer;
import com.java.springboot.sms.entity.CricketerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaCricketerDAO implements CricketerEntityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CricketerEntity save(CricketerEntity cricketer) {
        entityManager.persist(cricketer);
        return cricketer;
    }

    @Override
    public Optional<CricketerEntity> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(CricketerEntity.class, id));
    }

    @Override
    public List<CricketerEntity> findAll() {
        return entityManager
                .createQuery("select c from CricketerEntity c", CricketerEntity.class)
                .getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("select count(c.id) from CricketerEntity c", Long.class).getSingleResult();
    }

    @Override
    public void delete(CricketerEntity cricketer) {
        System.out.println("Inside Delete Method");
        System.out.println(cricketer);
        entityManager.remove(entityManager.contains(cricketer) ? cricketer : entityManager.merge(cricketer));
    }

    @Override
    public void deleteById(Integer id) {
        Optional<CricketerEntity> cricketer = Optional.ofNullable(
                entityManager.find(CricketerEntity.class, id)
        );

        cricketer.ifPresent(cricketerEntity -> entityManager.remove(cricketerEntity));
    }

    @Override
    public boolean existsById(Integer id) {
        Long count = entityManager
                .createQuery("select count(c.id) from CricketerEntity c where c.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();

        System.out.println("COUNT :: " + count);

        return count > 0;
    }
}
