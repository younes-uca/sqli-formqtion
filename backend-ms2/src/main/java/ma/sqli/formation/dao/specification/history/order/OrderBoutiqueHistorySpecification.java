package  ma.sqli.formation.dao.specification.history.order;

import ma.sqli.formation.zynerator.specification.AbstractHistorySpecification;
import ma.sqli.formation.dao.criteria.history.order.OrderBoutiqueHistoryCriteria;
import ma.sqli.formation.bean.history.order.OrderBoutiqueHistory;


public class OrderBoutiqueHistorySpecification extends AbstractHistorySpecification<OrderBoutiqueHistoryCriteria, OrderBoutiqueHistory> {

    public OrderBoutiqueHistorySpecification(OrderBoutiqueHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderBoutiqueHistorySpecification(OrderBoutiqueHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
