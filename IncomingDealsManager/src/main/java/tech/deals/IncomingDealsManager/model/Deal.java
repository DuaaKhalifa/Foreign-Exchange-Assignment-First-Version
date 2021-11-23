package tech.deals.IncomingDealsManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Deal implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderingCurrency;
    private String toCurrency;
    private Double amount;
    private Date timeStamp;

    public Deal(){}

    public Deal(String orderingCurrency, String toCurrency, Double amount){
        this.orderingCurrency=orderingCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }

    public String getOrderingCurrency() {
        return orderingCurrency;
    }

    public void setOrderingCurrency(String orderingCurrency) {
        this.orderingCurrency = orderingCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
