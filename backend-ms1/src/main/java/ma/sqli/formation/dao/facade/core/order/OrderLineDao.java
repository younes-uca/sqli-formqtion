package ma.sqli.formation.dao.facade.core.order;

import ma.sqli.formation.zynerator.repository.AbstractRepository;
import ma.sqli.formation.bean.core.order.OrderLine;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OrderLineDao extends AbstractRepository<OrderLine,Long>  {

    List<OrderLine> findByOrderBoutiqueId(Long id);
    int deleteByOrderBoutiqueId(Long id);
    long countByOrderBoutiqueReference(String reference);


}
