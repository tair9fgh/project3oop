package reprose2424.respro.controller;

import org.springframework.web.bind.annotation.RestController;
import reprose2424.respro.entites.*;
import reprose2424.respro.entities.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MyController {

    @Autowired
    private ObjectMapper oMapper;


    IDataPool datapool = new DataPool();
    IDB db = new PostgresDB();
    IUserRepository repo = new UserRepository(db);


//    @GetMapping("/main/student")
//    public String myStudentListener() {
//        Student str = new Sudent("Dmitriy", 19);
//        String jsonData = null;
//        try {
//            jsonData = oMapper.writeValueAsString(str);
//        } catch (JsonProcessingException e) {
//            System.out.println("error system" + e.getMessage());
//        }
//        return jsonData;
//    }

    ///////////////////////////////////////////////////////////create Flight
    @PostMapping("/main/create_flightfunc")//мы отправляем а он меняет ссылку добавляя данные
    public String create_flightfunc(@RequestParam String flightNumber, @RequestParam String fromdestin, @RequestParam String destin,
                                    @RequestParam String depTime, @RequestParam String arriveTime, @RequestParam int availSeats,
                                    @RequestParam double priceofSeat, @RequestParam String flightType, @RequestParam boolean freesnacks) {
        String jsonText = null;
        Passenger passenger1 = new Passenger();
        passenger1.setfirstName("John");
        passenger1.setlastName("Doe");
        passenger1.setage(30);
        passenger1.setpassportNumber("P123456789");
        boolean s2 = repo.createPassenger(passenger1);//пока не понял куда
        try {
            jsonText = oMapper.writeValueAsString(passenger1);//responding
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return jsonText;
    }//нельзя для решистрации пароль может передавать
    ///////////////////////////////////////////////////////////create Flight

    ///////////////////////////////////////////////////////////create Passenger
    @PostMapping("/main/create_passengerfunc")//мы отправляем а он меняет ссылку добавляя данные
    public String create_passengerfunc(@RequestParam String firstName, @RequestParam String lastName,
                                       @RequestParam int age, @RequestParam String passportNumber) {
        String jsonText = null;
        Flight flight1 = new Flight();
        flight1.setflightNumber(flightNumber);
        flight1.setFromdestin(fromdestin);
        flight1.setarriveTime1(arriveTime);
        flight1.setdestination(destin);
        flight1.setdepartureTime(depTime);
        flight1.setavailableSeats(availSeats);
        flight1.setprice(priceofSeat);
        flight1.setflightType(flightType);
        flight1.setfreesnacks(freesnacks);
        boolean s2 = repo.createFlight(flight1);//пока не понял куда
        try {
            jsonText = oMapper.writeValueAsString(flight1);//responding
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return jsonText;
    }
    ///////////////////////////////////////////////////////////create Passenger


    ///////////////////////////////////////////////////////////create Reservation
    @PostMapping("/main/create_reservfunc")//мы отправляем а он меняет ссылку добавляя данные
    public String create_reservfunc(@RequestParam String resID,
                                    @RequestParam String flightNumber,
                                    @RequestParam String passportNumber) {
        String jsonText = null;
        Reservation reservation1 = new Reservation();
        reservation1.setreservationID(resID);
        boolean s2 = repo.createReservation(resID, flightNumber, passportNumber);//пока не понял куда
        try {
            jsonText = oMapper.writeValueAsString(reservation1);//responding
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return jsonText;
    }
    ///////////////////////////////////////////////////////////create Reservation


    //    /////////////////////////
//    @PostMapping //create
//    @PutMapping //update
//    @PatchMapping//partially update
//    @DeleteMapping
//    /////////////////


    ///////////////////////////////////////////////////////////update passenger
    @PatchMapping("/main/update_pass")//еще не понял порядок
    public boolean update_pass(@PathVariable String firstName, @PathVariable String passportNumber) {
        //что писать ?
        try {
            boolean s2 = repo.updatePassenger(firstName, passportNumber);//пока не понял куда
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return repo.updatePassenger(firstName, passportNumber);
    }
    ///////////////////////////////////////////////////////////update passenger


    ///////////////////////////////////////////////////////////get passengerbyid
    @GetMapping("/main/get_passid")//еще не понял порядок
    public String get_passid(@PathVariable String passportNumber) {//что сюда писать @
        Passenger pass = repo.getPassenger(passportNumber);
        String jsonText = null;
        try {
            jsonText = oMapper.writeValueAsString(pass);
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return jsonText;
    }
    ///////////////////////////////////////////////////////////get passengerbyid


    ///////////////////////////////////////////////////////////get flightbydestinationtime
    @GetMapping("/main/get_destinflight")//еще не понял порядок
    public String get_destinFlight(@PathVariable String fromDestin, @PathVariable String destin,
                                   @PathVariable String depTime) {//что сюда писать @
        List<Flight> list = repo.getAllFlights(fromDestin, destin,
                depTime);
        String jsonText = null;
        try {
            jsonText = oMapper.writeValueAsString(list);
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return jsonText;
    }
    ///////////////////////////////////////////////////////////get flightbydestinationtime


    ///////////////////////////////////////////////////////////delete reservation
    @DeleteMapping("main/deletereserv") //i dont know order
    public boolean deletereserv(@PathVariable String resID) {
        try {
            boolean s2 = repo.deleteReservation(resID);
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return repo.deleteReservation(resID);
    }
    ///////////////////////////////////////////////////////////delete reservation


    ///////////////////////////////////////////////////////////delete reservation
    @DeleteMapping("main/deleteflight") //i dont know order
    public boolean deleteflight(@PathVariable String flightNumber) {
        try {
            boolean s2 = repo.deletedFlight(flightNumber);
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return repo.deletedFlight(flightNumber);
    }
    ///////////////////////////////////////////////////////////delete reservation


}






