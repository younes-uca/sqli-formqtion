package ma.sqli.formation.bean.core.catalog;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.formation.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="product_seq",sequenceName="product_seq",allocationSize=1, initialValue = 1)
public class Product   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;

    private ProductCategory productCategory ;


    public Product(){
        super();
    }

    public Product(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Product(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="product_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    public ProductCategory getProductCategory(){
        return this.productCategory;
    }
    public void setProductCategory(ProductCategory productCategory){
        this.productCategory = productCategory;
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
        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

