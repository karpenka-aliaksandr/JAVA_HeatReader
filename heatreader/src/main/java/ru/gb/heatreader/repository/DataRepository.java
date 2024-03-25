package ru.gb.heatreader.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.heatreader.entity.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
