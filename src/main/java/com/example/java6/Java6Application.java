package com.example.java6;

import com.example.java6.Entity.Contact;
import com.example.java6.Entity.Student;
import com.example.java6.Entity.Student2;
import com.example.java6.Entity.Subjects;
import com.example.java6.Interface.Bai1dInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class Java6Application {
    private static Logger logger = LoggerFactory.getLogger(Java6Application.class);
    public static String JSON_SPATH = System.getProperty("user.dir") + "/src/main/resources/static/";
    public static String JSON_STUDENT = System.getProperty("user.dir") + "/src/main/resources/static/student.json";
    public static String JSON_STUDENTS = System.getProperty("user.dir") + "/src/main/resources/static/students.json";
    private static List<Student> stu = Arrays.asList(
            new Student("Tấn Phát",true,10.0),
            new Student("Sơn Tùng",true,1.0),
            new Student("Duy Linh",false,9.0),
            new Student("Ronaldo",true,1.0)
    );
    private static Scanner scan = new Scanner(System.in);
    private static String input;

    private static void Continue() {

        System.out.println("\nBạn có muốn tiếp tục? (Y/N)");
        input = scan.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            KhungLab1();
        } else if (input.equalsIgnoreCase("N")) {
            System.out.println("Thoát");
            scan.close();
            System.exit(0);
        } else {
            System.out.println("Nhập sai, vui lòng nhập lại (Y/N)");
            Continue();
        }
    }
    public static void KhungLab1() {
        System.out.println("-----------------------Lab 1----------------------------");
        System.out.println("Bài 1: Lamda");
        System.out.println("Bài 1a: ");
        System.out.println("Bài 1b: ");
        System.out.println("Bài 1c: ");
        System.out.println("Bài 1d: ");
        System.out.println("Bài 2: StreamAPI");
        System.out.println("Bài 2a: ");
        System.out.println("Bài 2b: ");
        System.out.println("Bài 2c: ");
        System.out.println("Bài 2d: ");
        System.out.println("Bài 4: Read Json");
        System.out.println("Bài 4a: ");
        System.out.println("Bài 4b: ");
        System.out.println("Bài 5: Write Json");
        System.out.println("Bài 5a: ");
        System.out.println("Bài 5b: ");
        System.out.println("Bài 5c: ");
        System.out.println("Bài 5d: ");
        System.out.println("Bài 5e: ");
        System.out.println("Bài 5f: ");
        System.out.println("Bài 5g: ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Nhập: ");
        input = scan.nextLine();
        switch (input) {
            case "1a":
                Bai1A();
                Continue();
                break;
            case "1b":
                Bai1B();
                Continue();
                break;
            case "1c":
                Bai1C();
                Continue();
                break;
            case "1d":
                Bai1D();
                Continue();
                break;
            case "2a":
                Bai2A();
                Continue();
                break;
            case "2b":
                Bai2B();
                Continue();
                break;
            case "2c":
                Bai2C();
                Continue();
                break;
            case "2d":
                Bai2D();
                Continue();
                break;
            case "4a":
                Bai4A();
                Continue();
                break;
            case "4b":
                Bai4B();
                Continue();
                break;
            case "5a":
                Bai5A();
                Continue();
                break;
            case "5b":
                Bai5B();
                Continue();
                break;
            case "5c":
                Bai5C();
                Continue();
                break;
            case "5d":
                Bai5D();
                Continue();
                break;
            case "5e":
                Bai5E();
                Continue();
                break;
            case "5f":
                Bai5F();
                Continue();
                break;
            case "5g":
                Bai5G();
                Continue();
                break;
            default:
                System.out.println("Không có bài nào phù hợp");
                Continue();
                break;
        }
    }

    private static void Bai5G() {
        ObjectMapper mapper = new ObjectMapper();
        Contact contact = new Contact("0123456778","phat@gmail.com");
        List<Subjects> subjects = Arrays.asList(new Subjects("Hóa"),new Subjects("Địa"));
        Student2 student = new Student2("PhátK","19","100",contact,subjects);
        try {
            String json = mapper.writeValueAsString(student);
            System.out.println(json);
            mapper.writerWithDefaultPrettyPrinter().writeValue(System.out,student);
            mapper.writeValue(new File(JSON_SPATH+"sinhvien.json"),student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Bai5F() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> contact = new HashMap<>();
        contact.put("phone", "04343343434");
        contact.put("email", "phatntps36560@gmail.com");

        List<String> subjects = Arrays.asList("Toán","Anh");

        Map<String,Object> student = new HashMap<>();
        student.put("name","kkk");
        student.put("age",100);
        student.put("grade",100);
        student.put("contact",contact);
        student.put("subjects",subjects);

        try {
            String json = mapper.writeValueAsString(student);
            System.out.println(json);
            mapper.writerWithDefaultPrettyPrinter().writeValue(System.out,student);
            mapper.writeValue(new File(JSON_SPATH+"sinhvien.json"),student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Ghi ra dữ liệu
    private static void Bai5E() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Tấn phát 123");
        student.put("age", 21);
        student.put("grade", 10.0);

        ObjectNode contact = student.putObject("contact");
        contact.put("phone", "04343343434");
        contact.put("email", "phatntps36560@gmail.com");

        ArrayNode subjects = student.putArray("subjects");
        subjects.add("Toán");
        subjects.add("Lý");
        subjects.add("Hóa");

        try {
            String json = mapper.writeValueAsString(student);
            mapper.writerWithDefaultPrettyPrinter().writeValue(System.out,student);
            mapper.writeValue(new File(JSON_SPATH+"sinhvien.json"),student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void Bai5D() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>(){};
       try {
           List<Student2> students = mapper.readValue(new File(JSON_STUDENTS),type);
           students.forEach(System.out::println);
       } catch (Exception e) {
           e.printStackTrace();
       }

    }

    private static void Bai5C() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student2 student = mapper.readValue(new File(JSON_STUDENT),Student2.class);
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Grade: "+ student.getAge());

            Contact contact = student.getContact();
            System.out.println("Phone: " + contact.getPhone());
            System.out.println("Email: " + contact.getEmail());
            System.out.print("Subjects: ");

            List<Subjects> subjects = student.getSubjects();
            subjects.forEach(subject -> System.out.print(subject.getSubjectName()+", "));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Bai5B() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Map<String,Object>> students = mapper.readValue(new File(JSON_STUDENTS),List.class);
            students.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Bai5A() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String,Object> student = mapper.readValue(new File(JSON_STUDENT),Map.class);
            System.out.println("Name: " + student.get("name"));
            System.out.println("Age: " + student.get("age"));
            System.out.println("Grade: "+ student.get("grade"));

            Map<String,Object> contact = (Map<String, Object>) student.get("contact");
            System.out.println("Phone: " + contact.get("phone"));
            System.out.println("Email: " + contact.get("email"));
            System.out.print("Subjects: ");
            List<String> subjects = (List<String>) student.get("subjects");
            subjects.forEach(subject -> System.out.print(subject+", "));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        SpringApplication.run(Java6Application.class, args);
        System.out.println("PS36560 - Nguyễn Tấn Phát");
        System.out.println("Java 6 Application started");
        System.out.println("Version: " + System.getProperty("java.version"));
        System.out.println("Vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java Runtime Environment: " + System.getProperty("java.runtime.name"));

//        KhungLab1();

    }

    //Demo 4
    private static void Bai1D() {
//        Bai1dInterface d = System.out::println;
//
//        d.m1(2021);
    }

    //Demo 3
    private static void Bai1C() {
        Collections.sort(stu,(s1,s2) -> -s1.getMarks().compareTo(s2.getMarks()));
        stu.forEach(n -> System.out.println(n.getName() + " - " + (n.getGender()?"Nam":"Nữ") + " - " + n.getMarks()));
        System.out.println("Top 2 điểm cao nhất:");
        stu.stream().sorted(Comparator
                .comparingDouble(Student::getMarks).reversed())
                .limit(2)
                .forEach(n -> System.out.println(n.getName() + " - " + (n.getGender()?"Nam":"Nữ") + " - " + n.getMarks()));
    }

    //Demo 1
    private static void Bai1A() {
        List<String> number = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        number.forEach(System.out::print);
        System.out.println();
    }

    //Demo 2
    private static void Bai1B() {

        stu.forEach(n -> {
            System.out.println(n.getName() + " - " + (n.getGender()?"Nam":"Nữ") + " - " + n.getMarks());});
    }

    private static void Bai4B() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode students = mapper.readTree(new File(JSON_STUDENTS));
            students.iterator().forEachRemaining(sv ->
            {
                System.out.println("Sinh viên: "+sv.findValue("name").asText());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Bai4A() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode student = mapper.readTree(new File(JSON_STUDENT));
            String name = student.get("name").asText();
            System.out.println("Name: " + name);
            System.out.println("Age: " + student.get("age").asInt());
            System.out.println("Grade: " + student.get("grade").asInt());
//            System.out.println("Phone: " + student.get("contact").get("phone").asText());
            System.out.println("Phone: " + student.findValue("phone").asText());
            System.out.println("Email: " + student.get("contact").get("email").asText());
            System.out.print("Subjects: ");
            student.get("subjects").iterator().forEachRemaining(sub ->
                    System.out.print(sub.asText()+", "));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Bai2A() {
        Stream<Integer> list = Stream.of(1,5,3,4,8);
        list.forEach(System.out::println);
    }

    private static void Bai2B() {
        List<Integer> list = Arrays.asList(4,6,3,8,9);
        List<Double> result = list.stream()
                .filter(n -> n % 2 == 0)//Lọc số chẵn
                .peek(n -> System.out.print("Số chẵn là: "+n +" sau khi căn bậc 2: "))
                .map(Math::sqrt)//Tính căn bậc 2
                .peek(d -> System.out.print(d+"\n"))
                .toList();
    }

    private static void Bai2C() {
        List<Student> result = stu.stream()
                .filter(sv -> sv.getMarks() >= 5)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .toList();

        result.forEach(n -> System.out.println(n.getName() + " - " + (n.getGender()?"Nam":"Nữ") + " - " + n.getMarks()));
    }

    private static void Bai2D() {
        //Tính điểm trung bình
        double average = stu.stream()
                .mapToDouble(Student::getMarks)
                .average().getAsDouble();
        System.out.println("Điểm trung bình toàn bộL: "+average);

        //Tính tổng điểm của tất cả sinh viên
        double sumMarks = stu.stream()
                .mapToDouble(Student::getMarks)
                .sum();
        System.out.println("Tổng điểm của tất cả sinh viên: " + sumMarks);

        //Điểm thấp nhất
        double minMarks = stu.stream()
                .mapToDouble(Student::getMarks)
                .min().getAsDouble();
        System.out.println("Điểm thấp nhất: " + minMarks);

        boolean passedSV = stu.stream().allMatch(sv -> sv.getMarks() >= 5);
        System.out.println(passedSV ? "Tất cả sinh viên đã đạt" : "Tất cả sinh viên chưa đạt");

        //Sinh viên có điểm thấp nhất
        Student st = stu.stream()
                .reduce(stu.get(0),(min,sv) ->  sv.getMarks() < min.getMarks()?sv:min);
        System.out.println("Sinh viên điể thấp nhất: " + st.getName()+" với số điểm "+st.getMarks());

        //Danh sách sinh viên có điểm thấp nhất
        List<Student> maxSV = stu.stream()
                .filter(sv -> sv.getMarks() == minMarks)
                .toList();
        maxSV.forEach(n -> System.out.println(n.getName() + " - " + (n.getGender()?"Nam":"Nữ") + " - " + n.getMarks()));

    }

}
