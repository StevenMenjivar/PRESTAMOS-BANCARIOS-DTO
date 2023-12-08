package com.PrestamoBancarios.Prestamo;

import com.PrestamoBancarios.Prestamo.modelo.entidades.*;
import com.PrestamoBancarios.Prestamo.modelo.entidades.enumeradores.SucursalEnum;
import com.PrestamoBancarios.Prestamo.modelo.entidades.enumeradores.TipoClienteEnum;
import com.PrestamoBancarios.Prestamo.modelo.entidades.enumeradores.TipoPrestamoEnum;
import com.PrestamoBancarios.Prestamo.servicios.contratos.GenericoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class PrestamoApplication {


	@Autowired
	private GenericoDAO<Cliente> servicio;
	@Autowired
	private GenericoDAO<Prestamo> servicio1;


	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(PrestamoApplication.class, args).getBeanDefinitionNames();
		/*for(String str : beanDefinitionNames){
			System.out.println(str);
		}*/
	}

	@Bean
	public CommandLineRunner runner(){
		return args -> {

//			Prestamo prestamo = new Prestamo(null,new Cliente(null,"Saul","Abarca",24,  "1002515-2" ,500.00,new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())),500.0,10.0,5,20,
//					new Fiador("Oscar","Perez","0256444-5"),new Garantia("terreno de 20 cuadras"),new TipoPrestamo(TipoPrestamoEnum.CREDITO_ESTUDIO.toString()),new Empleado(null,"Vanessa","Perez",new Sucursal(null,
//					SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")));
//
//			Prestamo save = servicio1.save(prestamo);
			Prestamo prestamo = new Prestamo(null,new Cliente(null,"Saul","Abarca",24,  "1002515-2" ,500.00,
					new TipoCliente(TipoClienteEnum.EMPLEADO_GOBIERNO.toString())),1000.0,10.0,5,20,
					new Fiador("Oscar","Perez","0256444-5"),
					new Garantia("Carro 2025"),
					new TipoPrestamo(TipoPrestamoEnum.CONCILIACION_DEUDAS.toString()),
					new Empleado(null,"Vanessa","Perez",new Sucursal(null,
							SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")));

			Prestamo prestamo1 = new Prestamo(null,
					new Cliente(null,"Oscar","Perez",24,  "1002515-2" ,500.00,
							new TipoCliente(TipoClienteEnum.EMPLEADO_SECTOR_PRIVADO.toString())),700.0,10.0,5,20,
					new Fiador("Cesar","Perez","0256444-5"),
					new Garantia("Dos terrenos"),
					new TipoPrestamo(TipoPrestamoEnum.CREDIGO_PAGO_VENTANILLA.toString()),
					new Empleado(null,"Daniel","Perez", new Sucursal(null,
							SucursalEnum.AGENCIA_GALERIAS.toString(),"Salvador del mundo")));

			Prestamo prestamo2 = new Prestamo(null,new Cliente(null,"Osiiris","Hernandez",24,  "1002515-2" ,500.00,
					new TipoCliente(TipoClienteEnum.EMPRENDEDOR.toString())),450.0,10.0,5,20,
					new Fiador("Otoniel","Perez","0256444-5"),
					new Garantia("terreno de 200 cuadras"),
					new TipoPrestamo(TipoPrestamoEnum.CREDITO_ESTUDIO.toString()),
					new Empleado(null,"LIsseth","Perez",new Sucursal(null,
							SucursalEnum.AGENCIA_LAUNION.toString(),"Salvador del mundo")));

			Prestamo prestamo3 = new Prestamo(null,new Cliente(null,"Victor","Herrera",24,  "1002515-2" ,500.00,
					new TipoCliente(TipoClienteEnum.PERSONA_NATURAL.toString())),400.0,10.0,5,20,
					new Fiador("Oscar","Perez","0256444-5"),
					new Garantia("Dos carros deportivos"),
					new TipoPrestamo(TipoPrestamoEnum.CREDITO_HIPOTECARIO.toString()),
					new Empleado(null,"Maria","Perez",new Sucursal(null,
							SucursalEnum.AGENCIA_MULTIPLAZA.toString(),"Salvador del mundo")));

			Prestamo prestamo4 = new Prestamo(null,new Cliente(null,"Mirna","Bella",24,  "1002515-2" ,500.00,
					new TipoCliente(TipoClienteEnum.PROFESIONAL_INDEPENDIENTE.toString())),3000.0,10.0,5,20,
					new Fiador("Odir","Perez","0256444-5"),
					new Garantia("terreno"),
					new TipoPrestamo(TipoPrestamoEnum.CREDITO_GARANTIA_DEPOSITO_PLAZO.toString()),
					new Empleado(null,"Martin","Perez",new Sucursal(null,
							SucursalEnum.AGENCIA_NORTE.toString(),"Salvador del mundo")));

			Prestamo prestamo5 = new Prestamo(null,new Cliente(null,"Cristian","Olivo",24,  "1002515-2" ,500.00,
					new TipoCliente(TipoClienteEnum.EMPRESARIO.toString())),50000.0,10.0,5,20,
					new Fiador("Saul","Perez","0256444-5"),
					new Garantia("Agencia de vehiculos"),
					new TipoPrestamo(TipoPrestamoEnum.CREDITO_VEHICULO.toString()),
					new Empleado(null,"Rodrigo","Perez",new Sucursal(null,
							SucursalEnum.AGENCIA_PLAZAMUNDO.toString(),"Salvador del mundo")));


			Prestamo prestamo6 = new Prestamo(null,new Cliente(null,"Marcela","Sanchez",24,  "1002515-2" ,500.00,
					new TipoCliente(TipoClienteEnum.PROFESIONAL_INDEPENDIENTE.toString())),501.0,10.0,5,20,
					new Fiador("sulma","Perez","0256444-5"),
					new Garantia("Casa Nueva"),
					new TipoPrestamo(TipoPrestamoEnum.CREDITO_MULTIDESTINO.toString()),
					new Empleado(null,"Julio","Perez",new Sucursal(null,
							SucursalEnum.AGENCIA_SUR.toString(),"Salvador del mundo")));

			Prestamo save = servicio1.save(prestamo);
			Prestamo save1 = servicio1.save(prestamo1);
			Prestamo save2 = servicio1.save(prestamo2);
			Prestamo save3 = servicio1.save(prestamo3);
			Prestamo save4 = servicio1.save(prestamo4);
			Prestamo save5 = servicio1.save(prestamo5);
			Prestamo save6 = servicio1.save(prestamo6);

		};
	}

}
