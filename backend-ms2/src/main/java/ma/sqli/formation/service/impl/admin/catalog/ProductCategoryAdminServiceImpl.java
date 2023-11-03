package ma.sqli.formation.service.impl.admin.catalog;


import ma.sqli.formation.bean.core.catalog.ProductCategory;
import ma.sqli.formation.dao.criteria.core.catalog.ProductCategoryCriteria;
import ma.sqli.formation.dao.facade.core.catalog.ProductCategoryDao;
import ma.sqli.formation.dao.specification.core.catalog.ProductCategorySpecification;
import ma.sqli.formation.service.facade.admin.catalog.ProductCategoryAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProductCategoryAdminServiceImpl extends AbstractServiceImpl<ProductCategory, ProductCategoryCriteria, ProductCategoryDao> implements ProductCategoryAdminService {





    public ProductCategory findByReferenceEntity(ProductCategory t){
        return  dao.findByCode(t.getCode());
    }


    public List<ProductCategory> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ProductCategory.class, ProductCategorySpecification.class);
    }



    public ProductCategoryAdminServiceImpl(ProductCategoryDao dao) {
        super(dao);
    }

}
