package vn.edu.iuh.fit.week01_lab_buingoctung_20064031.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "account")
public class Account {
     @Id

     @Column(name = "account_id",columnDefinition = "varchar(50)")

     private String accountID;
     @Column(name = "full_name",columnDefinition = "VARCHAR(50)")
     private String fullName;
     @Column(columnDefinition = "VARCHAR(50)")
     private String password;
     @Column(columnDefinition = "VARCHAR(50)")
     private String email;
     @Column(columnDefinition = "VARCHAR(50)")
     private String phone;
     @Column(columnDefinition = "TINYINT(4)")

     private int status;

     @OneToMany(mappedBy = "account")

     private List<GrantAccess> listGA;

     public Account() {
     }

     public Account(String accountID, String fullName, String password, String email, String phone, int status) {
          this.accountID = accountID;
          this.fullName = fullName;
          this.password = password;
          this.email = email;
          this.phone = phone;
          this.status = status;
     }

     public String getAccountID() {
          return accountID;
     }

     public void setAccountID(String accountID) {
          this.accountID = accountID;
     }

     public String getFullName() {
          return fullName;
     }

     public void setFullName(String fullName) {
          this.fullName = fullName;
     }

     public String getpassword() {
          return password;
     }

     public void setpassword(String password) {
          this.password = password;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public int getStatus() {
          return status;
     }

     public void setStatus(int status) {
          this.status = status;
     }

     public List<GrantAccess> getListGA() {
          return listGA;
     }

     public void setListGA(List<GrantAccess> listGA) {
          this.listGA = listGA;
     }

     @Override
     public String toString() {
          return "Account{" +
                  "accountID='" + accountID + '\'' +
                  ", fullName='" + fullName + '\'' +
                  ", password='" + password + '\'' +
                  ", email='" + email + '\'' +
                  ", phone='" + phone + '\'' +
                  ", status=" + status +
                  '}';
     }
}
