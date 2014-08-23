/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingsweb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ME
 */
@Entity
public class Subscriber implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    Long memberID;
    String username;
    String email;
    String pwd;
    String firstName;
    String surname;
    Date lastContributionYear;
    Long userRoleID;
    Date subscriptionDate;
    Date validUntil;
    
    public Subscriber(){}

    private Subscriber(Builder aThis) {
        this.memberID = aThis.memberID;
        this.email = aThis.email;
        this.firstName = aThis.firstName;
        this.lastContributionYear = aThis.lastContributionYear;
        this.pwd = aThis.pwd;
        this.surname = aThis.surname;
        this.username = aThis.username;
        this.userRoleID = aThis.userRoleID;
        this.validUntil = aThis.validUntil;
        this.subscriptionDate = aThis.subscriptionDate;
    }
    
    private Subscriber(Subscriber aThis) {
        this.memberID = aThis.memberID;
        this.email = aThis.email;
        this.firstName = aThis.firstName;
        this.lastContributionYear = aThis.lastContributionYear;
        this.pwd = aThis.pwd;
        this.surname = aThis.surname;
        this.username = aThis.username;
        this.userRoleID = aThis.userRoleID;
        this.validUntil = aThis.validUntil;
        this.subscriptionDate = aThis.subscriptionDate;
    }

    public Long getMemberID() {
        return memberID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Date getLastContributionYear() {
        return lastContributionYear;
    }

    public Long getUserRoleID() {
        return userRoleID;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public Date getValidUntil() {
        return validUntil;
    }
        
    public static class Builder{
        Long memberID;
        String username;
        String email;
        String pwd;
        String firstName;
        String surname;
        Date lastContributionYear;
        Long userRoleID;
        Date subscriptionDate;
        Date validUntil;

        public Builder setCemeteryID(Long CemeteryID) {
            this.memberID = CemeteryID;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setLastContributionYear(Date lastContributionYear) {
            this.lastContributionYear = lastContributionYear;
            return this;
        }

        public Builder setUserRoleID(Long userRoleID) {
            this.userRoleID = userRoleID;
            return this;
        }

        public Builder setSubscriptionDate(Date subscriptionDate) {
            this.subscriptionDate = subscriptionDate;
            return this;
        }

        public Builder setValidUntil(Date validUntil) {
            this.validUntil = validUntil;
            return this;
        }
        
        public Subscriber build(){
            return new Subscriber(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.memberID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subscriber other = (Subscriber) obj;
        if (!Objects.equals(this.memberID, other.memberID)) {
            return false;
        }
        return true;
    }
     
}
