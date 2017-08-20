package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.ISegOpcionMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegOpcionDTO;
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
@RequestMapping("/segOpcion")
public class SegOpcionRestController {
    private static final Logger log = LoggerFactory.getLogger(SegOpcionRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISegOpcionMapper segOpcionMapper;

    @PostMapping(value = "/saveSegOpcion")
    public void saveSegOpcion(@RequestBody
    SegOpcionDTO segOpcionDTO) throws Exception {
        try {
            SegOpcion segOpcion = segOpcionMapper.segOpcionDTOToSegOpcion(segOpcionDTO);

            businessDelegatorView.saveSegOpcion(segOpcion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSegOpcion/{opcnId}")
    public void deleteSegOpcion(@PathVariable("opcnId")
    Integer opcnId) throws Exception {
        try {
            SegOpcion segOpcion = businessDelegatorView.getSegOpcion(opcnId);

            businessDelegatorView.deleteSegOpcion(segOpcion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSegOpcion/")
    public void updateSegOpcion(@RequestBody
    SegOpcionDTO segOpcionDTO) throws Exception {
        try {
            SegOpcion segOpcion = segOpcionMapper.segOpcionDTOToSegOpcion(segOpcionDTO);

            businessDelegatorView.updateSegOpcion(segOpcion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSegOpcion")
    public List<SegOpcionDTO> getDataSegOpcion() throws Exception {
        try {
            return businessDelegatorView.getDataSegOpcion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSegOpcion/{opcnId}")
    public SegOpcionDTO getSegOpcion(@PathVariable("opcnId")
    Integer opcnId) throws Exception {
        try {
            SegOpcion segOpcion = businessDelegatorView.getSegOpcion(opcnId);

            return segOpcionMapper.segOpcionToSegOpcionDTO(segOpcion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
