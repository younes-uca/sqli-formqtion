package ma.sqli.formation.service.impl.admin.commun;


import ma.sqli.formation.bean.core.commun.OrderStatus;
import ma.sqli.formation.dao.criteria.core.commun.OrderStatusCriteria;
import ma.sqli.formation.dao.facade.core.commun.OrderStatusDao;
import ma.sqli.formation.dao.specification.core.commun.OrderStatusSpecification;
import ma.sqli.formation.service.facade.admin.commun.OrderStatusAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.sqli.formation.zynerator.util.VelocityPdf;
import ma.sqli.formation.ws.dto.commun.OrderStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class OrderStatusAdminServiceImpl extends AbstractServiceImpl<OrderStatus, OrderStatusCriteria, OrderStatusDao> implements OrderStatusAdminService {
    public static final String TEMPLATE = "template/orderStatus.vm";
    public static final String FILE_NAME = "orderStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public OrderStatus findByReferenceEntity(OrderStatus t){
        return  dao.findByCode(t.getCode());
    }


    public List<OrderStatus> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(OrderStatus.class, OrderStatusSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public OrderStatusAdminServiceImpl(OrderStatusDao dao) {
        super(dao);
    }

}
