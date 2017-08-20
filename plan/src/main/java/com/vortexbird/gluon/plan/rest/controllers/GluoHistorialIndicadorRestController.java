package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoHistorialIndicadorMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoHistorialIndicadorDTO;
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
@RequestMapping("/gluoHistorialIndicador")
public class GluoHistorialIndicadorRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoHistorialIndicadorRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoHistorialIndicadorMapper gluoHistorialIndicadorMapper;

    @PostMapping(value = "/saveGluoHistorialIndicador")
    public void saveGluoHistorialIndicador(
        @RequestBody
    GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO)
        throws Exception {
        try {
            GluoHistorialIndicador gluoHistorialIndicador = gluoHistorialIndicadorMapper.gluoHistorialIndicadorDTOToGluoHistorialIndicador(gluoHistorialIndicadorDTO);

            businessDelegatorView.saveGluoHistorialIndicador(gluoHistorialIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoHistorialIndicador/{hiinId}")
    public void deleteGluoHistorialIndicador(
        @PathVariable("hiinId")
    Integer hiinId) throws Exception {
        try {
            GluoHistorialIndicador gluoHistorialIndicador = businessDelegatorView.getGluoHistorialIndicador(hiinId);

            businessDelegatorView.deleteGluoHistorialIndicador(gluoHistorialIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoHistorialIndicador/")
    public void updateGluoHistorialIndicador(
        @RequestBody
    GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO)
        throws Exception {
        try {
            GluoHistorialIndicador gluoHistorialIndicador = gluoHistorialIndicadorMapper.gluoHistorialIndicadorDTOToGluoHistorialIndicador(gluoHistorialIndicadorDTO);

            businessDelegatorView.updateGluoHistorialIndicador(gluoHistorialIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoHistorialIndicador")
    public List<GluoHistorialIndicadorDTO> getDataGluoHistorialIndicador()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoHistorialIndicador();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoHistorialIndicador/{hiinId}")
    public GluoHistorialIndicadorDTO getGluoHistorialIndicador(
        @PathVariable("hiinId")
    Integer hiinId) throws Exception {
        try {
            GluoHistorialIndicador gluoHistorialIndicador = businessDelegatorView.getGluoHistorialIndicador(hiinId);

            return gluoHistorialIndicadorMapper.gluoHistorialIndicadorToGluoHistorialIndicadorDTO(gluoHistorialIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
