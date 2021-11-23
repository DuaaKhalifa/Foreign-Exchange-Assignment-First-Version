package tech.deals.IncomingDealsManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.deals.IncomingDealsManager.model.Deal;
import tech.deals.IncomingDealsManager.service.DealService;

import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealResource {
    private final DealService service;

    public DealResource(DealService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Deal>> getAllDeals(){
        List<Deal> deals = service.findAllDeals();
        return new ResponseEntity<>(deals, HttpStatus.OK);
    }
    @GetMapping("/find/{Id}")
    public ResponseEntity<Deal> getDeal(@PathVariable("id") Long id){
        Deal deal = service.findDealById(id);
        return new ResponseEntity<>(deal, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Deal> addDeal(@RequestBody Deal deal){
        Deal newDeal = service.AddDeal(deal);
        return new ResponseEntity<>(newDeal, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Deal> updateDeal(@RequestBody Deal deal){
        Deal updatedDeal = service.updateDeal(deal);
        return new ResponseEntity<>(updatedDeal, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDeal(@PathVariable("id") Long id){
        service.deleteDeal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
