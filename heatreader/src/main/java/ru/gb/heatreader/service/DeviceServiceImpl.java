package ru.gb.heatreader.service;

import org.springframework.stereotype.Service;
import ru.gb.heatreader.entity.Device;
import ru.gb.heatreader.entity.User;
import ru.gb.heatreader.repository.DataRepository;
import ru.gb.heatreader.repository.DeviceRepository;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{
    private DeviceRepository deviceRepository;

    private DataRepository dataRepository;

    public DeviceServiceImpl(DataRepository dataRepository, DeviceRepository deviceRepository) {
        this.dataRepository = dataRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device get(Long id) {
        return null;
    }

    @Override
    public Device get(String number) {
        return deviceRepository.findByNumber(number);
    }

    @Override
    public List<Device> getAll() {
        return null;
    }
    @Override
    public List<Device> findAllByUser(User user){
        return deviceRepository.findAllByUser(user);
    }


    @Override
    public void create(Device device) {
        deviceRepository.save(device);
        System.out.println(device);
    }

}
