package br.com.marcelino.parking.service;

import br.com.marcelino.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id1 = getUUID();
        var id2 = getUUID();
        Parking parking1 = new Parking(id1, "DMS-4569", "SC", "CELTA", "PRETO");
        Parking parking2 = new Parking(id2, "TJF-5689", "SP", "GOL", "PRETO");
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
    }

    public List<Parking> findAll() {
        return parkingMap.values().
                stream().
                collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-" , "");
    }


    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}
