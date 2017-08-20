package com.vortexbird.gluon.plan.rest.controllers;

import com.vortexbird.gluon.plan.dto.mapper.ISegUsuarioMapper;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegUsuarioDTO;
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
@RequestMapping("/segUsuario")
public class SegUsuarioRestController {
    private static final Logger log = LoggerFactory.getLogger(SegUsuarioRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISegUsuarioMapper segUsuarioMapper;

    @PostMapping(value = "/saveSegUsuario")
    public void saveSegUsuario(@RequestBody
    SegUsuarioDTO segUsuarioDTO) throws Exception {
        try {
            SegUsuario segUsuario = segUsuarioMapper.segUsuarioDTOToSegUsuario(segUsuarioDTO);

            businessDelegatorView.saveSegUsuario(segUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSegUsuario/{usuId}")
    public void deleteSegUsuario(@PathVariable("usuId")
    Integer usuId) throws Exception {
        try {
            SegUsuario segUsuario = businessDelegatorView.getSegUsuario(usuId);

            businessDelegatorView.deleteSegUsuario(segUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSegUsuario/")
    public void updateSegUsuario(@RequestBody
    SegUsuarioDTO segUsuarioDTO) throws Exception {
        try {
            SegUsuario segUsuario = segUsuarioMapper.segUsuarioDTOToSegUsuario(segUsuarioDTO);

            businessDelegatorView.updateSegUsuario(segUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSegUsuario")
    public List<SegUsuarioDTO> getDataSegUsuario() throws Exception {
        try {
            return businessDelegatorView.getDataSegUsuario();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSegUsuario/{usuId}")
    public SegUsuarioDTO getSegUsuario(@PathVariable("usuId")
    Integer usuId) throws Exception {
        try {
            SegUsuario segUsuario = businessDelegatorView.getSegUsuario(usuId);

            return segUsuarioMapper.segUsuarioToSegUsuarioDTO(segUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
