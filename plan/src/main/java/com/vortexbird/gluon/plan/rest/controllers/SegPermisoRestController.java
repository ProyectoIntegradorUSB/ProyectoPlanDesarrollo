package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.ISegPermisoMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegPermisoDTO;
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
@RequestMapping("/segPermiso")
public class SegPermisoRestController {
    private static final Logger log = LoggerFactory.getLogger(SegPermisoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISegPermisoMapper segPermisoMapper;

    @PostMapping(value = "/saveSegPermiso")
    public void saveSegPermiso(@RequestBody
    SegPermisoDTO segPermisoDTO) throws Exception {
        try {
            SegPermiso segPermiso = segPermisoMapper.segPermisoDTOToSegPermiso(segPermisoDTO);

            businessDelegatorView.saveSegPermiso(segPermiso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSegPermiso/{permId}")
    public void deleteSegPermiso(@PathVariable("permId")
    Integer permId) throws Exception {
        try {
            SegPermiso segPermiso = businessDelegatorView.getSegPermiso(permId);

            businessDelegatorView.deleteSegPermiso(segPermiso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSegPermiso/")
    public void updateSegPermiso(@RequestBody
    SegPermisoDTO segPermisoDTO) throws Exception {
        try {
            SegPermiso segPermiso = segPermisoMapper.segPermisoDTOToSegPermiso(segPermisoDTO);

            businessDelegatorView.updateSegPermiso(segPermiso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSegPermiso")
    public List<SegPermisoDTO> getDataSegPermiso() throws Exception {
        try {
            return businessDelegatorView.getDataSegPermiso();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSegPermiso/{permId}")
    public SegPermisoDTO getSegPermiso(@PathVariable("permId")
    Integer permId) throws Exception {
        try {
            SegPermiso segPermiso = businessDelegatorView.getSegPermiso(permId);

            return segPermisoMapper.segPermisoToSegPermisoDTO(segPermiso);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
