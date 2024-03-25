package ru.gb.heatreader.repository;


import ru.gb.heatreader.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
