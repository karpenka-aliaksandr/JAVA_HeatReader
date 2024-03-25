package ru.gb.heatreader.controller;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.heatreader.entity.Device;
import ru.gb.heatreader.service.DeviceService;
import ru.gb.heatreader.service.UserService;

import java.security.Principal;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/devices")
public class DeviceController {

    private DeviceService deviceService;

    private UserService userService;

    public DeviceController(DeviceService deviceService, UserService userService) {
        this.deviceService = deviceService;
        this.userService = userService;
    }

    @GetMapping()
    public List<Device> getDevices(Principal principal) {
        return deviceService.findAllByUser(userService.findUserByUsername(principal.getName()));
    }

    @RequestMapping(value = "/{deviceNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public
    Device get(@PathVariable String deviceNumber) {
        return deviceService.get(deviceNumber);
    }
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> create(Principal principal, @RequestBody Device device) {
        device.setUser(userService.findUserByUsername("admin"));
        deviceService.create(device);
        HttpHeaders headers = new HttpHeaders();
        ControllerLinkBuilder linkBuilder = linkTo(methodOn(DeviceController.class).get(device.getNumber()));
        headers.setLocation(linkBuilder.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
