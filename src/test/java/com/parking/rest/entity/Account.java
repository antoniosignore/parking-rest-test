package com.parking.rest.entity;

import java.util.HashSet;
import java.util.Set;

public class Account {

    private Long id;

    private String name;

    private String password;

    private Set<String> roles = new HashSet<String>();

    private Double latitude;

    private Double longitude;

    public Account() {
        /* Reflection instantiation */
    }

    public Account(String name, String passwordHash) {
        this.name = name;
        this.password = passwordHash;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Set<String> getRoles() {
        return this.roles;
    }


    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }


    public void addRole(String role) {
        this.roles.add(role);
    }


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getUsername() {
        return this.name;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return true;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;

        return true;
    }

    public int hashCode() {
        return id.hashCode();
    }
}