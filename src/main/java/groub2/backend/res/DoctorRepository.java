/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package groub2.backend.res;

import groub2.backend.entities.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DELL
 */
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
        
      @Query("SELECT d, AVG(r.rating) AS average_rating FROM Doctor d LEFT JOIN Rating r ON d.id = r.doctorId.id GROUP BY d.id, d.name, d.role, d.typeDoctorId, d.email, d.address, d.gender, d.image, d.createAt, d.password, d.username")
List<Object> getDoctorsWithAverageRating();
      boolean existsByEmail(String email);
}
