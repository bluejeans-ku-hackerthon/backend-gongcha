package com.bluejeans.backend.repo;

import com.bluejeans.backend.domain.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InsuranceRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Insurance insurance) { em.persist(insurance); }

    public Insurance findOne(Long id) {
        return em.find(Insurance.class, id);
    }

    public List<Insurance> findAll() {
        return em.createQuery("select i from Insurance i", Insurance.class)
                .getResultList();
    }

}
