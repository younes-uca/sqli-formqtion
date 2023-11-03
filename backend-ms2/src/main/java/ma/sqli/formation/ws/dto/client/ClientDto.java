package  ma.sqli.formation.ws.dto.client;

import ma.sqli.formation.zynerator.audit.Log;
import ma.sqli.formation.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;

    private ClientCategoryDto clientCategory ;



    public ClientDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }


    public ClientCategoryDto getClientCategory(){
        return this.clientCategory;
    }

    public void setClientCategory(ClientCategoryDto clientCategory){
        this.clientCategory = clientCategory;
    }






}
