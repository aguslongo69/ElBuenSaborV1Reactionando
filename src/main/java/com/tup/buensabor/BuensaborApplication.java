package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.*;
import com.tup.buensabor.repositories.DetalleArticuloManufacturadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BuensaborApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuensaborApplication.class, args);
		System.out.println("Programa en Ejecucion");
	}

	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("------------------------Estoy Funcionando------------------------");

			//Persona

			Persona persona=new Persona();
			persona.setNombre("Agustin");
			persona.setApellido("Sulan");
			persona.setEmail("agustinsula@gmail.com");
			persona.setTelefono("2627867986");

			//User

			Usuario user = new Usuario();
			user.setUsername("AguSul12");
			user.setAuth0Id("1f89JF81FSA2415G5UUES");
			user.setRol(Rol.CLIENTE);
			user.setFechaAlta(new Date());
			user.setPersona(persona);

			//Localidad

			Localidad localidad = new Localidad();

			localidad.setDenominacion("Guaymallén");

			//Domicilio

			Domicilio domicilio=new Domicilio();
			domicilio.setCalle("Olascoaga");
			domicilio.setCodigoPostal(5504);
			domicilio.setNumero(232);
			domicilio.setNumeroDpto(23);
			domicilio.setPisoDpto(2);
			domicilio.setFechaBaja(new Date());
			domicilio.setFechaAlta(new Date());
			domicilio.setFechaModificacion(new Date());
			domicilio.setUser(user);
			domicilio.setLocalidad(localidad);

			//DetallePedido

			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(3);
			detallePedido.setSubtotal(new BigDecimal(44894));
			detallePedido.setSubtotalCosto(new BigDecimal(8445));

			DetallePedido detallePedido1 = new DetallePedido();

			detallePedido1.setCantidad(3);
			detallePedido1.setSubtotal(new BigDecimal(44894));
			detallePedido1.setSubtotalCosto(new BigDecimal(8445));

			//Pedido

			Pedido pedido1=new Pedido();
			pedido1.setEstado(EstadoPedido.COMPLETADO);
			pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
			pedido1.setTotal(new BigDecimal(49844));
			pedido1.setTotalCosto(new BigDecimal(498446));
			pedido1.setFechaAlta(new Date());
			pedido1.setFormaPago(FormaPago.MERCADO_PAGO);
			pedido1.setHoraEstimadaFinalizacion(new Date());
			pedido1.setFechaPedido(new Date());
			pedido1.addDetallePedido(detallePedido);
			pedido1.addDetallePedido(detallePedido1);
			pedido1.setUsuario(user);
			pedido1.setDomicilioEntrega(domicilio);

			//PedidoEstadoPedido

			PedidoEstadoPedido pedidoEstadoPedido1 = new PedidoEstadoPedido();
			pedidoEstadoPedido1.setEstadoPedido(EstadoPedido.COMPLETADO);
			pedidoEstadoPedido1.setFechaHoraCambioEstado(new Date());
			pedidoEstadoPedido1.setPedido(pedido1);

			PedidoEstadoPedido pedidoEstadoPedido2 = new PedidoEstadoPedido();
			pedidoEstadoPedido2.setEstadoPedido(EstadoPedido.COMPLETADO);
			pedidoEstadoPedido2.setFechaHoraCambioEstado(new Date());
			pedidoEstadoPedido2.setPedido(pedido1);

			//RubroIngrediente

			RubroArticuloIngrediente rubroArticuloIngrediente1 = new RubroArticuloIngrediente();
			rubroArticuloIngrediente1.setDenominacion("verdura");
			rubroArticuloIngrediente1.setFechaAlta(new Date());
			rubroArticuloIngrediente1.setFechaBaja(new Date());
			rubroArticuloIngrediente1.setFechaModificacion(new Date());

			RubroArticuloIngrediente rubroArticuloIngrediente2 = new RubroArticuloIngrediente();
			rubroArticuloIngrediente1.setDenominacion("condimento");
			rubroArticuloIngrediente1.setFechaAlta(new Date());
			rubroArticuloIngrediente1.setFechaBaja(new Date());
			rubroArticuloIngrediente1.setFechaModificacion(new Date());

			//RubroArticuloProducto

			RubroArticuloProducto rubroArticuloProducto1 = new RubroArticuloProducto ();
			rubroArticuloProducto1.setDenominacion("Hamburguesas");
			rubroArticuloProducto1.setFechaHoraAlta(new Date());

			//UnidadMedida

			UnidadMedida unidadMedida = new UnidadMedida();

			unidadMedida.setDenominacion("gramos");
			unidadMedida.setAbreviatura("g");
			unidadMedida.setFechaAlta(new Date());

			//ArticuloIngrediente

			ArticuloIngrediente articuloIngrediente = new ArticuloIngrediente();

			articuloIngrediente.setDenominacion("Orégano");
			articuloIngrediente.setFechaAlta(new Date());
			articuloIngrediente.setFechaBaja(new Date());
			articuloIngrediente.setFechaModificacion(new Date());
			articuloIngrediente.setPrecioCompra(new BigDecimal(13215));
			articuloIngrediente.setStockMinimo(new BigDecimal(2165));
			articuloIngrediente.setStockActual(new BigDecimal(584));
			articuloIngrediente.setUnidadMedida(unidadMedida);
			articuloIngrediente.setUrlImagen("");
			articuloIngrediente.setRubroArticuloIngrediente(rubroArticuloIngrediente1);

			//DetalleArticuloManufacturado

			DetalleArticuloManufacturado detalleArticuloManufacturado = new DetalleArticuloManufacturado();

			detalleArticuloManufacturado.setCantidad(new BigDecimal(4584));
			detalleArticuloManufacturado.setArticuloIngrediente(articuloIngrediente);


			//ArticuloProducto

			ArticuloProducto articulo1 = new ArticuloProducto ();

			articulo1.setCosto(new BigDecimal(1245));
			articulo1.setDenominacion("Hamburguesa con queso");
			articulo1.setDescripcion("ta buena");
			articulo1.setFechaAlta(new Date());
			articulo1.setPrecioVenta(new BigDecimal(1321));
			articulo1.setTiempoEstimadoCocina(30);
			articulo1.setTipoProducto(TipoProducto.COCINA);
			articulo1.setUrlImagen("");
			articulo1.setRubroarticuloproducto(rubroArticuloProducto1);
			articulo1.addDetalleArticuloManufacturado(detalleArticuloManufacturado);

			//DetalleFactura

			DetalleFactura detalleFactura1 = new DetalleFactura();
			detalleFactura1.setSubtotal(new BigDecimal(564));
			detalleFactura1.setCantidad(8);
			detalleFactura1.setArticuloProducto(articulo1);

			//Factura

			Factura factura1 = new Factura();
			factura1.setFechaFacturacion(new Date());
			factura1.setMpPaymentId(4848948L);
			factura1.setMpMerchantOrderId(498456L);
			factura1.setMpPreferenceId("fasdfas");
			factura1.setFormaPago(FormaPago.MERCADO_PAGO);
			factura1.setTotalVenta(new BigDecimal(489421));
			factura1.setEstadoFactura(EstadoFactura.EMITIDO);
			factura1.addDetalleFactura(detalleFactura1);
			factura1.setPedido(pedido1);

			//DetalleCompraIngrediente

			DetalleCompraIngrediente detalleCompraIngrediente1 =new DetalleCompraIngrediente();

			detalleCompraIngrediente1.setCantidadComprada(90);
			detalleCompraIngrediente1.setPrecioCompra(new BigDecimal(48));
			detalleCompraIngrediente1.setSubTotalCompra(new BigDecimal(4549));
			detalleCompraIngrediente1.setArticuloIngrediente(articuloIngrediente);

			DetalleCompraIngrediente detalleCompraIngrediente2 =new DetalleCompraIngrediente();

			detalleCompraIngrediente2.setCantidadComprada(90);
			detalleCompraIngrediente2.setPrecioCompra(new BigDecimal(48));
			detalleCompraIngrediente2.setSubTotalCompra(new BigDecimal(4549));
			detalleCompraIngrediente2.setArticuloIngrediente(articuloIngrediente);

			//CompraIngredientes

			CompraIngredientes compraIngredientes1 =new CompraIngredientes();

			compraIngredientes1.setCostoTotalCompra(new BigDecimal(564));
			compraIngredientes1.setFechaHoraCompraIngredientes(new Date());
			compraIngredientes1.addDetalleCompraIngrediente(detalleCompraIngrediente1);
			compraIngredientes1.addDetalleCompraIngrediente(detalleCompraIngrediente2);

			//NotaCreditoDetalle

			DetalleNotaCredito detalleNotaCredito = new DetalleNotaCredito();
			detalleNotaCredito.setCantidad(8);
			detalleNotaCredito.setArticuloProducto(articulo1);

			//NotaCredito

			NotaCredito notaCredito = new NotaCredito();
			notaCredito.setFechaHoraEmision(new Date());
			notaCredito.setFactura(factura1);
			notaCredito.setTotalImporteCredito(new BigDecimal(54));
			notaCredito.addDetalleNotaCredito(detalleNotaCredito);

			//GUARDAR

		};
	}

}
