package com.PrestamoBancarios.Prestamo.datos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.*;
import com.PrestamoBancarios.Prestamo.modelo.entidades.enumeradores.SucursalEnum;
import com.PrestamoBancarios.Prestamo.modelo.entidades.enumeradores.TipoClienteEnum;
import com.PrestamoBancarios.Prestamo.modelo.entidades.enumeradores.TipoPrestamoEnum;

//public class DatosDummy {
//    public static Empleado empleado01(boolean conId){
//        Empleado empleado=(conId) ? new Empleado(1,"Mario","López",new Sucursal(null, SucursalEnum.AGENCIA_LAUNION.toString(),"Santa elena")):
//                new Empleado(null,"Mario","López",new Sucursal(null,SucursalEnum.AGENCIA_MULTIPLAZA.toString(),"Santa tecla"));
//

public class DatosDummy {
    public static Empleado empleado01(boolean conId){
        Empleado empleado=(conId) ? new Empleado(1,"Vanessa","Perez",new Sucursal(null,
                SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")):
                new Empleado(null,"Vanessa","Perez",new Sucursal(null,
                SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo"));

        return empleado;
    }
    public static Empleado empleado02(boolean conId){

        Empleado empleado=(conId) ? new  Empleado(2,"Rodrigo","Ruiz",new Sucursal(null, SucursalEnum.AGENCIA_LAUNION.toString(),"Santa elena")):
                new Empleado(null,"Rodrigo","Ruiz",new Sucursal(null, SucursalEnum.AGENCIA_LAUNION.toString(),"Santa elena"));
        return empleado;
    }
    public static Empleado empleado03(){
        return new Empleado(null,"Fernando","Gómez",new Sucursal(null, SucursalEnum.AGENCIA_LAUNION.toString(),"Santa elena"));
    }

    //INGRESANDO DATOS PARA CLIENTE
    public static Cliente cliente01(boolean conId){
        Cliente cliente = (conId) ? new Cliente(1,"Juan","Guzman",35,"08067854-0",1500.0,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())):
                new Cliente(null,"Juan","Guzman",35,"08067854-0",1500.0,new TipoCliente());
        return cliente;
    }
    public static Cliente cliente02(boolean conId){
        Cliente cliente = (conId) ? new Cliente(2,"Pedro","Gavidia",44,"08067855-0",800.0,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())):
                new Cliente(null,"Pedro","Gavidia",44,"08067855-0",800.0,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString()));
        return cliente;
    }
    public static Cliente cliente03(boolean conId){
        Cliente cliente = (conId) ? new Cliente(3,"Luis","Martinez",25,"09767855-0",1100.0,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())):
                new Cliente(null,"Luis","Martinez",25,"09767855-0",1100.0,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString()));
        return cliente;
    }

    //INGRESANDO DATOS PARA PRESTAMO

    public static Prestamo prestamo01(boolean conId){
        Prestamo prestamo=(conId) ? new Prestamo(1,new Cliente(null,"Saul","Abarca",24,  "1002515-2" ,500.00,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())),500.0,10.0,5,20,
                new Fiador("Oscar","Perez","0256444-5"),new Garantia("terreno de 20 cuadras"),new TipoPrestamo(TipoPrestamoEnum.CREDITO_ESTUDIO.toString()),new Empleado(null,"Vanessa","Perez",new Sucursal(null,
                SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo"))):

                new Prestamo(null,new Cliente(null,"Saul","Abarca",24,  "1002515-2" ,500.00,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())),500.0,10.0,5,20,
                        new Fiador("Oscar","Perez","0256444-5"),new Garantia("terreno de 20 cuadras"),new TipoPrestamo(TipoPrestamoEnum.CREDITO_ESTUDIO.toString()),new Empleado(null,"Vanessa","Perez",new Sucursal(null,
                        SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")));
        return prestamo;
    }
    public static Prestamo prestamo02(){
        return new Prestamo(null,new Cliente(null,"Saul","Abarca",24,  "1002515-2" ,500.00,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())),500.0,10.0,5,20,
                new Fiador("Sandra","Perez","0256444-5"),new Garantia("terreno de 20 cuadras"),new TipoPrestamo(TipoPrestamoEnum.CREDITO_ESTUDIO.toString()),new Empleado(null,"Vanessa","Perez",new Sucursal(null,
                SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")));
    }
    public static Prestamo prestamo03(){
        return new Prestamo(null,new Cliente(null,"Odir","Abarca",24,  "1002515-2" ,500.00,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())),500.0,10.0,5,20,
                new Fiador("Oscar","Perez","0256444-5"),new Garantia("terreno de 20 cuadras"),new TipoPrestamo(TipoPrestamoEnum.CREDITO_ESTUDIO.toString()),new Empleado(null,"Vanessa","Perez",new Sucursal(null,
                SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")));
    }

}
