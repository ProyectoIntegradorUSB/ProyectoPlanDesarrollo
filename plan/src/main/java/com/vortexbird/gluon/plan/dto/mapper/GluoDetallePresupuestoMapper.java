package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoDetallePresupuesto;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetallePresupuestoDTO;

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
public class GluoDetallePresupuestoMapper
    implements IGluoDetallePresupuestoMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoDetallePresupuestoMapper.class);

    /**
    * Logic injected by Spring that manages GluoDetallePresupuesto entities
    *
    */
    @Autowired
    IGluoDetallePresupuestoLogic logicGluoDetallePresupuesto1;

    /**
    * Logic injected by Spring that manages GluoPresupuesto entities
    *
    */
    @Autowired
    IGluoPresupuestoLogic logicGluoPresupuesto2;

    /**
    * Logic injected by Spring that manages GluoTipoRecurso entities
    *
    */
    @Autowired
    IGluoTipoRecursoLogic logicGluoTipoRecurso3;

    @Transactional(readOnly = true)
    public GluoDetallePresupuestoDTO gluoDetallePresupuestoToGluoDetallePresupuestoDTO(
        GluoDetallePresupuesto gluoDetallePresupuesto)
        throws Exception {
        try {
            GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO = new GluoDetallePresupuestoDTO();

            gluoDetallePresupuestoDTO.setDptoId(gluoDetallePresupuesto.getDptoId());
            gluoDetallePresupuestoDTO.setActivo((gluoDetallePresupuesto.getActivo() != null)
                ? gluoDetallePresupuesto.getActivo() : null);
            gluoDetallePresupuestoDTO.setCodigoCuenta((gluoDetallePresupuesto.getCodigoCuenta() != null)
                ? gluoDetallePresupuesto.getCodigoCuenta() : null);
            gluoDetallePresupuestoDTO.setDescripcionCuenta((gluoDetallePresupuesto.getDescripcionCuenta() != null)
                ? gluoDetallePresupuesto.getDescripcionCuenta() : null);
            gluoDetallePresupuestoDTO.setFechaCreacion(gluoDetallePresupuesto.getFechaCreacion());
            gluoDetallePresupuestoDTO.setFechaModificacion(gluoDetallePresupuesto.getFechaModificacion());
            gluoDetallePresupuestoDTO.setSaldoEnCdps((gluoDetallePresupuesto.getSaldoEnCdps() != null)
                ? gluoDetallePresupuesto.getSaldoEnCdps() : null);
            gluoDetallePresupuestoDTO.setSectId((gluoDetallePresupuesto.getSectId() != null)
                ? gluoDetallePresupuesto.getSectId() : null);
            gluoDetallePresupuestoDTO.setTipoTransferencia((gluoDetallePresupuesto.getTipoTransferencia() != null)
                ? gluoDetallePresupuesto.getTipoTransferencia() : null);
            gluoDetallePresupuestoDTO.setUsuCreador((gluoDetallePresupuesto.getUsuCreador() != null)
                ? gluoDetallePresupuesto.getUsuCreador() : null);
            gluoDetallePresupuestoDTO.setUsuModificador((gluoDetallePresupuesto.getUsuModificador() != null)
                ? gluoDetallePresupuesto.getUsuModificador() : null);
            gluoDetallePresupuestoDTO.setValorAplazado((gluoDetallePresupuesto.getValorAplazado() != null)
                ? gluoDetallePresupuesto.getValorAplazado() : null);
            gluoDetallePresupuestoDTO.setValorDespuesDeModificaciones((gluoDetallePresupuesto.getValorDespuesDeModificaciones() != null)
                ? gluoDetallePresupuesto.getValorDespuesDeModificaciones() : null);
            gluoDetallePresupuestoDTO.setValorInicial((gluoDetallePresupuesto.getValorInicial() != null)
                ? gluoDetallePresupuesto.getValorInicial() : null);
            gluoDetallePresupuestoDTO.setDptoId_GluoDetallePresupuesto((gluoDetallePresupuesto.getGluoDetallePresupuesto()
                                                                                              .getDptoId() != null)
                ? gluoDetallePresupuesto.getGluoDetallePresupuesto().getDptoId()
                : null);
            gluoDetallePresupuestoDTO.setPptoId_GluoPresupuesto((gluoDetallePresupuesto.getGluoPresupuesto()
                                                                                       .getPptoId() != null)
                ? gluoDetallePresupuesto.getGluoPresupuesto().getPptoId() : null);
            gluoDetallePresupuestoDTO.setTireId_GluoTipoRecurso((gluoDetallePresupuesto.getGluoTipoRecurso()
                                                                                       .getTireId() != null)
                ? gluoDetallePresupuesto.getGluoTipoRecurso().getTireId() : null);

            return gluoDetallePresupuestoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoDetallePresupuesto gluoDetallePresupuestoDTOToGluoDetallePresupuesto(
        GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO)
        throws Exception {
        try {
            GluoDetallePresupuesto gluoDetallePresupuesto = new GluoDetallePresupuesto();

            gluoDetallePresupuesto.setDptoId(gluoDetallePresupuestoDTO.getDptoId());
            gluoDetallePresupuesto.setActivo((gluoDetallePresupuestoDTO.getActivo() != null)
                ? gluoDetallePresupuestoDTO.getActivo() : null);
            gluoDetallePresupuesto.setCodigoCuenta((gluoDetallePresupuestoDTO.getCodigoCuenta() != null)
                ? gluoDetallePresupuestoDTO.getCodigoCuenta() : null);
            gluoDetallePresupuesto.setDescripcionCuenta((gluoDetallePresupuestoDTO.getDescripcionCuenta() != null)
                ? gluoDetallePresupuestoDTO.getDescripcionCuenta() : null);
            gluoDetallePresupuesto.setFechaCreacion(gluoDetallePresupuestoDTO.getFechaCreacion());
            gluoDetallePresupuesto.setFechaModificacion(gluoDetallePresupuestoDTO.getFechaModificacion());
            gluoDetallePresupuesto.setSaldoEnCdps((gluoDetallePresupuestoDTO.getSaldoEnCdps() != null)
                ? gluoDetallePresupuestoDTO.getSaldoEnCdps() : null);
            gluoDetallePresupuesto.setSectId((gluoDetallePresupuestoDTO.getSectId() != null)
                ? gluoDetallePresupuestoDTO.getSectId() : null);
            gluoDetallePresupuesto.setTipoTransferencia((gluoDetallePresupuestoDTO.getTipoTransferencia() != null)
                ? gluoDetallePresupuestoDTO.getTipoTransferencia() : null);
            gluoDetallePresupuesto.setUsuCreador((gluoDetallePresupuestoDTO.getUsuCreador() != null)
                ? gluoDetallePresupuestoDTO.getUsuCreador() : null);
            gluoDetallePresupuesto.setUsuModificador((gluoDetallePresupuestoDTO.getUsuModificador() != null)
                ? gluoDetallePresupuestoDTO.getUsuModificador() : null);
            gluoDetallePresupuesto.setValorAplazado((gluoDetallePresupuestoDTO.getValorAplazado() != null)
                ? gluoDetallePresupuestoDTO.getValorAplazado() : null);
            gluoDetallePresupuesto.setValorDespuesDeModificaciones((gluoDetallePresupuestoDTO.getValorDespuesDeModificaciones() != null)
                ? gluoDetallePresupuestoDTO.getValorDespuesDeModificaciones()
                : null);
            gluoDetallePresupuesto.setValorInicial((gluoDetallePresupuestoDTO.getValorInicial() != null)
                ? gluoDetallePresupuestoDTO.getValorInicial() : null);

          //  GluoDetallePresupuesto gluoDetallePresupuesto = new GluoDetallePresupuesto();

            if (gluoDetallePresupuestoDTO.getDptoId_GluoDetallePresupuesto() != null) {
                gluoDetallePresupuesto = logicGluoDetallePresupuesto1.getGluoDetallePresupuesto(gluoDetallePresupuestoDTO.getDptoId_GluoDetallePresupuesto());
            }

            if (gluoDetallePresupuesto != null) {
                gluoDetallePresupuesto.setGluoDetallePresupuesto(gluoDetallePresupuesto);
            }

            GluoPresupuesto gluoPresupuesto = new GluoPresupuesto();

            if (gluoDetallePresupuestoDTO.getPptoId_GluoPresupuesto() != null) {
                gluoPresupuesto = logicGluoPresupuesto2.getGluoPresupuesto(gluoDetallePresupuestoDTO.getPptoId_GluoPresupuesto());
            }

            if (gluoPresupuesto != null) {
                gluoDetallePresupuesto.setGluoPresupuesto(gluoPresupuesto);
            }

            GluoTipoRecurso gluoTipoRecurso = new GluoTipoRecurso();

            if (gluoDetallePresupuestoDTO.getTireId_GluoTipoRecurso() != null) {
                gluoTipoRecurso = logicGluoTipoRecurso3.getGluoTipoRecurso(gluoDetallePresupuestoDTO.getTireId_GluoTipoRecurso());
            }

            if (gluoTipoRecurso != null) {
                gluoDetallePresupuesto.setGluoTipoRecurso(gluoTipoRecurso);
            }

            return gluoDetallePresupuesto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoDetallePresupuestoDTO> listGluoDetallePresupuestoToListGluoDetallePresupuestoDTO(
        List<GluoDetallePresupuesto> listGluoDetallePresupuesto)
        throws Exception {
        try {
            List<GluoDetallePresupuestoDTO> gluoDetallePresupuestoDTOs = new ArrayList<GluoDetallePresupuestoDTO>();

            for (GluoDetallePresupuesto gluoDetallePresupuesto : listGluoDetallePresupuesto) {
                GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO = gluoDetallePresupuestoToGluoDetallePresupuestoDTO(gluoDetallePresupuesto);

                gluoDetallePresupuestoDTOs.add(gluoDetallePresupuestoDTO);
            }

            return gluoDetallePresupuestoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoDetallePresupuesto> listGluoDetallePresupuestoDTOToListGluoDetallePresupuesto(
        List<GluoDetallePresupuestoDTO> listGluoDetallePresupuestoDTO)
        throws Exception {
        try {
            List<GluoDetallePresupuesto> listGluoDetallePresupuesto = new ArrayList<GluoDetallePresupuesto>();

            for (GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO : listGluoDetallePresupuestoDTO) {
                GluoDetallePresupuesto gluoDetallePresupuesto = gluoDetallePresupuestoDTOToGluoDetallePresupuesto(gluoDetallePresupuestoDTO);

                listGluoDetallePresupuesto.add(gluoDetallePresupuesto);
            }

            return listGluoDetallePresupuesto;
        } catch (Exception e) {
            throw e;
        }
    }
}
