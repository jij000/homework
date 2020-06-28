package edu.miu.CS525DE.Lab01.a;

import java.time.LocalDate;
import java.util.List;

public class Rental {
    String id;
    UserInfo customer;
    Car car;
    LocalDate startDate;
    LocalDate endDate;
    Integer maximunDuration;

    private boolean reserveCar(UserInfo customer, LocalDate startDate, Integer maximunDuration) {
        return false;
    }
    private boolean deleteById(String id) {
        return false;
    }
    private List<Rental> search(String condition) {
        return null;
    }
}
