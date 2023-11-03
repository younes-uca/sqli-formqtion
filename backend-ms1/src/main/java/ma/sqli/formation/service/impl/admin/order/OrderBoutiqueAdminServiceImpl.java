package ma.sqli.formation.service.impl.admin.order;


import ma.sqli.formation.bean.core.order.OrderBoutique;
import ma.sqli.formation.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.sqli.formation.dao.facade.core.order.OrderBoutiqueDao;
import ma.sqli.formation.dao.specification.core.order.OrderBoutiqueSpecification;
import ma.sqli.formation.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.sqli.formation.zynerator.util.VelocityPdf;
import ma.sqli.formation.ws.dto.order.OrderBoutiqueDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sqli.formation.service.facade.admin.order.OrderLineAdminService ;
import ma.sqli.formation.bean.core.order.OrderLine ;
import ma.sqli.formation.service.facade.admin.commun.OrderStatusAdminService ;
import ma.sqli.formation.bean.core.commun.OrderStatus ;
import ma.sqli.formation.service.facade.admin.client.ClientAdminService ;
import ma.sqli.formation.bean.core.client.Client ;

import java.util.List;
@Service
public class OrderBoutiqueAdminServiceImpl extends AbstractServiceImpl<OrderBoutique, OrderBoutiqueCriteria, OrderBoutiqueDao> implements OrderBoutiqueAdminService {
    public static final String TEMPLATE = "template/orderBoutique.vm";
    public static final String FILE_NAME = "orderBoutique.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderBoutiqueDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public OrderBoutique create(OrderBoutique t) {
        super.create(t);
        if (t.getOrderLines() != null) {
                t.getOrderLines().forEach(element-> {
                    element.setOrderBoutique(t);
                    orderLineService.create(element);
            });
        }
        return t;
    }

    public OrderBoutique findWithAssociatedLists(Long id){
        OrderBoutique result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setOrderLines(orderLineService.findByOrderBoutiqueId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        orderLineService.deleteByOrderBoutiqueId(id);
    }


    public void updateWithAssociatedLists(OrderBoutique orderBoutique){
    if(orderBoutique !=null && orderBoutique.getId() != null){
            List<List<OrderLine>> resultOrderLines= orderLineService.getToBeSavedAndToBeDeleted(orderLineService.findByOrderBoutiqueId(orderBoutique.getId()),orderBoutique.getOrderLines());
            orderLineService.delete(resultOrderLines.get(1));
            ListUtil.emptyIfNull(resultOrderLines.get(0)).forEach(e -> e.setOrderBoutique(orderBoutique));
            orderLineService.update(resultOrderLines.get(0),true);
    }
    }



    public OrderBoutique findByReferenceEntity(OrderBoutique t){
        return  dao.findByReference(t.getReference());
    }

    public List<OrderBoutique> findByOrderStatusId(Long id){
        return dao.findByOrderStatusId(id);
    }
    public int deleteByOrderStatusId(Long id){
        return dao.deleteByOrderStatusId(id);
    }
    public long countByOrderStatusCode(String code){
        return dao.countByOrderStatusCode(code);
    }

    public List<OrderBoutique> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(OrderBoutique.class, OrderBoutiqueSpecification.class);
    }


    @Autowired
    private OrderLineAdminService orderLineService ;
    @Autowired
    private OrderStatusAdminService orderStatusService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public OrderBoutiqueAdminServiceImpl(OrderBoutiqueDao dao) {
        super(dao);
    }

}
