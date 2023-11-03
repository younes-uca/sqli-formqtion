package ma.sqli.formation.zynerator.service;

import ma.sqli.formation.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sqli.formation.zynerator.criteria.BaseCriteria;
import ma.sqli.formation.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
