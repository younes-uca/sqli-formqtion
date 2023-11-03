package ma.sqli.formation.dao.facade.core.client;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.formation.zynerator.repository.AbstractRepository;
import ma.sqli.formation.bean.core.client.ClientCategory;
import org.springframework.stereotype.Repository;
import ma.sqli.formation.bean.core.client.ClientCategory;
import java.util.List;


@Repository
public interface ClientCategoryDao extends AbstractRepository<ClientCategory,Long>  {
    ClientCategory findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ClientCategory(item.id,item.libelle) FROM ClientCategory item")
    List<ClientCategory> findAllOptimized();

}
