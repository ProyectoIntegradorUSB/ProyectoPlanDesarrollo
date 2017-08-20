package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoAnoFiscalDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class GluoAnoFiscalMapper implements IGluoAnoFiscalMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoAnoFiscalMapper.class);

    @Transactional(readOnly = true)
    public GluoAnoFiscalDTO gluoAnoFiscalToGluoAnoFiscalDTO(
        GluoAnoFiscal gluoAnoFiscal) throws Exception {
        try {
            GluoAnoFiscalDTO gluoAnoFiscalDTO = new GluoAnoFiscalDTO();

            gluoAnoFiscalDTO.setAnofId(gluoAnoFiscal.getAnofId());
            gluoAnoFiscalDTO.setActivo((gluoAnoFiscal.getActivo() != null)
                ? gluoAnoFiscal.getActivo() : null);
            gluoAnoFiscalDTO.setAnoFiscal((gluoAnoFiscal.getAnoFiscal() != null)
                ? gluoAnoFiscal.getAnoFiscal() : null);
            gluoAnoFiscalDTO.setDescripcion((gluoAnoFiscal.getDescripcion() != null)
                ? gluoAnoFiscal.getDescripcion() : null);
            gluoAnoFiscalDTO.setEmprId((gluoAnoFiscal.getEmprId() != null)
                ? gluoAnoFiscal.getEmprId() : null);
            gluoAnoFiscalDTO.setEstado((gluoAnoFiscal.getEstado() != null)
                ? gluoAnoFiscal.getEstado() : null);
            gluoAnoFiscalDTO.setFechaCreacion(gluoAnoFiscal.getFechaCreacion());
            gluoAnoFiscalDTO.setFechaIncioAnoFiscal(gluoAnoFiscal.getFechaIncioAnoFiscal());
            gluoAnoFiscalDTO.setFechaModificacion(gluoAnoFiscal.getFechaModificacion());
            gluoAnoFiscalDTO.setUsuCreador((gluoAnoFiscal.getUsuCreador() != null)
                ? gluoAnoFiscal.getUsuCreador() : null);
            gluoAnoFiscalDTO.setUsuModificador((gluoAnoFiscal.getUsuModificador() != null)
                ? gluoAnoFiscal.getUsuModificador() : null);
            gluoAnoFiscalDTO.setValorSalarioMinimo((gluoAnoFiscal.getValorSalarioMinimo() != null)
                ? gluoAnoFiscal.getValorSalarioMinimo() : null);

            return gluoAnoFiscalDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoAnoFiscal gluoAnoFiscalDTOToGluoAnoFiscal(
        GluoAnoFiscalDTO gluoAnoFiscalDTO) throws Exception {
        try {
            GluoAnoFiscal gluoAnoFiscal = new GluoAnoFiscal();

            gluoAnoFiscal.setAnofId(gluoAnoFiscalDTO.getAnofId());
            gluoAnoFiscal.setActivo((gluoAnoFiscalDTO.getActivo() != null)
                ? gluoAnoFiscalDTO.getActivo() : null);
            gluoAnoFiscal.setAnoFiscal((gluoAnoFiscalDTO.getAnoFiscal() != null)
                ? gluoAnoFiscalDTO.getAnoFiscal() : null);
            gluoAnoFiscal.setDescripcion((gluoAnoFiscalDTO.getDescripcion() != null)
                ? gluoAnoFiscalDTO.getDescripcion() : null);
            gluoAnoFiscal.setEmprId((gluoAnoFiscalDTO.getEmprId() != null)
                ? gluoAnoFiscalDTO.getEmprId() : null);
            gluoAnoFiscal.setEstado((gluoAnoFiscalDTO.getEstado() != null)
                ? gluoAnoFiscalDTO.getEstado() : null);
            gluoAnoFiscal.setFechaCreacion(gluoAnoFiscalDTO.getFechaCreacion());
            gluoAnoFiscal.setFechaIncioAnoFiscal(gluoAnoFiscalDTO.getFechaIncioAnoFiscal());
            gluoAnoFiscal.setFechaModificacion(gluoAnoFiscalDTO.getFechaModificacion());
            gluoAnoFiscal.setUsuCreador((gluoAnoFiscalDTO.getUsuCreador() != null)
                ? gluoAnoFiscalDTO.getUsuCreador() : null);
            gluoAnoFiscal.setUsuModificador((gluoAnoFiscalDTO.getUsuModificador() != null)
                ? gluoAnoFiscalDTO.getUsuModificador() : null);
            gluoAnoFiscal.setValorSalarioMinimo((gluoAnoFiscalDTO.getValorSalarioMinimo() != null)
                ? gluoAnoFiscalDTO.getValorSalarioMinimo() : null);

            return gluoAnoFiscal;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoAnoFiscalDTO> listGluoAnoFiscalToListGluoAnoFiscalDTO(
        List<GluoAnoFiscal> listGluoAnoFiscal) throws Exception {
        try {
            List<GluoAnoFiscalDTO> gluoAnoFiscalDTOs = new ArrayList<GluoAnoFiscalDTO>();

            for (GluoAnoFiscal gluoAnoFiscal : listGluoAnoFiscal) {
                GluoAnoFiscalDTO gluoAnoFiscalDTO = gluoAnoFiscalToGluoAnoFiscalDTO(gluoAnoFiscal);

                gluoAnoFiscalDTOs.add(gluoAnoFiscalDTO);
            }

            return gluoAnoFiscalDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoAnoFiscal> listGluoAnoFiscalDTOToListGluoAnoFiscal(
        List<GluoAnoFiscalDTO> listGluoAnoFiscalDTO) throws Exception {
        try {
            List<GluoAnoFiscal> listGluoAnoFiscal = new ArrayList<GluoAnoFiscal>();

            for (GluoAnoFiscalDTO gluoAnoFiscalDTO : listGluoAnoFiscalDTO) {
                GluoAnoFiscal gluoAnoFiscal = gluoAnoFiscalDTOToGluoAnoFiscal(gluoAnoFiscalDTO);

                listGluoAnoFiscal.add(gluoAnoFiscal);
            }

            return listGluoAnoFiscal;
        } catch (Exception e) {
            throw e;
        }
    }
}
