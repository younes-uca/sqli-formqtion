package  ma.sqli.formation.dao.criteria.core.client;



import ma.sqli.formation.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClientCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private ClientCategoryCriteria clientCategory ;
    private List<ClientCategoryCriteria> clientCategorys ;


    public ClientCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


    public ClientCategoryCriteria getClientCategory(){
        return this.clientCategory;
    }

    public void setClientCategory(ClientCategoryCriteria clientCategory){
        this.clientCategory = clientCategory;
    }
    public List<ClientCategoryCriteria> getClientCategorys(){
        return this.clientCategorys;
    }

    public void setClientCategorys(List<ClientCategoryCriteria> clientCategorys){
        this.clientCategorys = clientCategorys;
    }
}
