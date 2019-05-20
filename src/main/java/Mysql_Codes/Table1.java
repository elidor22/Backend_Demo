package Mysql_Codes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;

@Entity
// Defines the name of the table created for the entity
@Table(name = "table_name")

public class Table1 implements  Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name", unique=true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String id) {
        this.email = id;
    }


}
