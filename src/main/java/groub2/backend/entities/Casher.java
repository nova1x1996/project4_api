/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groub2.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "casher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casher.findAll", query = "SELECT c FROM Casher c"),
    @NamedQuery(name = "Casher.findById", query = "SELECT c FROM Casher c WHERE c.id = :id"),
    @NamedQuery(name = "Casher.findByName", query = "SELECT c FROM Casher c WHERE c.name = :name"),
    @NamedQuery(name = "Casher.findByDob", query = "SELECT c FROM Casher c WHERE c.dob = :dob"),
    @NamedQuery(name = "Casher.findByPassword", query = "SELECT c FROM Casher c WHERE c.password = :password"),
    @NamedQuery(name = "Casher.findByEmail", query = "SELECT c FROM Casher c WHERE c.email = :email"),
    @NamedQuery(name = "Casher.findByAddress", query = "SELECT c FROM Casher c WHERE c.address = :address"),
    @NamedQuery(name = "Casher.findByRole", query = "SELECT c FROM Casher c WHERE c.role = :role"),
    @NamedQuery(name = "Casher.findByPhone", query = "SELECT c FROM Casher c WHERE c.phone = :phone"),
    @NamedQuery(name = "Casher.findByCreateAt", query = "SELECT c FROM Casher c WHERE c.createAt = :createAt"),
    @NamedQuery(name = "Casher.findByGender", query = "SELECT c FROM Casher c WHERE c.gender = :gender")})
public class Casher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = "Name cannot be left blank!!!")
    @Length(min = 3, max = 50, message = "Name must be from 3 to 50 characters")
    private String name;
    @Size(max = 250)
    @Column(name = "phone")
    @NotBlank(message = "Phone cannot be left blank!!!")
    @Pattern(regexp = "^[0-9]*$", message = "Phone must contain only numbers")
    private String phone;
    @Column(name = "password")
    @NotBlank(message = "Password cannot be left blank!!!")
    @Length(min = 8, max = 100, message = "Password must be from 8 to 100 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$", message = "Invalid password")
    private String password;

    @Column(name = "email")
    @NotBlank(message = "Email cannot be left blank!!!")
//    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
//    @Length(min = 11, message = "Email must have at least 11 characters")
    @Email
    private String email;
    @Size(max = 250)
    @Column(name = "address")
    @NotBlank(message = "Address cannot be left blank!!!")
    @Length(min = 10, max = 150, message = "Address must be from 10 to 150 characters")
    private String address;

    @Size(max = 50)
    @Column(name = "role")
    private String role;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Dob cannot be null")
    private Date dob;
    @Column(name = "gender")
    @NotNull(message = "Gender cannot be null")
    private Boolean gender;
    @OneToMany(mappedBy = "casherId")
    @JsonIgnore
    private Collection<Donthuoc> donthuocCollection;
    @OneToMany(mappedBy = "casherId")
    @JsonIgnore
    private Collection<Taophieukham> taophieukhamCollection;

    public Casher() {
    }

    public Casher(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @XmlTransient
    public Collection<Donthuoc> getDonthuocCollection() {
        return donthuocCollection;
    }

    public void setDonthuocCollection(Collection<Donthuoc> donthuocCollection) {
        this.donthuocCollection = donthuocCollection;
    }

    @XmlTransient
    public Collection<Taophieukham> getTaophieukhamCollection() {
        return taophieukhamCollection;
    }

    public void setTaophieukhamCollection(Collection<Taophieukham> taophieukhamCollection) {
        this.taophieukhamCollection = taophieukhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casher)) {
            return false;
        }
        Casher other = (Casher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groub2.backend.entities.Casher[ id=" + id + " ]";
    }

}
