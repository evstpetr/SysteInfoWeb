package ru.pes.Objects;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "pc_soft")
public class Soft implements Serializable {
    
    @Id
    @Column(name = "PC_ID")
    private int id;
    
    
    @Column(name = "SOFT")
    @Lob
    private Blob soft;
    
    public Soft() {
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the soft
     */
    public Blob getSoft() {
        return soft;
    }

    /**
     * @param soft the soft to set
     */
    public void setSoft(Blob soft) {
        this.soft = soft;
    }

    
}
