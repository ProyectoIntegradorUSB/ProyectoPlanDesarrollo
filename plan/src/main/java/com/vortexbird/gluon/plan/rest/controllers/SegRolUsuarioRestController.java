package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.ISegRolUsuarioMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegRolUsuarioDTO;
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
@RequestMapping("/segRolUsuario")
public class SegRolUsuarioRestController {
    private static final Logger log = LoggerFactory.getLogger(SegRolUsuarioRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISegRolUsuarioMapper segRolUsuarioMapper;

    @PostMapping(value = "/saveSegRolUsuario")
    public void saveSegRolUsuario(@RequestBody
    SegRolUsuarioDTO segRolUsuarioDTO) throws Exception {
        try {
            SegRolUsuario segRolUsuario = segRolUsuarioMapper.segRolUsuarioDTOToSegRolUsuario(segRolUsuarioDTO);

            businessDelegatorView.saveSegRolUsuario(segRolUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSegRolUsuario/{rlusId}")
    public void deleteSegRolUsuario(@PathVariable("rlusId")
    Integer rlusId) throws Exception {
        try {
            SegRolUsuario segRolUsuario = businessDelegatorView.getSegRolUsuario(rlusId);

            businessDelegatorView.deleteSegRolUsuario(segRolUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSegRolUsuario/")
    public void updateSegRolUsuario(
        @RequestBody
    SegRolUsuarioDTO segRolUsuarioDTO) throws Exception {
        try {
            SegRolUsuario segRolUsuario = segRolUsuarioMapper.segRolUsuarioDTOToSegRolUsuario(segRolUsuarioDTO);

            businessDelegatorView.updateSegRolUsuario(segRolUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSegRolUsuario")
    public List<SegRolUsuarioDTO> getDataSegRolUsuario()
        throws Exception {
        try {
            return businessDelegatorView.getDataSegRolUsuario();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSegRolUsuario/{rlusId}")
    public SegRolUsuarioDTO getSegRolUsuario(
        @PathVariable("rlusId")
    Integer rlusId) throws Exception {
        try {
            SegRolUsuario segRolUsuario = businessDelegatorView.getSegRolUsuario(rlusId);

            return segRolUsuarioMapper.segRolUsuarioToSegRolUsuarioDTO(segRolUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
