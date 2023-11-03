package ma.sqli.formation.dao.facade.history.order;

import ma.sqli.formation.zynerator.repository.AbstractHistoryRepository;
import ma.sqli.formation.bean.history.order.OrderBoutiqueHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBoutiqueHistoryDao extends AbstractHistoryRepository<OrderBoutiqueHistory,Long> {

}
