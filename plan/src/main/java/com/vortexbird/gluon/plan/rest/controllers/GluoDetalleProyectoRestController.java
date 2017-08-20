package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoDetalleProyectoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoDTO;
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
@RequestMapping("/gluoDetalleProyecto")
public class GluoDetalleProyectoRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoDetalleProyectoMapper gluoDetalleProyectoMapper;

    @PostMapping(value = "/saveGluoDetalleProyecto")
    public void saveGluoDetalleProyecto(
        @RequestBody
    GluoDetalleProyectoDTO gluoDetalleProyectoDTO) throws Exception {
        try {
            GluoDetalleProyecto gluoDetalleProyecto = gluoDetalleProyectoMapper.gluoDetalleProyectoDTOToGluoDetalleProyecto(gluoDetalleProyectoDTO);

            businessDelegatorView.saveGluoDetalleProyecto(gluoDetalleProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoDetalleProyecto/{dproId}")
    public void deleteGluoDetalleProyecto(@PathVariable("dproId")
    Integer dproId) throws Exception {
        try {
            GluoDetalleProyecto gluoDetalleProyecto = businessDelegatorView.getGluoDetalleProyecto(dproId);

            businessDelegatorView.deleteGluoDetalleProyecto(gluoDetalleProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoDetalleProyecto/")
    public void updateGluoDetalleProyecto(
        @RequestBody
    GluoDetalleProyectoDTO gluoDetalleProyectoDTO) throws Exception {
        try {
            GluoDetalleProyecto gluoDetalleProyecto = gluoDetalleProyectoMapper.gluoDetalleProyectoDTOToGluoDetalleProyecto(gluoDetalleProyectoDTO);

            businessDelegatorView.updateGluoDetalleProyecto(gluoDetalleProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoDetalleProyecto")
    public List<GluoDetalleProyectoDTO> getDataGluoDetalleProyecto()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoDetalleProyecto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoDetalleProyecto/{dproId}")
    public GluoDetalleProyectoDTO getGluoDetalleProyecto(
        @PathVariable("dproId")
    Integer dproId) throws Exception {
        try {
            GluoDetalleProyecto gluoDetalleProyecto = businessDelegatorView.getGluoDetalleProyecto(dproId);

            return gluoDetalleProyectoMapper.gluoDetalleProyectoToGluoDetalleProyectoDTO(gluoDetalleProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
