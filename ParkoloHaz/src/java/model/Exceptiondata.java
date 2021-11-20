package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsipaak
 */
@Entity
@Table(name = "EXCEPTIONDATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exceptiondata.findAll", query = "SELECT e FROM Exceptiondata e")
    , @NamedQuery(name = "Exceptiondata.findByExceptiondataid", query = "SELECT e FROM Exceptiondata e WHERE e.exceptiondataid = :exceptiondataid")
    , @NamedQuery(name = "Exceptiondata.findByCreatedon", query = "SELECT e FROM Exceptiondata e WHERE e.createdon = :createdon")
    , @NamedQuery(name = "Exceptiondata.findByGroupname", query = "SELECT e FROM Exceptiondata e WHERE e.groupname = :groupname")
    , @NamedQuery(name = "Exceptiondata.findByDescription", query = "SELECT e FROM Exceptiondata e WHERE e.description = :description")})
public class Exceptiondata implements Serializable {

    public static final String exceptionXmlFilename = "exceptions.xml";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXCEPTIONDATAID")
    private Integer exceptiondataid;
    @Column(name = "CREATEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Size(max = 1000)
    @Column(name = "GROUPNAME")
    private String groupname;
    @Lob
    @Size(max = 32700)
    @Column(name = "STACKTRACE")
    private String stacktrace;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Size(max = 32700)
    @Column(name = "STATE")
    private List<Item> state;

    public Exceptiondata() {
    }

    public Exceptiondata(Integer exceptiondataid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExceptionManagerPU");
        EntityManager em = emf.createEntityManager();
        //TODO: tárolt eljárást megírni és meghívni.
    }

    public Exceptiondata(Integer exceptiondataid, Date createdon, String groupname, String stacktrace, String description) {
        this.exceptiondataid = exceptiondataid;
        this.createdon = createdon;
        this.groupname = groupname;
        this.stacktrace = stacktrace;
        this.description = description;
        this.state = new ArrayList<Item>();
    }
    
    

    public Integer getExceptiondataid() {
        return exceptiondataid;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item getState(Integer index) {
        return this.state.get(index);
    }

    public void addStateElement(String key, Object value) {
        this.state.add(Item.createNewItem(key, value));
    }
    
    public Integer getStateSize(){
        return this.state.size();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exceptiondataid != null ? exceptiondataid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exceptiondata)) {
            return false;
        }
        Exceptiondata other = (Exceptiondata) object;
        if ((this.exceptiondataid == null && other.exceptiondataid != null) || (this.exceptiondataid != null && !this.exceptiondataid.equals(other.exceptiondataid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exceptiondata[ exceptiondataid=" + exceptiondataid + " ]";
    }
    
}
