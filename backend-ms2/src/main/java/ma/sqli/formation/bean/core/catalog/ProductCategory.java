package ma.sqli.formation.bean.core.catalog;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.formation.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "product_category")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="product_category_seq",sequenceName="product_category_seq",allocationSize=1, initialValue = 1)
public class ProductCategory   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public ProductCategory(){
        super();
    }

    public ProductCategory(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public ProductCategory(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="product_category_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory productCategory = (ProductCategory) o;
        return id != null && id.equals(productCategory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

