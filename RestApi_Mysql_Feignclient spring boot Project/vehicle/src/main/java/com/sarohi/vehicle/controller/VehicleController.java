package com.sarohi.vehicle.controller;

import com.sarohi.vehicle.api.CustomerClient;
import com.sarohi.vehicle.model.Vehicle;
import com.sarohi.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vehicle")
public class VehicleController {
    private final VehicleRepository vehicleRepository;
    private final CustomerClient customerClient;

    @RolesAllowed({"product_read"})
    @GetMapping("/all")
    public List<Vehicle> getVehicles() {

        List<Vehicle> vc = new ArrayList<>();
        vc.add(new Vehicle(1L, "sedan", "Sportbik", "truck"));
        vc.add(new Vehicle(2L, "hashback", "Sportbik", "truck"));
        return vc;
    }
    @PostMapping("/add")
    public Vehicle addData(@RequestBody Vehicle v) {
        return vehicleRepository.save(v);
    }

    @GetMapping("/remote")
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/customer")
    public String getCustomerData() {
        return customerClient.getCustomerString();
    }

//    @DeleteMapping("/remote/{Id}")
//    public List<Vehicle> remove(@PathVariable Long Id) {
//        if (vehicleRepository.existsById(Id)) {
//            vehicleRepository.deleteById(Id);
//        }
//        return vehicleRepository.findAll();
//    }

}
