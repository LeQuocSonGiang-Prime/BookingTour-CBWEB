package com.example.BookingTour.database;

import com.example.BookingTour.model.Customer;
import com.example.BookingTour.model.Tour;
import com.example.BookingTour.repositories.CustomerRepository;
import com.example.BookingTour.repositories.TourRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    private static final Logger  logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDataCustomer(CustomerRepository customerRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Customer c1= new Customer("Giang","0651654","giang@gmail.com", "HCM");
                Customer c2= new Customer("Thoai","0651654","giang@gmail.com", "HCM");
                Customer c3= new Customer("An","0651654","giang@gmail.com", "HCM");
                Customer c4= new Customer("Dat","0651654","giang@gmail.com", "HCM");
                Customer c5= new Customer("Tu","0651654","giang@gmail.com", "HCM");
                Customer c6= new Customer("Map","0651654","giang@gmail.com", "HCM");
                Customer c7= new Customer("Vu","0651654","giang@gmail.com", "HCM");
                Customer c8= new Customer("Khai","0651654","giang@gmail.com", "HCM");

                logger.info("insert data: "+ customerRepository.save(c1));
                logger.info("insert data: "+ customerRepository.save(c2));
                logger.info("insert data: "+ customerRepository.save(c3));
                logger.info("insert data: "+ customerRepository.save(c4));
                logger.info("insert data: "+ customerRepository.save(c5));
                logger.info("insert data: "+ customerRepository.save(c6));
                logger.info("insert data: "+ customerRepository.save(c7));
                logger.info("insert data: "+ customerRepository.save(c8));
            }
        };
    }


    @Bean
    CommandLineRunner initDataTour(TourRepository tourRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Tour t1 = new Tour("Du lich Ha Noi", "14/7/2023", "bus", "5 ngay", 250.0);
                Tour t2 = new Tour("Du lich Thai Nguyen", "14/7/2023", "bus", "5 ngay", 250.0);
                Tour t3 = new Tour("Du lich Ca Mau", "14/7/2023", "bus", "5 ngay", 250.0);
                Tour t4 = new Tour("Du lich Long An", "14/7/2023", "bus", "5 ngay", 250.0);
                Tour t5 = new Tour("Du lich Ha giang", "14/7/2023", "bus", "5 ngay", 250.0);
                Tour t6 = new Tour("Du lich Cat hung", "14/7/2023", "bus", "5 ngay", 250.0);
                Tour t7= new Tour("Du lich Binh Dinh", "14/7/2023", "bus", "5 ngay", 250.0);

                logger.info("insert data Tour : "+ tourRepository.save(t1));
                logger.info("insert data Tour : "+ tourRepository.save(t2));
                logger.info("insert data Tour : "+ tourRepository.save(t3));
                logger.info("insert data Tour : "+ tourRepository.save(t4));
                logger.info("insert data Tour : "+ tourRepository.save(t5));
                logger.info("insert data Tour : "+ tourRepository.save(t6));
                logger.info("insert data Tour : "+ tourRepository.save(t7));
            }
        };
    }

}
