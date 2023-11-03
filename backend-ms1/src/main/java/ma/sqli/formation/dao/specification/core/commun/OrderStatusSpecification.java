package  ma.sqli.formation.dao.specification.core.commun;

import ma.sqli.formation.zynerator.specification.AbstractSpecification;
import ma.sqli.formation.dao.criteria.core.commun.OrderStatusCriteria;
import ma.sqli.formation.bean.core.commun.OrderStatus;


public class OrderStatusSpecification extends  AbstractSpecification<OrderStatusCriteria, OrderStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public OrderStatusSpecification(OrderStatusCriteria criteria) {
        super(criteria);
    }

    public OrderStatusSpecification(OrderStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
