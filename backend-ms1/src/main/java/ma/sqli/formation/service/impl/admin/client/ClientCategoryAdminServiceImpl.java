package ma.sqli.formation.service.impl.admin.client;


import ma.sqli.formation.bean.core.client.ClientCategory;
import ma.sqli.formation.dao.criteria.core.client.ClientCategoryCriteria;
import ma.sqli.formation.dao.facade.core.client.ClientCategoryDao;
import ma.sqli.formation.dao.specification.core.client.ClientCategorySpecification;
import ma.sqli.formation.service.facade.admin.client.ClientCategoryAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientCategoryAdminServiceImpl extends AbstractServiceImpl<ClientCategory, ClientCategoryCriteria, ClientCategoryDao> implements ClientCategoryAdminService {





    public ClientCategory findByReferenceEntity(ClientCategory t){
        return  dao.findByCode(t.getCode());
    }


    public List<ClientCategory> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ClientCategory.class, ClientCategorySpecification.class);
    }



    public ClientCategoryAdminServiceImpl(ClientCategoryDao dao) {
        super(dao);
    }

}
