package ma.sqli.formation.service.impl.admin.client;


import ma.sqli.formation.bean.core.client.Client;
import ma.sqli.formation.dao.criteria.core.client.ClientCriteria;
import ma.sqli.formation.dao.facade.core.client.ClientDao;
import ma.sqli.formation.dao.specification.core.client.ClientSpecification;
import ma.sqli.formation.service.facade.admin.client.ClientAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.sqli.formation.service.facade.admin.client.ClientCategoryAdminService ;
import ma.sqli.formation.bean.core.client.ClientCategory ;

import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {





    public Client findByReferenceEntity(Client t){
        return  dao.findByCode(t.getCode());
    }

    public List<Client> findByClientCategoryId(Long id){
        return dao.findByClientCategoryId(id);
    }
    public int deleteByClientCategoryId(Long id){
        return dao.deleteByClientCategoryId(id);
    }
    public long countByClientCategoryCode(String code){
        return dao.countByClientCategoryCode(code);
    }

    public List<Client> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Client.class, ClientSpecification.class);
    }


    @Autowired
    private ClientCategoryAdminService clientCategoryService ;

    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}
