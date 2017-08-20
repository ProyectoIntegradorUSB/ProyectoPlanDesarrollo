package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoDetalleProyectoXRubro;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;

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
public class GluoDetalleProyectoXRubroMapper
    implements IGluoDetalleProyectoXRubroMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoXRubroMapper.class);

    /**
    * Logic injected by Spring that manages GluoDetallePresupuesto entities
    *
    */
    @Autowired
    IGluoDetallePresupuestoLogic logicGluoDetallePresupuesto1;

    /**
    * Logic injected by Spring that manages GluoDetalleProyecto entities
    *
    */
    @Autowired
    IGluoDetalleProyectoLogic logicGluoDetalleProyecto2;

    @Transactional(readOnly = true)
    public GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroToGluoDetalleProyectoXRubroDTO(
        GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro)
        throws Exception {
        try {
            GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO = new GluoDetalleProyectoXRubroDTO();

            gluoDetalleProyectoXRubroDTO.setDpruId(gluoDetalleProyectoXRubro.getDpruId());
            gluoDetalleProyectoXRubroDTO.setActivo((gluoDetalleProyectoXRubro.getActivo() != null)
                ? gluoDetalleProyectoXRubro.getActivo() : null);
            gluoDetalleProyectoXRubroDTO.setDescripcion((gluoDetalleProyectoXRubro.getDescripcion() != null)
                ? gluoDetalleProyectoXRubro.getDescripcion() : null);
            gluoDetalleProyectoXRubroDTO.setFechaCreacion(gluoDetalleProyectoXRubro.getFechaCreacion());
            gluoDetalleProyectoXRubroDTO.setFechaModificacion(gluoDetalleProyectoXRubro.getFechaModificacion());
            gluoDetalleProyectoXRubroDTO.setUsuCreador((gluoDetalleProyectoXRubro.getUsuCreador() != null)
                ? gluoDetalleProyectoXRubro.getUsuCreador() : null);
            gluoDetalleProyectoXRubroDTO.setUsuModificador((gluoDetalleProyectoXRubro.getUsuModificador() != null)
                ? gluoDetalleProyectoXRubro.getUsuModificador() : null);
            gluoDetalleProyectoXRubroDTO.setValor((gluoDetalleProyectoXRubro.getValor() != null)
                ? gluoDetalleProyectoXRubro.getValor() : null);
            gluoDetalleProyectoXRubroDTO.setDptoId_GluoDetallePresupuesto((gluoDetalleProyectoXRubro.getGluoDetallePresupuesto()
                                                                                                    .getDptoId() != null)
                ? gluoDetalleProyectoXRubro.getGluoDetallePresupuesto()
                                           .getDptoId() : null);
            gluoDetalleProyectoXRubroDTO.setDproId_GluoDetalleProyecto((gluoDetalleProyectoXRubro.getGluoDetalleProyecto()
                                                                                                 .getDproId() != null)
                ? gluoDetalleProyectoXRubro.getGluoDetalleProyecto().getDproId()
                : null);

            return gluoDetalleProyectoXRubroDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoDetalleProyectoXRubro gluoDetalleProyectoXRubroDTOToGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO)
        throws Exception {
        try {
            GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = new GluoDetalleProyectoXRubro();

            gluoDetalleProyectoXRubro.setDpruId(gluoDetalleProyectoXRubroDTO.getDpruId());
            gluoDetalleProyectoXRubro.setActivo((gluoDetalleProyectoXRubroDTO.getActivo() != null)
                ? gluoDetalleProyectoXRubroDTO.getActivo() : null);
            gluoDetalleProyectoXRubro.setDescripcion((gluoDetalleProyectoXRubroDTO.getDescripcion() != null)
                ? gluoDetalleProyectoXRubroDTO.getDescripcion() : null);
            gluoDetalleProyectoXRubro.setFechaCreacion(gluoDetalleProyectoXRubroDTO.getFechaCreacion());
            gluoDetalleProyectoXRubro.setFechaModificacion(gluoDetalleProyectoXRubroDTO.getFechaModificacion());
            gluoDetalleProyectoXRubro.setUsuCreador((gluoDetalleProyectoXRubroDTO.getUsuCreador() != null)
                ? gluoDetalleProyectoXRubroDTO.getUsuCreador() : null);
            gluoDetalleProyectoXRubro.setUsuModificador((gluoDetalleProyectoXRubroDTO.getUsuModificador() != null)
                ? gluoDetalleProyectoXRubroDTO.getUsuModificador() : null);
            gluoDetalleProyectoXRubro.setValor((gluoDetalleProyectoXRubroDTO.getValor() != null)
                ? gluoDetalleProyectoXRubroDTO.getValor() : null);

            GluoDetallePresupuesto gluoDetallePresupuesto = new GluoDetallePresupuesto();

            if (gluoDetalleProyectoXRubroDTO.getDptoId_GluoDetallePresupuesto() != null) {
                gluoDetallePresupuesto = logicGluoDetallePresupuesto1.getGluoDetallePresupuesto(gluoDetalleProyectoXRubroDTO.getDptoId_GluoDetallePresupuesto());
            }

            if (gluoDetallePresupuesto != null) {
                gluoDetalleProyectoXRubro.setGluoDetallePresupuesto(gluoDetallePresupuesto);
            }

            GluoDetalleProyecto gluoDetalleProyecto = new GluoDetalleProyecto();

            if (gluoDetalleProyectoXRubroDTO.getDproId_GluoDetalleProyecto() != null) {
                gluoDetalleProyecto = logicGluoDetalleProyecto2.getGluoDetalleProyecto(gluoDetalleProyectoXRubroDTO.getDproId_GluoDetalleProyecto());
            }

            if (gluoDetalleProyecto != null) {
                gluoDetalleProyectoXRubro.setGluoDetalleProyecto(gluoDetalleProyecto);
            }

            return gluoDetalleProyectoXRubro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoDetalleProyectoXRubroDTO> listGluoDetalleProyectoXRubroToListGluoDetalleProyectoXRubroDTO(
        List<GluoDetalleProyectoXRubro> listGluoDetalleProyectoXRubro)
        throws Exception {
        try {
            List<GluoDetalleProyectoXRubroDTO> gluoDetalleProyectoXRubroDTOs = new ArrayList<GluoDetalleProyectoXRubroDTO>();

            for (GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro : listGluoDetalleProyectoXRubro) {
                GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO = gluoDetalleProyectoXRubroToGluoDetalleProyectoXRubroDTO(gluoDetalleProyectoXRubro);

                gluoDetalleProyectoXRubroDTOs.add(gluoDetalleProyectoXRubroDTO);
            }

            return gluoDetalleProyectoXRubroDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoDetalleProyectoXRubro> listGluoDetalleProyectoXRubroDTOToListGluoDetalleProyectoXRubro(
        List<GluoDetalleProyectoXRubroDTO> listGluoDetalleProyectoXRubroDTO)
        throws Exception {
        try {
            List<GluoDetalleProyectoXRubro> listGluoDetalleProyectoXRubro = new ArrayList<GluoDetalleProyectoXRubro>();

            for (GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO : listGluoDetalleProyectoXRubroDTO) {
                GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = gluoDetalleProyectoXRubroDTOToGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubroDTO);

                listGluoDetalleProyectoXRubro.add(gluoDetalleProyectoXRubro);
            }

            return listGluoDetalleProyectoXRubro;
        } catch (Exception e) {
            throw e;
        }
    }
}
