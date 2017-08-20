package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoSubprogramaMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;
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
@RequestMapping("/gluoSubprograma")
public class GluoSubprogramaRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoSubprogramaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoSubprogramaMapper gluoSubprogramaMapper;

    @PostMapping(value = "/saveGluoSubprograma")
    public void saveGluoSubprograma(
        @RequestBody
    GluoSubprogramaDTO gluoSubprogramaDTO) throws Exception {
        try {
            GluoSubprograma gluoSubprograma = gluoSubprogramaMapper.gluoSubprogramaDTOToGluoSubprograma(gluoSubprogramaDTO);

            businessDelegatorView.saveGluoSubprograma(gluoSubprograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoSubprograma/{subpId}")
    public void deleteGluoSubprograma(@PathVariable("subpId")
    Integer subpId) throws Exception {
        try {
            GluoSubprograma gluoSubprograma = businessDelegatorView.getGluoSubprograma(subpId);

            businessDelegatorView.deleteGluoSubprograma(gluoSubprograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoSubprograma/")
    public void updateGluoSubprograma(
        @RequestBody
    GluoSubprogramaDTO gluoSubprogramaDTO) throws Exception {
        try {
            GluoSubprograma gluoSubprograma = gluoSubprogramaMapper.gluoSubprogramaDTOToGluoSubprograma(gluoSubprogramaDTO);

            businessDelegatorView.updateGluoSubprograma(gluoSubprograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoSubprograma")
    public List<GluoSubprogramaDTO> getDataGluoSubprograma()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoSubprograma();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoSubprograma/{subpId}")
    public GluoSubprogramaDTO getGluoSubprograma(
        @PathVariable("subpId")
    Integer subpId) throws Exception {
        try {
            GluoSubprograma gluoSubprograma = businessDelegatorView.getGluoSubprograma(subpId);

            return gluoSubprogramaMapper.gluoSubprogramaToGluoSubprogramaDTO(gluoSubprograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
