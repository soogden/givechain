package givechain.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CProject
{
    @Id
    private Long id;

    private String name;
    private String charity;

    
    public CProject() {
    }
    
    public CProject(Long id, String name, String charity) {
        this.id = id;
        this.name = name;
        this.charity = charity;
    }

    public String getCharity() {
		return charity;
	}

	public void setCharity(String charity) {
		this.charity = charity;
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
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", charity=" + charity.toString() +
                '}';
    }
}
