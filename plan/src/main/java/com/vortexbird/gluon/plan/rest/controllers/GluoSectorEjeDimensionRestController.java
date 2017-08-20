package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.IGluoSectorEjeDimensionMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSectorEjeDimensionDTO;
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
@RequestMapping("/gluoSectorEjeDimension")
public class GluoSectorEjeDimensionRestController {
    private static final Logger log = LoggerFactory.getLogger(GluoSectorEjeDimensionRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGluoSectorEjeDimensionMapper gluoSectorEjeDimensionMapper;

    @PostMapping(value = "/saveGluoSectorEjeDimension")
    public void saveGluoSectorEjeDimension(
        @RequestBody
    GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO)
        throws Exception {
        try {
            GluoSectorEjeDimension gluoSectorEjeDimension = gluoSectorEjeDimensionMapper.gluoSectorEjeDimensionDTOToGluoSectorEjeDimension(gluoSectorEjeDimensionDTO);

            businessDelegatorView.saveGluoSectorEjeDimension(gluoSectorEjeDimension);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGluoSectorEjeDimension/{sediId}")
    public void deleteGluoSectorEjeDimension(
        @PathVariable("sediId")
    Integer sediId) throws Exception {
        try {
            GluoSectorEjeDimension gluoSectorEjeDimension = businessDelegatorView.getGluoSectorEjeDimension(sediId);

            businessDelegatorView.deleteGluoSectorEjeDimension(gluoSectorEjeDimension);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGluoSectorEjeDimension/")
    public void updateGluoSectorEjeDimension(
        @RequestBody
    GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO)
        throws Exception {
        try {
            GluoSectorEjeDimension gluoSectorEjeDimension = gluoSectorEjeDimensionMapper.gluoSectorEjeDimensionDTOToGluoSectorEjeDimension(gluoSectorEjeDimensionDTO);

            businessDelegatorView.updateGluoSectorEjeDimension(gluoSectorEjeDimension);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGluoSectorEjeDimension")
    public List<GluoSectorEjeDimensionDTO> getDataGluoSectorEjeDimension()
        throws Exception {
        try {
            return businessDelegatorView.getDataGluoSectorEjeDimension();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGluoSectorEjeDimension/{sediId}")
    public GluoSectorEjeDimensionDTO getGluoSectorEjeDimension(
        @PathVariable("sediId")
    Integer sediId) throws Exception {
        try {
            GluoSectorEjeDimension gluoSectorEjeDimension = businessDelegatorView.getGluoSectorEjeDimension(sediId);

            return gluoSectorEjeDimensionMapper.gluoSectorEjeDimensionToGluoSectorEjeDimensionDTO(gluoSectorEjeDimension);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
