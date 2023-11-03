package ma.sqli.formation.service.impl.admin.catalog;


import ma.sqli.formation.bean.core.catalog.Product;
import ma.sqli.formation.dao.criteria.core.catalog.ProductCriteria;
import ma.sqli.formation.dao.facade.core.catalog.ProductDao;
import ma.sqli.formation.dao.specification.core.catalog.ProductSpecification;
import ma.sqli.formation.service.facade.admin.catalog.ProductAdminService;
import ma.sqli.formation.zynerator.service.AbstractServiceImpl;
import ma.sqli.formation.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.sqli.formation.service.facade.admin.catalog.ProductCategoryAdminService ;
import ma.sqli.formation.bean.core.catalog.ProductCategory ;

import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product, ProductCriteria, ProductDao> implements ProductAdminService {





    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }

    public List<Product> findByProductCategoryId(Long id){
        return dao.findByProductCategoryId(id);
    }
    public int deleteByProductCategoryId(Long id){
        return dao.deleteByProductCategoryId(id);
    }
    public long countByProductCategoryCode(String code){
        return dao.countByProductCategoryCode(code);
    }

    public List<Product> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Product.class, ProductSpecification.class);
    }


    @Autowired
    private ProductCategoryAdminService productCategoryService ;

    public ProductAdminServiceImpl(ProductDao dao) {
        super(dao);
    }

}
