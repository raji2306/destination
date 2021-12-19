package com.example.demo.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService implements FruitInterfaceService{

	@Autowired
	private FruitRepository repo;
	
	public List<Fruit> getAllFruit(){
		return repo.findAll();
	}
	
	public void deleteFruit(int id) {
		repo.deleteById(id);
	}
	
	public void saveOrUpdate(Fruit fruit) {
		Fruit f=new Fruit();
		f.setId(fruit.getId());
		f.setFruitname(fruit.getFruitname());
		f.setFruitprice(fruit.getFruitprice());
		f.setQuantity(fruit.getQuantity());
		repo.save(f);
	}
	
	public Fruit getFruitById(int id) {
		Optional<Fruit> list=repo.findById(id);
		Fruit f=null;
		if(list.isPresent()) {
			f=list.get();
		}
		 return f;
	}

}
