package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoPresupuestoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPresupuestoDTO;
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
@RequestMapping("/gluoPresupuesto")
public class GluoPresupuestoRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoPresupuestoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoPresupuestoMapper gluoPresupuestoMapper;

    @PostMapping(value = "/saveGluoPresupuesto")
    public void saveGluoPresupuesto(
        @RequestBody
    GluoPresupuestoDTO gluoPresupuestoDTO) throws Exception {
        try {
            GluoPresupuesto gluoPresupuesto = gluoPresupuestoMapper.gluoPresupuestoDTOToGluoPresupuesto(gluoPresupuestoDTO);

            businessDelegatorView.saveGluoPresupuesto(gluoPresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoPresupuesto/{pptoId}")
    public void deleteGluoPresupuesto(@PathVariable("pptoId")
    Integer pptoId) throws Exception {
        try {
            GluoPresupuesto gluoPresupuesto = businessDelegatorView.getGluoPresupuesto(pptoId);

            businessDelegatorView.deleteGluoPresupuesto(gluoPresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoPresupuesto/")
    public void updateGluoPresupuesto(
        @RequestBody
    GluoPresupuestoDTO gluoPresupuestoDTO) throws Exception {
        try {
            GluoPresupuesto gluoPresupuesto = gluoPresupuestoMapper.gluoPresupuestoDTOToGluoPresupuesto(gluoPresupuestoDTO);

            businessDelegatorView.updateGluoPresupuesto(gluoPresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoPresupuesto")
    public List<GluoPresupuestoDTO> getDataGluoPresupuesto()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoPresupuesto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoPresupuesto/{pptoId}")
    public GluoPresupuestoDTO getGluoPresupuesto(
        @PathVariable("pptoId")
    Integer pptoId) throws Exception {
        try {
            GluoPresupuesto gluoPresupuesto = businessDelegatorView.getGluoPresupuesto(pptoId);

            return gluoPresupuestoMapper.gluoPresupuestoToGluoPresupuestoDTO(gluoPresupuesto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
