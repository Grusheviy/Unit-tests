package seminars.second.hw;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;
    @BeforeEach
    void setUp() {
        car = new Car("Car_Company", "Car_Model", 10);
        motorcycle = new Motorcycle("Motorcycle_Company", "Motorcycle_Model", 10);
        car.testDrive();
        motorcycle.testDrive();
    }

    @Test
    void carIsInstanceOfVehicle(){
//    assertTrue(car instanceof Vehicle);
    if(car instanceof Vehicle) {
        assertTrue(true);
        System.out.println("Экземпляр объекта Car является экземпляром транспортного средства");
    } else {
       fail("Экземпляр объекта Car НЕ является экземпляром транспортного средства");
    }
    }
    @Test
    void carHasFourWheel(){
        assertEquals(4, car.getNumWheels());
        System.out.println("У автомобиля 4 колеса");
    }
    @Test
    void motorcycleHasTwoWheel(){
        assertEquals(2,motorcycle.getNumWheels());
        System.out.println("У мотоцикла 2 колеса");
    }
    @Test
    void carTestDriveAccelerate60(){
        assertEquals(60,car.getSpeed());
        System.out.println("объект Car развивает скорость 60 в режиме тестового вождения (testDrive())");
    }
    @Test
    void motorcycleTestDriveAccelerate75(){
        assertEquals(75, motorcycle.getSpeed());
        System.out.println("объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())");
    }
    @Test
    void carSpeedWhenParked(){
        car.park();
        assertEquals(0,car.getSpeed());
        System.out.println("В режиме парковки машина останавливается (speed = 0)");
    }
    @Test
    void motorcycleSpeedWhenParked(){
        motorcycle.park();
        assertEquals(0,motorcycle.getSpeed());
        System.out.println("В режиме парковки мотоцикл останавливается (speed = 0)");
    }
}
