package  ma.sqli.formation.dao.specification.core.client;

import ma.sqli.formation.zynerator.specification.AbstractSpecification;
import ma.sqli.formation.dao.criteria.core.client.ClientCategoryCriteria;
import ma.sqli.formation.bean.core.client.ClientCategory;


public class ClientCategorySpecification extends  AbstractSpecification<ClientCategoryCriteria, ClientCategory>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ClientCategorySpecification(ClientCategoryCriteria criteria) {
        super(criteria);
    }

    public ClientCategorySpecification(ClientCategoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
