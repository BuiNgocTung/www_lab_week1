package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @Column(name = "role_id",columnDefinition = "VARCHAR(50)")
    private String roleID;
    @Column(name = "role_name",columnDefinition = "VARCHAR(50)")
    private String roleName;
    @Column(columnDefinition = "VARCHAR(50)")
    private String description;
    @Column(columnDefinition = "TINYINT(4)")
    private int status;
    @OneToMany(mappedBy = "role")
    private List<GrantAccess> listGA;
    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Role(String roleID, String roleName, String description, int status) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID='" + roleID + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
