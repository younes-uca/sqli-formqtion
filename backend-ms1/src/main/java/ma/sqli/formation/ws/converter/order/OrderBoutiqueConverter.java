package  ma.sqli.formation.ws.converter.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sqli.formation.zynerator.util.ListUtil;

import ma.sqli.formation.ws.converter.order.OrderLineConverter;
import ma.sqli.formation.ws.converter.catalog.ProductConverter;
import ma.sqli.formation.ws.converter.commun.OrderStatusConverter;
import ma.sqli.formation.ws.converter.client.ClientConverter;



import ma.sqli.formation.zynerator.util.StringUtil;
import ma.sqli.formation.zynerator.converter.AbstractConverter;
import ma.sqli.formation.zynerator.util.DateUtil;
import ma.sqli.formation.bean.core.order.OrderBoutique;
import ma.sqli.formation.ws.dto.order.OrderBoutiqueDto;

@Component
public class OrderBoutiqueConverter extends AbstractConverter<OrderBoutique, OrderBoutiqueDto> {

    @Autowired
    private OrderLineConverter orderLineConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private OrderStatusConverter orderStatusConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    private boolean orderStatus;
    private boolean client;
    private boolean orderLines;

    public  OrderBoutiqueConverter(){
        super(OrderBoutique.class, OrderBoutiqueDto.class);
        init(true);
    }

    @Override
    public OrderBoutique toItem(OrderBoutiqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderBoutique item = new OrderBoutique();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getOrderDate()))
                item.setOrderDate(DateUtil.stringEnToDate(dto.getOrderDate()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(this.orderStatus && dto.getOrderStatus()!=null &&  dto.getOrderStatus().getId() != null)
                item.setOrderStatus(orderStatusConverter.toItem(dto.getOrderStatus())) ;

            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.orderLines && ListUtil.isNotEmpty(dto.getOrderLines()))
                item.setOrderLines(orderLineConverter.toItem(dto.getOrderLines()));


        return item;
        }
    }

    @Override
    public OrderBoutiqueDto toDto(OrderBoutique item) {
        if (item == null) {
            return null;
        } else {
            OrderBoutiqueDto dto = new OrderBoutiqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getOrderDate()!=null)
                dto.setOrderDate(DateUtil.dateTimeToString(item.getOrderDate()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
        if(this.orderStatus && item.getOrderStatus()!=null) {
            dto.setOrderStatus(orderStatusConverter.toDto(item.getOrderStatus())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.orderLines && ListUtil.isNotEmpty(item.getOrderLines())){
            orderLineConverter.init(true);
            orderLineConverter.setOrderBoutique(false);
            dto.setOrderLines(orderLineConverter.toDto(item.getOrderLines()));
            orderLineConverter.setOrderBoutique(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.orderLines = value;
    }

    public void initObject(boolean value) {
        this.orderStatus = value;
        this.client = value;
    }


    public OrderLineConverter getOrderLineConverter(){
        return this.orderLineConverter;
    }
    public void setOrderLineConverter(OrderLineConverter orderLineConverter ){
        this.orderLineConverter = orderLineConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public OrderStatusConverter getOrderStatusConverter(){
        return this.orderStatusConverter;
    }
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter ){
        this.orderStatusConverter = orderStatusConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public boolean  isOrderStatus(){
        return this.orderStatus;
    }
    public void  setOrderStatus(boolean orderStatus){
        this.orderStatus = orderStatus;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isOrderLines(){
        return this.orderLines ;
    }
    public void  setOrderLines(boolean orderLines ){
        this.orderLines  = orderLines ;
    }
}
