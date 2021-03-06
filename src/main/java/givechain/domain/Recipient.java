package givechain.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recipient
{
    @Id
    private Long id;

    private String name;

    public Recipient() {
    }

    public Recipient(Long id, String name) {
        this.id = id;
        this.name = name;
    }



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    @Override
    public String toString() {
        return "Recipient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
