package ma.sqli.formation.service.facade.admin.order;

import java.util.List;
import ma.sqli.formation.bean.core.order.OrderBoutique;
import ma.sqli.formation.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.sqli.formation.zynerator.service.IService;

import ma.sqli.formation.ws.dto.order.OrderBoutiqueDto;
import org.springframework.http.HttpEntity;


public interface OrderBoutiqueAdminService extends  IService<OrderBoutique,OrderBoutiqueCriteria>  {

    List<OrderBoutique> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCode(String code);


    HttpEntity<byte[]> createPdf(OrderBoutiqueDto dto) throws Exception;

}
