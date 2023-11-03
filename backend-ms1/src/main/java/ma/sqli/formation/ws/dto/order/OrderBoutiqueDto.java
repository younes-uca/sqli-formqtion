package  ma.sqli.formation.ws.dto.order;

import ma.sqli.formation.zynerator.audit.Log;
import ma.sqli.formation.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.sqli.formation.ws.dto.catalog.ProductDto;
import ma.sqli.formation.ws.dto.commun.OrderStatusDto;
import ma.sqli.formation.ws.dto.client.ClientDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBoutiqueDto  extends AuditBaseDto {

    private String reference  ;
    private String orderDate ;
    private BigDecimal total  ;

    private OrderStatusDto orderStatus ;
    private ClientDto client ;

    private List<OrderLineDto> orderLines ;


    public OrderBoutiqueDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getOrderDate(){
        return this.orderDate;
    }
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }


    public OrderStatusDto getOrderStatus(){
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatusDto orderStatus){
        this.orderStatus = orderStatus;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }



    public List<OrderLineDto> getOrderLines(){
        return this.orderLines;
    }

    public void setOrderLines(List<OrderLineDto> orderLines){
        this.orderLines = orderLines;
    }



}
