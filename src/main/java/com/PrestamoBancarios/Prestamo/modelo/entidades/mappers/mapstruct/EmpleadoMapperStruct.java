package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.EmpleadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Deprecated
@Mapper(componentModel="spring")
public interface EmpleadoMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "nombreEmpleado",target = "nombreEmpleado"),
            @Mapping(source = "apellidoEmpleado",target = "apellidoEmpleado"),
            @Mapping(source = "sucursal",target = "sucursal")
    })
    EmpleadoDTO mapEmpleado(Empleado empleado);

}

//    private Integer id;
//    private String nombreEmpleado;
//    private String apellidoEmpleado;
//    private Sucursal sucursal;