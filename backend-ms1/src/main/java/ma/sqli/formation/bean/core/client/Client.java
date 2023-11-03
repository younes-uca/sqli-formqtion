package ma.sqli.formation.bean.core.client;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.formation.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "client")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="client_seq",sequenceName="client_seq",allocationSize=1, initialValue = 1)
public class Client   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;

    private ClientCategory clientCategory ;


    public Client(){
        super();
    }

    public Client(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Client(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="client_seq")
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
    public ClientCategory getClientCategory(){
        return this.clientCategory;
    }
    public void setClientCategory(ClientCategory clientCategory){
        this.clientCategory = clientCategory;
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
        Client client = (Client) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

