package ua.com.alevel.app;

import ua.com.alevel.lib.CrudProcess;
import ua.com.alevel.lib.CrudProcessFactory;

import java.util.Collection;

public class CarService {

    private CrudProcess<Car> carCrudProcess = CrudProcessFactory.getInstance().getCrudProcess();

    public void create(Car car) {
        carCrudProcess.create(car);
    }

    public Collection<Car> findAll() {
        return carCrudProcess.read();
    }
}
