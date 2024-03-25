package ru.gb.heatreader.service;

import ru.gb.heatreader.entity.Device;
import ru.gb.heatreader.entity.User;

import java.util.List;


public interface DeviceService {
    Device get(Long id);
    Device get(String number);
    List<Device> getAll();
    List<Device> findAllByUser(User user);
    void create(Device device);
}
