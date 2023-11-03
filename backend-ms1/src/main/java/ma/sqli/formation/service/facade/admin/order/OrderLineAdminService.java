package ma.sqli.formation.service.facade.admin.order;

import java.util.List;
import ma.sqli.formation.bean.core.order.OrderLine;
import ma.sqli.formation.dao.criteria.core.order.OrderLineCriteria;
import ma.sqli.formation.zynerator.service.IService;



public interface OrderLineAdminService extends  IService<OrderLine,OrderLineCriteria>  {

    List<OrderLine> findByOrderBoutiqueId(Long id);
    int deleteByOrderBoutiqueId(Long id);
    long countByOrderBoutiqueReference(String reference);



}
