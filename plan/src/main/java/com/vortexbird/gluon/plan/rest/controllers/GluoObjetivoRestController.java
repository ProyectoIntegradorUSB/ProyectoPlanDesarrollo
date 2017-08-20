package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoObjetivoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoObjetivoDTO;
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
@RequestMapping("/gluoObjetivo")
public class GluoObjetivoRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoObjetivoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoObjetivoMapper gluoObjetivoMapper;

    @PostMapping(value = "/saveGluoObjetivo")
    public void saveGluoObjetivo(@RequestBody
    GluoObjetivoDTO gluoObjetivoDTO) throws Exception {
        try {
            GluoObjetivo gluoObjetivo = gluoObjetivoMapper.gluoObjetivoDTOToGluoObjetivo(gluoObjetivoDTO);

            businessDelegatorView.saveGluoObjetivo(gluoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoObjetivo/{objeId}")
    public void deleteGluoObjetivo(@PathVariable("objeId")
    Integer objeId) throws Exception {
        try {
            GluoObjetivo gluoObjetivo = businessDelegatorView.getGluoObjetivo(objeId);

            businessDelegatorView.deleteGluoObjetivo(gluoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoObjetivo/")
    public void updateGluoObjetivo(@RequestBody
    GluoObjetivoDTO gluoObjetivoDTO) throws Exception {
        try {
            GluoObjetivo gluoObjetivo = gluoObjetivoMapper.gluoObjetivoDTOToGluoObjetivo(gluoObjetivoDTO);

            businessDelegatorView.updateGluoObjetivo(gluoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoObjetivo")
    public List<GluoObjetivoDTO> getDataGluoObjetivo()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoObjetivo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoObjetivo/{objeId}")
    public GluoObjetivoDTO getGluoObjetivo(
        @PathVariable("objeId")
    Integer objeId) throws Exception {
        try {
            GluoObjetivo gluoObjetivo = businessDelegatorView.getGluoObjetivo(objeId);

            return gluoObjetivoMapper.gluoObjetivoToGluoObjetivoDTO(gluoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
