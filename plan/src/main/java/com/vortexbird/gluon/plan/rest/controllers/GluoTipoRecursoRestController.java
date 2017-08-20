package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoTipoRecursoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoTipoRecursoDTO;
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
@RequestMapping("/gluoTipoRecurso")
public class GluoTipoRecursoRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoTipoRecursoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoTipoRecursoMapper gluoTipoRecursoMapper;

    @PostMapping(value = "/saveGluoTipoRecurso")
    public void saveGluoTipoRecurso(
        @RequestBody
    GluoTipoRecursoDTO gluoTipoRecursoDTO) throws Exception {
        try {
            GluoTipoRecurso gluoTipoRecurso = gluoTipoRecursoMapper.gluoTipoRecursoDTOToGluoTipoRecurso(gluoTipoRecursoDTO);

            businessDelegatorView.saveGluoTipoRecurso(gluoTipoRecurso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoTipoRecurso/{tireId}")
    public void deleteGluoTipoRecurso(@PathVariable("tireId")
    Integer tireId) throws Exception {
        try {
            GluoTipoRecurso gluoTipoRecurso = businessDelegatorView.getGluoTipoRecurso(tireId);

            businessDelegatorView.deleteGluoTipoRecurso(gluoTipoRecurso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoTipoRecurso/")
    public void updateGluoTipoRecurso(
        @RequestBody
    GluoTipoRecursoDTO gluoTipoRecursoDTO) throws Exception {
        try {
            GluoTipoRecurso gluoTipoRecurso = gluoTipoRecursoMapper.gluoTipoRecursoDTOToGluoTipoRecurso(gluoTipoRecursoDTO);

            businessDelegatorView.updateGluoTipoRecurso(gluoTipoRecurso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoTipoRecurso")
    public List<GluoTipoRecursoDTO> getDataGluoTipoRecurso()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoTipoRecurso();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoTipoRecurso/{tireId}")
    public GluoTipoRecursoDTO getGluoTipoRecurso(
        @PathVariable("tireId")
    Integer tireId) throws Exception {
        try {
            GluoTipoRecurso gluoTipoRecurso = businessDelegatorView.getGluoTipoRecurso(tireId);

            return gluoTipoRecursoMapper.gluoTipoRecursoToGluoTipoRecursoDTO(gluoTipoRecurso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
