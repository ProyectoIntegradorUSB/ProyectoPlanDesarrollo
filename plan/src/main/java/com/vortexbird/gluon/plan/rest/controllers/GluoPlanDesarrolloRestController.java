package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoPlanDesarrolloMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/gluoPlanDesarrollo")
public class GluoPlanDesarrolloRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoPlanDesarrolloRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoPlanDesarrolloMapper gluoPlanDesarrolloMapper;

    @PostMapping(value = "/saveGluoPlanDesarrollo")
    public void saveGluoPlanDesarrollo(
        @RequestBody
    GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception {
        try {
            GluoPlanDesarrollo gluoPlanDesarrollo = gluoPlanDesarrolloMapper.gluoPlanDesarrolloDTOToGluoPlanDesarrollo(gluoPlanDesarrolloDTO);

            businessDelegatorView.saveGluoPlanDesarrollo(gluoPlanDesarrollo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoPlanDesarrollo/{planId}")
    public void deleteGluoPlanDesarrollo(@PathVariable("planId")
    Integer planId) throws Exception {
        try {
            GluoPlanDesarrollo gluoPlanDesarrollo = businessDelegatorView.getGluoPlanDesarrollo(planId);

            businessDelegatorView.deleteGluoPlanDesarrollo(gluoPlanDesarrollo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoPlanDesarrollo/")
    public void updateGluoPlanDesarrollo(
        @RequestBody
    GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception {
        try {
            GluoPlanDesarrollo gluoPlanDesarrollo = gluoPlanDesarrolloMapper.gluoPlanDesarrolloDTOToGluoPlanDesarrollo(gluoPlanDesarrolloDTO);

            businessDelegatorView.updateGluoPlanDesarrollo(gluoPlanDesarrollo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoPlanDesarrollo")
    public List<GluoPlanDesarrolloDTO> getDataGluoPlanDesarrollo()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoPlanDesarrollo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoPlanDesarrollo/{planId}")
    public GluoPlanDesarrolloDTO getGluoPlanDesarrollo(
        @PathVariable("planId")
    Integer planId) throws Exception {
        try {
            GluoPlanDesarrollo gluoPlanDesarrollo = businessDelegatorView.getGluoPlanDesarrollo(planId);

            return gluoPlanDesarrolloMapper.gluoPlanDesarrolloToGluoPlanDesarrolloDTO(gluoPlanDesarrollo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
