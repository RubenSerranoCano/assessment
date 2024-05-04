package com.rserrano.assessment.infrastructure.h2db;

import com.rserrano.assessment.domain.model.Price;
import com.rserrano.assessment.domain.repository.PriceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepositoryH2Db implements PriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Price> findPriceByDateTimeAndProductIdAndBrandId(
            LocalDateTime desiredDateTime,
            Long productId, Long brandId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Price> query = builder.createQuery(Price.class);
        Root<Price> price = query.from(Price.class);

        Predicate dateInRange =
                builder.between(
                        builder.literal(desiredDateTime),
                        price.get("startDateTime"),
                        price.get("endDateTime")
                );
        Predicate productMatch = builder.equal(price.get("product").get("id"), productId);
        Predicate brandMatch = builder.equal(price.get("brand").get("id"), brandId);

        query.where(builder.and(dateInRange, productMatch, brandMatch));
        query.orderBy(builder.desc(price.get("priority")));

        return entityManager.createQuery(query).getResultList().stream().findFirst();
    }
}
