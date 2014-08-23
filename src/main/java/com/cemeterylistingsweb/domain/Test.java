/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingsweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ME
 */
@Entity
public class Test implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    Long id;
    String name;

    public Test(){}
    
    private Test(Builder aThis) {
        this.id = aThis.id;
        this.name = aThis.name;
    }
  
// Builder class below 
    
        public static class Builder{
             Long id;
             String name;

            public Builder setId(Long id) {
                this.id = id;
                return this;
            }

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder Album(Test t){
                this.id = t.id;
                return this;
            }

            public Test test(){
                return new Test(this);
            }

        }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Test other = (Test) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    // For checking to see the data has been entered into the database 
    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", name=" + name + '}';
    }
        
}
