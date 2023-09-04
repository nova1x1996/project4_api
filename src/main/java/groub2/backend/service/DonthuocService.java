package groub2.backend.service;

import groub2.backend.entities.Donthuoc;
import groub2.backend.res.DonthuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonthuocService {
    @Autowired
    DonthuocRepository res;
    public List<Donthuoc> getAll() {
        return res.findAll();
    }

    public boolean saveDonthuoc(Donthuoc donthuoc) {

        try {
            res.save(donthuoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




}