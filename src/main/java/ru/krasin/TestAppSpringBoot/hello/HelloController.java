package ru.krasin.TestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    private List<String> stringList = new ArrayList<>();
    private Map<String, String> stringMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        stringList.add(s);
        return "Value added to ArrayList.";
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return stringList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String key, @RequestParam String value) {
        stringMap.put(key, value);
        return "Value added to HashMap.";
    }

    @GetMapping("/show-map")
    public Map<String, String> showHashMap() {
        return stringMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int listSize = stringList.size();
        int mapSize = stringMap.size();
        return "ArrayList Length: " + listSize + "<br>HashMap Size: " + mapSize;
    }
}
