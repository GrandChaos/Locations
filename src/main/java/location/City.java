package location;

import javax.persistence.*;

public class City {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    Region region;

    public City() {}

    public City(String name){
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

    public void setRegion(Region region) {
        this.region = region;
    }
    public Region getRegion() {
        return region;
    }
}
