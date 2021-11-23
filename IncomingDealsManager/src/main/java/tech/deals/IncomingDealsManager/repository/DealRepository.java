package tech.deals.IncomingDealsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.deals.IncomingDealsManager.model.Deal;

import java.util.Optional;

public interface DealRepository extends JpaRepository<Deal,Long> {
    void deleteDealById(Long dealId);

    Optional<Deal> findDealById(Long dealId);
}
