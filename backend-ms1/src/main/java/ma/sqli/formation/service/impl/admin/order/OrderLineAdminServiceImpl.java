package ma.sqli.formation.service.impl.admin.order;


import ma.sqli.formation.bean.core.order.OrderLine;
import ma.sqli.formation.dao.criteria.core.order.OrderLineCriteria;
import ma.sqli.formation.dao.facade.core.order.OrderLineDao;
import ma.sqli.formation.dao.specification.core.order.OrderLineSpecification;
import ma.sqli.formation.service.facade.admin.order.OrderLineAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.sqli.formation.service.facade.admin.catalog.ProductAdminService ;
import ma.sqli.formation.bean.core.catalog.Product ;
import ma.sqli.formation.service.facade.admin.order.OrderBoutiqueAdminService ;
import ma.sqli.formation.bean.core.order.OrderBoutique ;

import java.util.List;
@Service
public class OrderLineAdminServiceImpl extends AbstractServiceImpl<OrderLine, OrderLineCriteria, OrderLineDao> implements OrderLineAdminService {






    public List<OrderLine> findByOrderBoutiqueId(Long id){
        return dao.findByOrderBoutiqueId(id);
    }
    public int deleteByOrderBoutiqueId(Long id){
        return dao.deleteByOrderBoutiqueId(id);
    }
    public long countByOrderBoutiqueReference(String reference){
        return dao.countByOrderBoutiqueReference(reference);
    }






    public void configure() {
        super.configure(OrderLine.class, OrderLineSpecification.class);
    }


    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private OrderBoutiqueAdminService orderBoutiqueService ;

    public OrderLineAdminServiceImpl(OrderLineDao dao) {
        super(dao);
    }

}
