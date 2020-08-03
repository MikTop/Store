package com.example.store.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.store.domain.Goods;




public interface GoodsRepo extends CrudRepository <Goods, Integer> {
	
	List<Goods> findAll();
	
	Goods getById (String username);
}