package ma.sqli.formation.dao.facade.core.catalog;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.formation.zynerator.repository.AbstractRepository;
import ma.sqli.formation.bean.core.catalog.Product;
import org.springframework.stereotype.Repository;
import ma.sqli.formation.bean.core.catalog.Product;
import java.util.List;


@Repository
public interface ProductDao extends AbstractRepository<Product,Long>  {
    Product findByCode(String code);
    int deleteByCode(String code);

    List<Product> findByProductCategoryId(Long id);
    int deleteByProductCategoryId(Long id);
    long countByProductCategoryCode(String code);

    @Query("SELECT NEW Product(item.id,item.libelle) FROM Product item")
    List<Product> findAllOptimized();

}
