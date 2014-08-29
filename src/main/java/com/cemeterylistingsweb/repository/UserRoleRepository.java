/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingsweb.repository;

import com.cemeterylistingsweb.domain.UserRole;
import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kurvin Hendricks
 */
@Entity
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    
}
