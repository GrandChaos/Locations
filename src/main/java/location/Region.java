package location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    Country country;
    @JsonIgnore
    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    Collection<City> cities;

    public Region() {}

    public Region(String name){
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

    public void setCountry(Country country) {
        this.country = country;
    }
    public Country getCountry() {
        return country;
    }

    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }
    public Collection<City> getCities() {
        return cities;
    }
}
