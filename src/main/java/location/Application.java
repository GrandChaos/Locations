package location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Collection;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        CountryRepository countryRepository = context.getBean(CountryRepository.class);
        RegionRepository regionRepository = context.getBean(RegionRepository.class);
        CityRepository cityRepository = context.getBean(CityRepository.class);

        Country country_1 = new Country("Russia");
        countryRepository.save(country_1);

        Country country_2 = new Country("USA");
        countryRepository.save(country_2);



        Region region_1 = new Region("Vologda region");
        region_1.setCountry(countryRepository.findByName("Russia"));
        regionRepository.save(region_1);

        Region region_2 = new Region("Republic of Bashkortostan");
        region_2.setCountry(countryRepository.findByName("Russia"));
        regionRepository.save(region_2);

        Region region_3 = new Region("Pennsylvania");
        region_3.setCountry(countryRepository.findByName("USA"));
        regionRepository.save(region_3);



        City city_1 = new City("Vologda");
        city_1.setRegion(regionRepository.findByName("Vologda region"));
        cityRepository.save(city_1);

        City city_2 = new City("Cherepovets");
        city_2.setRegion(regionRepository.findByName("Vologda region"));
        cityRepository.save(city_2);

        City city_3 = new City("Ufa");
        city_3.setRegion(regionRepository.findByName("Republic of Bashkortostan"));
        cityRepository.save(city_3);

        City city_4 = new City("Pittsburgh");
        city_4.setRegion(regionRepository.findByName("Pennsylvania"));
        cityRepository.save(city_4);

        City city_5 = new City("Harrisburg");
        city_5.setRegion(regionRepository.findByName("Pennsylvania"));
        cityRepository.save(city_5);



        Collection<Country> countryList = countryRepository.findAll();
        for (Country country : countryList) {
            System.out.println(country.getName());
            Collection<Region> regionList = country.getRegions();
            for (Region region : regionList) {
                System.out.println("\t" + region.getName() + ":");
                Collection<City> cityList = region.getCities();
                for (City city : cityList){
                    System.out.print("\t\t");
                    System.out.print(city.getName() + ";");
                }
                System.out.println();
            }
            System.out.println();
        }
        context.close();
    }
}
