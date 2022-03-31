package co.com.sofka.app.ferreteria.utils;

import co.com.sofka.app.ferreteria.dtos.cliente.ClienteDTO;
import co.com.sofka.app.ferreteria.dtos.factura.FacturaDTO;
import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import co.com.sofka.app.ferreteria.dtos.proveedor.ProveedorDTO;
import co.com.sofka.app.ferreteria.models.Cliente;
import co.com.sofka.app.ferreteria.models.Factura;
import co.com.sofka.app.ferreteria.models.Producto;
import co.com.sofka.app.ferreteria.models.Proveedor;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static ClienteDTO clienteModelToDto(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }

    public static Cliente clienteDtoToModel(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return cliente;
    }

    public static ProductoDTO productoModelToDto(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        BeanUtils.copyProperties(producto, productoDTO);
        return productoDTO;
    }

    public static Producto productoDtoToModel(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        BeanUtils.copyProperties(productoDTO, producto);
        return producto;
    }

    public static ProveedorDTO proveedorModelToDto(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        BeanUtils.copyProperties(proveedor, proveedorDTO);
        return proveedorDTO;
    }

    public static Proveedor proveedorDtoToModel(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor();
        BeanUtils.copyProperties(proveedorDTO, proveedor);
        return proveedor;
    }

    public static FacturaDTO facturaModelToDto(Factura factura) {
        FacturaDTO facturaDTO = new FacturaDTO();
        BeanUtils.copyProperties(factura, facturaDTO);
        return facturaDTO;
    }

    public static Factura facturaDtoToModel(FacturaDTO facturaDTO) {
        Factura factura = new Factura();
        BeanUtils.copyProperties(facturaDTO, factura);
        return factura;
    }
}
