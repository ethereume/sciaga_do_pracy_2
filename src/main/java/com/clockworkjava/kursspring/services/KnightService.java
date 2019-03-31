package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnightService {

    KnightRepository knightRepository;

    public KnightService(KnightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }
    public void addKnight(Knight knight) {
        knightRepository.createKnight(knight.getName(),knight);
    }
    public Knight getKnightByName(String name) {
        return knightRepository.getKnight(name);
    }

    public void removeKight(String name) {
        knightRepository.removeKnight(name);
    }
}
