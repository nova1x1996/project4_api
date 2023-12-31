
package groub2.backend.controller;
import groub2.backend.entities.Typethuoc;
import groub2.backend.service.TypethuocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typethuoc")
public class TypethuocController {

    @Autowired
    TypethuocService service;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Typethuoc> read() {
        return service.getAll();
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Typethuoc typethuoc) {
        // Check if the name already exists in the database
        if (service.isTypethuocNameExists(typethuoc.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name already exists in the database.");
        }

        boolean created = service.saveTypeThuoc(typethuoc);
        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Creation successful.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Creation unsuccessful.");
        }
    }


    @GetMapping("/edit/{id}")
          @ResponseStatus(HttpStatus.OK)
    public Typethuoc getTypeDoctorByID(@PathVariable int id){
        
        Typethuoc obj = service.findTypethuocbyID(id).get();
        return obj;
    }


    @PutMapping("/edit")
          @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean edit(@RequestBody Typethuoc typethuoc){

        service.editTypethuoc(typethuoc);

        return true;
    }

    
       @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTypethuoc(@PathVariable int id) {
        boolean deleteSuccessful = service.deleteTypethuocId(id);
        if (deleteSuccessful) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Xóa không thành công");
        }
    }
    

    // ...
}
