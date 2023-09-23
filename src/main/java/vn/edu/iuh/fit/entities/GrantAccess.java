package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "is_grant",columnDefinition = "enum('1','0','-1')")
    private byte isGrant;
    @Column(columnDefinition = "VARCHAR(50)")
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Account account, Role role, byte isGrant, String note) {
        this.account = account;
        this.role = role;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(byte isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account=" + account +
                ", role=" + role +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantAccess that = (GrantAccess) o;
        return Objects.equals(account, that.account) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, role);
    }
}
