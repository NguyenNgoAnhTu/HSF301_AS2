package repo;

import java.util.List;

import pojo.Car;

public interface ICarRepo {
	public List<Car> findAll();

	public void save(Car car);

	public void delete(Long carId);

	public Car findById(Long carId);

	public void update(Car car);
	
	public List<Car> searchByName(String name);
}
