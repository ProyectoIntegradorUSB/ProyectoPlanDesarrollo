package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.ISegRolMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegRolDTO;
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
@RequestMapping("/segRol")
public class SegRolRestController {
    private static final Logger log = LoggerFactory.getLogger(SegRolRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISegRolMapper segRolMapper;

    @PostMapping(value = "/saveSegRol")
    public void saveSegRol(@RequestBody
    SegRolDTO segRolDTO) throws Exception {
        try {
            SegRol segRol = segRolMapper.segRolDTOToSegRol(segRolDTO);

            businessDelegatorView.saveSegRol(segRol);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSegRol/{rolId}")
    public void deleteSegRol(@PathVariable("rolId")
    Integer rolId) throws Exception {
        try {
            SegRol segRol = businessDelegatorView.getSegRol(rolId);

            businessDelegatorView.deleteSegRol(segRol);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSegRol/")
    public void updateSegRol(@RequestBody
    SegRolDTO segRolDTO) throws Exception {
        try {
            SegRol segRol = segRolMapper.segRolDTOToSegRol(segRolDTO);

            businessDelegatorView.updateSegRol(segRol);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSegRol")
    public List<SegRolDTO> getDataSegRol() throws Exception {
        try {
            return businessDelegatorView.getDataSegRol();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSegRol/{rolId}")
    public SegRolDTO getSegRol(@PathVariable("rolId")
    Integer rolId) throws Exception {
        try {
            SegRol segRol = businessDelegatorView.getSegRol(rolId);

            return segRolMapper.segRolToSegRolDTO(segRol);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
