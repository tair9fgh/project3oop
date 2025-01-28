package reprose2424.respro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reprose2424.respro.entites.*;

@RestController
public class MyController {

    @Autowired
    private ObjectMapper oMapper;

    @GetMapping("/main")
    public String myListener() {
        return "Hello ";
    }


    @GetMapping("/main/student")
    public String myStudentListener() {
        Student str = new Sudent("Dmitriy", 19);
        String jsonData = null;
        try {
            jsonData = oMapper.writeValueAsString(str);
        } catch (JsonProcessingException e) {
            System.out.println("error system" + e.getMessage());
        }
        return jsonData;
    }

    @PostMapping("/main/specific_student")//мы отправляем а он меняет ссылку добавляя данные
    public String mySpecificStudentListener(@RequestParam String name, @RequestParam int a) {
        String jsonText = null;
        Student st2 = new Student();
        st2.setName();
        st2.setAge();
        try {
            jsonText = oMapper.writeValueAsString(st2);//responding
        } catch (JsonprocessingException e) {
            System.out.println("Error System");
        }
        return jsonText;
    }//нельзя для решистрации пароль может передавать


//    /////////////////////////
//    @PostMapping //create
//    @PutMapping //update
//    @PatchMapping//partially update
//    @DeleteMapping
//    /////////////////


}






