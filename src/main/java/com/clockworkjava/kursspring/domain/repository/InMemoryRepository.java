package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Scope(value = "singleton")
public class InMemoryRepository implements KnightRepository {

    Map<String, Knight> knights = new HashMap<>();


    public InMemoryRepository() { }

    @Override
    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    @Override
    public void createKnight(String name, Knight knight) {
        knights.put(name,knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        Set<Map.Entry<String, Knight>> enties =  knights.entrySet();
        for(Map.Entry<String, Knight> map: enties) {
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }
        return knights.values();
    }

    @Override
    public Knight getKnight(String name) {
        return knights.get(name);
    }

    @Override
    public void deleteKnight(String name) {
        knights.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public void removeKnight(String name) {
        knights.remove(name);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "knights=" + knights +
                '}';
    }
}
