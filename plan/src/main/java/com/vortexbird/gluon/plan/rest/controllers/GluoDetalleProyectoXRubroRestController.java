package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoDetalleProyectoXRubroMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;
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
@RequestMapping("/gluoDetalleProyectoXRubro")
public class GluoDetalleProyectoXRubroRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoXRubroRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoDetalleProyectoXRubroMapper gluoDetalleProyectoXRubroMapper;

    @PostMapping(value = "/saveGluoDetalleProyectoXRubro")
    public void saveGluoDetalleProyectoXRubro(
        @RequestBody
    GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO)
        throws Exception {
        try {
            GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = gluoDetalleProyectoXRubroMapper.gluoDetalleProyectoXRubroDTOToGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubroDTO);

            businessDelegatorView.saveGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoDetalleProyectoXRubro/{dpruId}")
    public void deleteGluoDetalleProyectoXRubro(
        @PathVariable("dpruId")
    Integer dpruId) throws Exception {
        try {
            GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId);

            businessDelegatorView.deleteGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoDetalleProyectoXRubro/")
    public void updateGluoDetalleProyectoXRubro(
        @RequestBody
    GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO)
        throws Exception {
        try {
            GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = gluoDetalleProyectoXRubroMapper.gluoDetalleProyectoXRubroDTOToGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubroDTO);

            businessDelegatorView.updateGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoDetalleProyectoXRubro")
    public List<GluoDetalleProyectoXRubroDTO> getDataGluoDetalleProyectoXRubro()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoDetalleProyectoXRubro();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoDetalleProyectoXRubro/{dpruId}")
    public GluoDetalleProyectoXRubroDTO getGluoDetalleProyectoXRubro(
        @PathVariable("dpruId")
    Integer dpruId) throws Exception {
        try {
            GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId);

            return gluoDetalleProyectoXRubroMapper.gluoDetalleProyectoXRubroToGluoDetalleProyectoXRubroDTO(gluoDetalleProyectoXRubro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
