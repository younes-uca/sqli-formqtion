package ma.sqli.formation.dao.facade.core.client;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.formation.zynerator.repository.AbstractRepository;
import ma.sqli.formation.bean.core.client.Client;
import org.springframework.stereotype.Repository;
import ma.sqli.formation.bean.core.client.Client;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {
    Client findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Client(item.id,item.libelle) FROM Client item")
    List<Client> findAllOptimized();

}
