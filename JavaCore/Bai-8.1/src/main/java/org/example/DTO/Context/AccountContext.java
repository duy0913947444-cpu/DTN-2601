package org.example.DTO.Context;

import org.example.Entity.Department;
import org.example.Entity.Position;

import java.util.List;
import java.util.Set;

public class AccountContext {
    private Set<String> sAccountByUserName;
    private Set<String> sAccountByEmail;
    private List<Integer> departmentIDs;
    private List<Integer> positionIDs;

    public AccountContext(Set<String> sAccountByUserName, Set<String> sAccountByEmail, List<Integer> departmentIDs, List<Integer> positionIDs) {
        this.sAccountByUserName = sAccountByUserName;
        this.sAccountByEmail = sAccountByEmail;
        this.departmentIDs = departmentIDs;
        this.positionIDs = positionIDs;
    }

    public Set<String> getsAccountByUserName() {
        return sAccountByUserName;
    }

    public void setsAccountByUserName(Set<String> sAccountByUserName) {
        this.sAccountByUserName = sAccountByUserName;
    }

    public Set<String> getsAccountByEmail() {
        return sAccountByEmail;
    }

    public void setsAccountByEmail(Set<String> sAccountByEmail) {
        this.sAccountByEmail = sAccountByEmail;
    }

    public List<Integer> getDepartmentIDs() {
        return departmentIDs;
    }

    public void setDepartmentIDs(List<Integer> departmentIDs) {
        this.departmentIDs = departmentIDs;
    }

    public List<Integer> getPositionIDs() {
        return positionIDs;
    }

    public void setPositionIDs(List<Integer> positionIDs) {
        this.positionIDs = positionIDs;
    }
}
