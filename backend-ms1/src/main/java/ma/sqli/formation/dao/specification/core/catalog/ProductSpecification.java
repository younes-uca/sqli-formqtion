package  ma.sqli.formation.dao.specification.core.catalog;

import ma.sqli.formation.zynerator.specification.AbstractSpecification;
import ma.sqli.formation.dao.criteria.core.catalog.ProductCriteria;
import ma.sqli.formation.bean.core.catalog.Product;


public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("productCategory","id", criteria.getProductCategory()==null?null:criteria.getProductCategory().getId());
        addPredicateFk("productCategory","id", criteria.getProductCategorys());
        addPredicateFk("productCategory","code", criteria.getProductCategory()==null?null:criteria.getProductCategory().getCode());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
