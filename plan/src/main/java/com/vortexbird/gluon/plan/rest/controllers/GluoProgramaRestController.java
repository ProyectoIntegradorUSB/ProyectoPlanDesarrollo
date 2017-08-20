package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoProgramaMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProgramaDTO;
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
@RequestMapping("/gluoPrograma")
public class GluoProgramaRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoProgramaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoProgramaMapper gluoProgramaMapper;

    @PostMapping(value = "/saveGluoPrograma")
    public void saveGluoPrograma(@RequestBody
    GluoProgramaDTO gluoProgramaDTO) throws Exception {
        try {
            GluoPrograma gluoPrograma = gluoProgramaMapper.gluoProgramaDTOToGluoPrograma(gluoProgramaDTO);

            businessDelegatorView.saveGluoPrograma(gluoPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoPrograma/{progId}")
    public void deleteGluoPrograma(@PathVariable("progId")
    Integer progId) throws Exception {
        try {
            GluoPrograma gluoPrograma = businessDelegatorView.getGluoPrograma(progId);

            businessDelegatorView.deleteGluoPrograma(gluoPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoPrograma/")
    public void updateGluoPrograma(@RequestBody
    GluoProgramaDTO gluoProgramaDTO) throws Exception {
        try {
            GluoPrograma gluoPrograma = gluoProgramaMapper.gluoProgramaDTOToGluoPrograma(gluoProgramaDTO);

            businessDelegatorView.updateGluoPrograma(gluoPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoPrograma")
    public List<GluoProgramaDTO> getDataGluoPrograma()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoPrograma();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoPrograma/{progId}")
    public GluoProgramaDTO getGluoPrograma(
        @PathVariable("progId")
    Integer progId) throws Exception {
        try {
            GluoPrograma gluoPrograma = businessDelegatorView.getGluoPrograma(progId);

            return gluoProgramaMapper.gluoProgramaToGluoProgramaDTO(gluoPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
