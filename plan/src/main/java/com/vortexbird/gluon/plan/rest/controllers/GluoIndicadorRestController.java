package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoIndicadorMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoIndicadorDTO;
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
@RequestMapping("/gluoIndicador")
public class GluoIndicadorRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoIndicadorRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoIndicadorMapper gluoIndicadorMapper;

    @PostMapping(value = "/saveGluoIndicador")
    public void saveGluoIndicador(@RequestBody
    GluoIndicadorDTO gluoIndicadorDTO) throws Exception {
        try {
            GluoIndicador gluoIndicador = gluoIndicadorMapper.gluoIndicadorDTOToGluoIndicador(gluoIndicadorDTO);

            businessDelegatorView.saveGluoIndicador(gluoIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoIndicador/{indiId}")
    public void deleteGluoIndicador(@PathVariable("indiId")
    Integer indiId) throws Exception {
        try {
            GluoIndicador gluoIndicador = businessDelegatorView.getGluoIndicador(indiId);

            businessDelegatorView.deleteGluoIndicador(gluoIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoIndicador/")
    public void updateGluoIndicador(
        @RequestBody
    GluoIndicadorDTO gluoIndicadorDTO) throws Exception {
        try {
            GluoIndicador gluoIndicador = gluoIndicadorMapper.gluoIndicadorDTOToGluoIndicador(gluoIndicadorDTO);

            businessDelegatorView.updateGluoIndicador(gluoIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoIndicador")
    public List<GluoIndicadorDTO> getDataGluoIndicador()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoIndicador();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoIndicador/{indiId}")
    public GluoIndicadorDTO getGluoIndicador(
        @PathVariable("indiId")
    Integer indiId) throws Exception {
        try {
            GluoIndicador gluoIndicador = businessDelegatorView.getGluoIndicador(indiId);

            return gluoIndicadorMapper.gluoIndicadorToGluoIndicadorDTO(gluoIndicador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
