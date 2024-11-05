package gui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import dao.CarProducerDAO;
import dao.ICarProducerDAO;
import pojo.Account;
import pojo.Car;
import pojo.CarProducer;
import pojo.CarRental;
import pojo.Customer;
import service.AccountService;
import service.CarRentalService;
import service.CarService;
import service.CustomerService;
import service.IAccountService;
import service.ICarRentalService;
import service.ICarService;
import service.ICustomerService;

public class gui {

	public static void main(String args[])
	{  String file = "hibernate.cfg.xml";
		 IAccountService accountService = new AccountService(file);
		    Account account = new Account();
		    account.setAccountName("John Doe");
		    account.setRole("customer");
		    accountService.save(account);

		    // Create CarProducer
		    ICarProducerDAO carProducerDAO = new CarProducerDAO(file);
		    CarProducer carProducer = new CarProducer();
		    carProducer.setProcuderName("BMW");
		    carProducer.setAddress("Germany");
		    carProducer.setCountry("Germany");
		    carProducerDAO.save(carProducer);

		    // Create Car
		    ICarService carService = new CarService(file);
		    Car car = new Car();
		    car.setCarName("BMW X7");
		    car.setCarModelYear(2024);
		    car.setColor("White");
		    car.setCapacity(7);
		    car.setDescription("Luxury SUV");
		    car.setImportDate(LocalDate.now());
		    car.setCarProducer(carProducer);
		    car.setRentPrice(25000);
		    car.setStatus("available");
		    carService.save(car);

		    // Create Customer
		    ICustomerService customerService = new CustomerService(file);
		    Customer customer = new Customer();
		    customer.setAccount(account);
		    customer.setCustomerName("John Doe");
		    customer.setBirthday(LocalDate.of(1990, 1, 1));
		    customer.setMobile("0123456789");
		    customer.setIdentityCard("123456789");
		    customer.setLicenceNumber("DL123456");
		    customer.setLicenceDate(LocalDate.of(2020, 1, 1));
		    customer.setEmail("john.doe@example.com");
		    customer.setPassword("securepass123");
		    customerService.save(customer);

		    // Create CarRental
		    ICarRentalService carRentalService = new CarRentalService(file);
		    CarRental carRental = new CarRental();
		    carRental.setCar(car);
		    carRental.setCustomer(customer);
		    carRental.setPickupDate(LocalDate.now());
		    carRental.setReturnDate(LocalDate.now().plusDays(7));
		    carRental.setRentPrice(car.getRentPrice() * 7);
		    carRental.setStatus("processing");
		    carRentalService.save(carRental);
	}
		
	}


