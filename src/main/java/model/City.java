package model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "city")
@Data

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City() {
    }
    public City(String cityName) {
        this.cityName = cityName;
    }
}