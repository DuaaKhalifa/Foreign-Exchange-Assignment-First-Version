package tech.deals.IncomingDealsManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.deals.IncomingDealsManager.exception.DealNotFoundException;
import tech.deals.IncomingDealsManager.model.Deal;
import tech.deals.IncomingDealsManager.repository.DealRepository;

import java.util.List;

@Service
public class DealService {
    private final DealRepository dealRepository;
    @Autowired
    public DealService(DealRepository dealRepo){
        this.dealRepository = dealRepo;
    }

    public Deal AddDeal(Deal deal){
        //PreProcessYourDeal
        return dealRepository.save(deal);
    }
    public List<Deal> findAllDeals(){
        return dealRepository.findAll();
    }
    public Deal updateDeal(Deal deal){
        return dealRepository.save(deal);
    }
    public Deal findDealById(Long dealId){
        return dealRepository.findDealById(dealId).orElseThrow(()-> new DealNotFoundException("Deal with id "+dealId+ " was not found"));
    }
    public void deleteDeal(Long dealId){
        dealRepository.deleteDealById(dealId);
    }
}
