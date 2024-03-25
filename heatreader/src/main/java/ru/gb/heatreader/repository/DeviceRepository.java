package ru.gb.heatreader.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.heatreader.entity.Device;
import ru.gb.heatreader.entity.User;

import java.util.List;


public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findAllByUser(User user);
    Device findByNumber(String number);
    //void create(Device device);

}
