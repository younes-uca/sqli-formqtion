package ma.sqli.formation.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.formation.zynerator.repository.AbstractRepository;
import ma.sqli.formation.bean.core.commun.OrderStatus;
import org.springframework.stereotype.Repository;
import ma.sqli.formation.bean.core.commun.OrderStatus;
import java.util.List;


@Repository
public interface OrderStatusDao extends AbstractRepository<OrderStatus,Long>  {
    OrderStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW OrderStatus(item.id,item.libelle) FROM OrderStatus item")
    List<OrderStatus> findAllOptimized();

}
