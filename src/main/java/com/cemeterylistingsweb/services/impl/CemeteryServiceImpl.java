/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cemeterylistingsweb.services.impl;

import com.cemeterylistingsweb.domain.Cemetery;
import com.cemeterylistingsweb.repository.CemeteryRepository;
import com.cemeterylistingsweb.services.CemeteryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Kurvin Hendricks
 */
public class CemeteryServiceImpl implements CemeteryService{

    @Autowired
    private CemeteryRepository cemeteryRepository;
    
    @Override
    public Cemetery find(Long id) {
        return cemeteryRepository.findOne(id);
    }

    @Override
    public Cemetery persist(Cemetery entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cemetery merge(Cemetery entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Cemetery entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cemetery> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
