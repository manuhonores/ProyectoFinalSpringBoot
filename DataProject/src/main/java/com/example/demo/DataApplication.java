package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ExcursionRepository excursionRepository, FlyRepository flyRepository, HotelRepository hotelRepository, PlanRepository planRepository, TravelRepository travelRepository, UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            User u1 = new User("Admin", "admin@mail.com", "123");
            User u2 = new User("User2", "user2@gmail.com", "123");
            User u3 = new User("User3", "user3@gmail.com", "123");

            Travel viaje1 = new Travel("Viaje1", "Gualeguaychu", "AmericaSur", 1, 10, 2020, 12, 12, 2020, "Viaje1/Usuario1 Futuro", u1);
            Travel viaje2 = new Travel("Viaje2", "DestinoViaje2", "Europa", 1, 10, 2020, 12, 12, 2020, "Viaje2/Usuario2 Futuro", u2);
            Travel viaje3 = new Travel("Viaje3", "DestinoViaje3", "AmericaSur", 15, 11, 2020, 17, 11, 2020, "Viaje3/Usuario1 Finalizado", u1);
            Travel viaje4 = new Travel("Viaje4", "DestinoViaje4", "Asia", 5, 10, 2020, 12, 11, 2020, "Viaje4/Usuario2 Finalizado", u2);
            Travel viaje5 = new Travel("Viaje5", "DestinoViaje5", "AmericaSur", 1, 10, 2020, 12, 12, 2020, "Viaje5/Usuario3 Futuro", u3);
            Travel viaje6 = new Travel("Viaje6", "DestinoViaje6", "Europa", 10, 10, 2020, 12, 11, 2020, "Viaje5/Usuario3 Finalizado", u3);

            Plan plan1 = new Hotel("Hotel", "PlanViaje1/UsuarioAdmin", "Country1", viaje1, 10, 11, 2020, 14, 11, 2020, "Hotel1", true);
            Plan plan2 = new Excursion("Excursion", 120, "Excursion1", "PlanUsuarioAdmin/Viaje3", "Country2", viaje3, 11, 12, 2020, 11, 12, 2020, false);
            Plan plan3 = new Fly("Compania1", 10, 11, 2020, 10, "AeropuertoSalida1" , 20, 12, 2020, 16, "AeropuertoVuelta1", "ABC123", "Airplane1", 3, "Place1", 5, "Name", "Vuelo1/Viaje1/Usuario1", "Country1", viaje1, 16, 11, 2020, 16, 11, 2020, true);

            Plan plan4 = new Hotel("Hotel", "PlanViaje2/Usuario2", "Country1", viaje2, 10, 11, 2020, 14, 11, 2020, "Hotel2", true);
            Plan plan5 = new Excursion("Excursion", 120, "Excursion1", "PlanUsuario2/Viaje4", "Country2", viaje4, 11, 12, 2020, 11, 12, 2020, false);
            Plan plan6 = new Fly("Compania1", 10, 11, 2020, 10, "AeropuertoSalida1" , 20, 12, 2020, 16, "AeropuertoVuelta1", "ABC123", "Airplane1", 3, "Place1", 5, "Name", "Vuelo1/Viaje2/Usuario2", "Country1", viaje2, 16, 11, 2020, 16, 11, 2020, true);

            Plan plan7 = new Hotel("Hotel", "PlanViaje1/Usuario3", "Country1", viaje5, 10, 11, 2020, 14, 11, 2020, "Hotel1", true);
            Plan plan8 = new Excursion("Excursion", 120, "Excursion1", "PlanUsuario3/Viaje6", "Country2", viaje6, 11, 12, 2020, 11, 12, 2020, false);
            Plan plan9 = new Fly("Compania1", 10, 11, 2020, 10, "AeropuertoSalida1" , 20, 12, 2020, 16, "AeropuertoVuelta1", "ABC123", "Airplane1", 3, "Place1", 5, "Name", "Vuelo1/Viaje5/Usuario3", "Country1", viaje5, 16, 11, 2020, 16, 11, 2020, true);

            viaje1.addPlan(plan1);
            viaje1.addPlan(plan3);
            viaje3.addPlan(plan2);

            viaje2.addPlan(plan4);
            viaje2.addPlan(plan6);
            viaje4.addPlan(plan5);

            viaje5.addPlan(plan7);
            viaje5.addPlan(plan9);
            viaje6.addPlan(plan8);

            userRepository.save(u1);
            userRepository.save(u2);
            userRepository.save(u3);

            travelRepository.save(viaje1);
            travelRepository.save(viaje2);
            travelRepository.save(viaje3);
            travelRepository.save(viaje4);
            travelRepository.save(viaje5);
            travelRepository.save(viaje6);

            hotelRepository.save((Hotel) plan1);
            hotelRepository.save((Hotel) plan4);
            hotelRepository.save((Hotel) plan7);

            excursionRepository.save((Excursion) plan2);
            excursionRepository.save((Excursion) plan5);
            excursionRepository.save((Excursion) plan8);

            flyRepository.save((Fly) plan3);
            flyRepository.save((Fly) plan6);
            flyRepository.save((Fly) plan9);
        };
    }

}
