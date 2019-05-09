package Mysql_Codes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// Defines the name of the table created for the entity
@Table(name = "table1")

public class Table1 implements  Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "column_1", unique=true)
    private int col;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }





}
