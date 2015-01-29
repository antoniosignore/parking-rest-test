package com.parking.rest.entity;

import java.io.Serializable;

public class UserGroup  {

    private Long id;

    private String groupName;

    private String groupDesc;

    private Account account;

    public UserGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroup)) return false;

        UserGroup that = (UserGroup) o;

        if (!account.equals(that.account)) return false;
        if (!groupDesc.equals(that.groupDesc)) return false;
        if (!groupName.equals(that.groupName)) return false;
        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + groupName.hashCode();
        result = 31 * result + groupDesc.hashCode();
        result = 31 * result + account.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AccountGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", account=" + account +
                '}';
    }
}