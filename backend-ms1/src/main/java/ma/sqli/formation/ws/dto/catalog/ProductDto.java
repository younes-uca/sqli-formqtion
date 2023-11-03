package  ma.sqli.formation.ws.dto.catalog;

import ma.sqli.formation.zynerator.audit.Log;
import ma.sqli.formation.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;

    private ProductCategoryDto productCategory ;



    public ProductDto(){
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


    public ProductCategoryDto getProductCategory(){
        return this.productCategory;
    }

    public void setProductCategory(ProductCategoryDto productCategory){
        this.productCategory = productCategory;
    }






}
