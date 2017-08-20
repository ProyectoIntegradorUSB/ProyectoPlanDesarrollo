package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoAnoFiscalMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoAnoFiscalDTO;
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
@RequestMapping("/gluoAnoFiscal")
public class GluoAnoFiscalRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoAnoFiscalRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoAnoFiscalMapper gluoAnoFiscalMapper;

    @PostMapping(value = "/saveGluoAnoFiscal")
    public void saveGluoAnoFiscal(@RequestBody
    GluoAnoFiscalDTO gluoAnoFiscalDTO) throws Exception {
        try {
            GluoAnoFiscal gluoAnoFiscal = gluoAnoFiscalMapper.gluoAnoFiscalDTOToGluoAnoFiscal(gluoAnoFiscalDTO);

            businessDelegatorView.saveGluoAnoFiscal(gluoAnoFiscal);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoAnoFiscal/{anofId}")
    public void deleteGluoAnoFiscal(@PathVariable("anofId")
    Integer anofId) throws Exception {
        try {
            GluoAnoFiscal gluoAnoFiscal = businessDelegatorView.getGluoAnoFiscal(anofId);

            businessDelegatorView.deleteGluoAnoFiscal(gluoAnoFiscal);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoAnoFiscal/")
    public void updateGluoAnoFiscal(
        @RequestBody
    GluoAnoFiscalDTO gluoAnoFiscalDTO) throws Exception {
        try {
            GluoAnoFiscal gluoAnoFiscal = gluoAnoFiscalMapper.gluoAnoFiscalDTOToGluoAnoFiscal(gluoAnoFiscalDTO);

            businessDelegatorView.updateGluoAnoFiscal(gluoAnoFiscal);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoAnoFiscal")
    public List<GluoAnoFiscalDTO> getDataGluoAnoFiscal()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoAnoFiscal();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoAnoFiscal/{anofId}")
    public GluoAnoFiscalDTO getGluoAnoFiscal(
        @PathVariable("anofId")
    Integer anofId) throws Exception {
        try {
            GluoAnoFiscal gluoAnoFiscal = businessDelegatorView.getGluoAnoFiscal(anofId);

            return gluoAnoFiscalMapper.gluoAnoFiscalToGluoAnoFiscalDTO(gluoAnoFiscal);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
