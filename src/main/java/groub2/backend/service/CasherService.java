package groub2.backend.service;

import groub2.backend.entities.Casher;
import groub2.backend.res.CasherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CasherService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    CasherRepository res;

    public List<Casher> findAll() {
        return res.findAll();
    }

    public Casher getCasherById(Integer id) {
        return res.findById(id).orElse(null);
    }

    public void addCasher(Casher newCasher) {
        newCasher.setCreateAt(new java.util.Date());
        res.save(newCasher);
    }

//    public Casher detailCasher(Casher updatedCasher) {
//        Casher casher = res.findById(updatedCasher.getId()).orElse(null);
//        if (casher != null) {
//            // Kiểm tra xem các trường có được cung cấp để cập nhật hay không
////            if (updatedCasher.getPassword() != null) {
////                casher.setPassword(bCryptPasswordEncoder.encode(updatedCasher.getPassword()));
////            }
//            if (updatedCasher.getEmail() != null) {
//                casher.setEmail(updatedCasher.getEmail());
//            }
//            if (updatedCasher.getAddress() != null) {
//                casher.setAddress(updatedCasher.getAddress());
//            }
//
//            // Cập nhật ngày tạo mới
//            casher.setCreateAt(new java.util.Date());
//
//            // Lưu đối tượng Casher đã cập nhật vào cơ sở dữ liệu
//            return res.save(casher);
//        }
//        return null;
//    }

//    public void changePassword(Integer id, String newPasssword, Casher changePass) {
//        res.changePassword(id, newPasssword);
        
//        if (casher != null) {
//            // Kiểm tra xem các trường có được cung cấp để cập nhật hay không
//            if (casher.getPassword() != null) {
//                casher.setPassword(casher.getPassword()); // Thay đổi mật khẩu
//            }
//
//            // Cập nhật ngày tạo mới
//            casher.setCreateAt(new java.util.Date());
//
//            // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
//            casher.setPassword(bCryptPasswordEncoder.encode(casher.getPassword()));
//
//            // Lưu đối tượng Casher đã cập nhật vào cơ sở dữ liệu
//            return res.save(casher);
//        }
//        return null;
//    }

    public void deleteCasher(Integer id) {
        res.deleteById(id);
    }
}
