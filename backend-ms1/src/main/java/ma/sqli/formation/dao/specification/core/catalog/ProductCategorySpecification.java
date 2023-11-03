package  ma.sqli.formation.dao.specification.core.catalog;

import ma.sqli.formation.zynerator.specification.AbstractSpecification;
import ma.sqli.formation.dao.criteria.core.catalog.ProductCategoryCriteria;
import ma.sqli.formation.bean.core.catalog.ProductCategory;


public class ProductCategorySpecification extends  AbstractSpecification<ProductCategoryCriteria, ProductCategory>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ProductCategorySpecification(ProductCategoryCriteria criteria) {
        super(criteria);
    }

    public ProductCategorySpecification(ProductCategoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
