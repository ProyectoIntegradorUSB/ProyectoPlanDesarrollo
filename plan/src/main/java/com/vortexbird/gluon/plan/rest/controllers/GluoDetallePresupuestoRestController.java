package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoDetallePresupuestoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetallePresupuestoDTO;
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
@RequestMapping("/gluoDetallePresupuesto")
public class GluoDetallePresupuestoRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoDetallePresupuestoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoDetallePresupuestoMapper gluoDetallePresupuestoMapper;

    @PostMapping(value = "/saveGluoDetallePresupuesto")
    public void saveGluoDetallePresupuesto(
        @RequestBody
    GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO)
        throws Exception {
        try {
            GluoDetallePresupuesto gluoDetallePresupuesto = gluoDetallePresupuestoMapper.gluoDetallePresupuestoDTOToGluoDetallePresupuesto(gluoDetallePresupuestoDTO);

            businessDelegatorView.saveGluoDetallePresupuesto(gluoDetallePresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoDetallePresupuesto/{dptoId}")
    public void deleteGluoDetallePresupuesto(
        @PathVariable("dptoId")
    Integer dptoId) throws Exception {
        try {
            GluoDetallePresupuesto gluoDetallePresupuesto = businessDelegatorView.getGluoDetallePresupuesto(dptoId);

            businessDelegatorView.deleteGluoDetallePresupuesto(gluoDetallePresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoDetallePresupuesto/")
    public void updateGluoDetallePresupuesto(
        @RequestBody
    GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO)
        throws Exception {
        try {
            GluoDetallePresupuesto gluoDetallePresupuesto = gluoDetallePresupuestoMapper.gluoDetallePresupuestoDTOToGluoDetallePresupuesto(gluoDetallePresupuestoDTO);

            businessDelegatorView.updateGluoDetallePresupuesto(gluoDetallePresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoDetallePresupuesto")
    public List<GluoDetallePresupuestoDTO> getDataGluoDetallePresupuesto()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoDetallePresupuesto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoDetallePresupuesto/{dptoId}")
    public GluoDetallePresupuestoDTO getGluoDetallePresupuesto(
        @PathVariable("dptoId")
    Integer dptoId) throws Exception {
        try {
            GluoDetallePresupuesto gluoDetallePresupuesto = businessDelegatorView.getGluoDetallePresupuesto(dptoId);

            return gluoDetallePresupuestoMapper.gluoDetallePresupuestoToGluoDetallePresupuestoDTO(gluoDetallePresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
