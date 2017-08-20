package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoProyectoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;
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
@RequestMapping("/gluoProyecto")
public class GluoProyectoRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoProyectoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoProyectoMapper gluoProyectoMapper;

    @PostMapping(value = "/saveGluoProyecto")
    public void saveGluoProyecto(@RequestBody
    GluoProyectoDTO gluoProyectoDTO) throws Exception {
        try {
            GluoProyecto gluoProyecto = gluoProyectoMapper.gluoProyectoDTOToGluoProyecto(gluoProyectoDTO);

            businessDelegatorView.saveGluoProyecto(gluoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoProyecto/{proyId}")
    public void deleteGluoProyecto(@PathVariable("proyId")
    Integer proyId) throws Exception {
        try {
            GluoProyecto gluoProyecto = businessDelegatorView.getGluoProyecto(proyId);

            businessDelegatorView.deleteGluoProyecto(gluoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoProyecto/")
    public void updateGluoProyecto(@RequestBody
    GluoProyectoDTO gluoProyectoDTO) throws Exception {
        try {
            GluoProyecto gluoProyecto = gluoProyectoMapper.gluoProyectoDTOToGluoProyecto(gluoProyectoDTO);

            businessDelegatorView.updateGluoProyecto(gluoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoProyecto")
    public List<GluoProyectoDTO> getDataGluoProyecto()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoProyecto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoProyecto/{proyId}")
    public GluoProyectoDTO getGluoProyecto(
        @PathVariable("proyId")
    Integer proyId) throws Exception {
        try {
            GluoProyecto gluoProyecto = businessDelegatorView.getGluoProyecto(proyId);

            return gluoProyectoMapper.gluoProyectoToGluoProyectoDTO(gluoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
