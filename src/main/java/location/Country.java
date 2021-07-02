package location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    Collection<Region> regions;

    public Country(){}

    public Country(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }
    public Collection<Region> getRegions() {
        return regions;
    }
}