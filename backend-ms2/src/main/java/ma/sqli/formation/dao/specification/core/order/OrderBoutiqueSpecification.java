package  ma.sqli.formation.dao.specification.core.order;

import ma.sqli.formation.zynerator.specification.AbstractSpecification;
import ma.sqli.formation.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.sqli.formation.bean.core.order.OrderBoutique;


public class OrderBoutiqueSpecification extends  AbstractSpecification<OrderBoutiqueCriteria, OrderBoutique>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("orderDate", criteria.getOrderDate(), criteria.getOrderDateFrom(), criteria.getOrderDateTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("orderStatus","id", criteria.getOrderStatus()==null?null:criteria.getOrderStatus().getId());
        addPredicateFk("orderStatus","id", criteria.getOrderStatuss());
        addPredicateFk("orderStatus","code", criteria.getOrderStatus()==null?null:criteria.getOrderStatus().getCode());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","code", criteria.getClient()==null?null:criteria.getClient().getCode());
    }

    public OrderBoutiqueSpecification(OrderBoutiqueCriteria criteria) {
        super(criteria);
    }

    public OrderBoutiqueSpecification(OrderBoutiqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
