package com.example.dbdemo.repository;

import com.example.dbdemo.entity.StoreInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreInformationRepositiry extends CrudRepository<StoreInformation,Integer> {
    List<StoreInformation> findByStoreName(String name);
    List<StoreInformation> findByStorePhoneNumber(String phoneNumber);
    List<StoreInformation> findByStoreDetail(String detail);



}
