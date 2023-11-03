package ma.sqli.formation.service.facade.admin.commun;

import java.util.List;
import ma.sqli.formation.bean.core.commun.OrderStatus;
import ma.sqli.formation.dao.criteria.core.commun.OrderStatusCriteria;
import ma.sqli.formation.zynerator.service.IService;

import ma.sqli.formation.ws.dto.commun.OrderStatusDto;
import org.springframework.http.HttpEntity;


public interface OrderStatusAdminService extends  IService<OrderStatus,OrderStatusCriteria>  {



    HttpEntity<byte[]> createPdf(OrderStatusDto dto) throws Exception;

}
