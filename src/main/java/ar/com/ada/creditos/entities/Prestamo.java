package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/* @entity indica que clase actuara como entidad  */
//@table indica a que tabla va a persistirse ese objeto


@Entity
@Table(name="Prestamo")
public class Prestamo {
@Id //que es una APK
@Column (name="prestamo_id") //nombre en el que se mapea la base de datos
@GeneratedValue (strategy = GenerationType.IDENTITY)//autoincremental
private int PrestamoId;
private BigDecimal importe;
private Date fecha;
@Column(name="cuotas")
private int cuotas;
@Column(name="fecha_alta")
private Date fechaAlta;

@ManyToOne
@JoinColumn(name="cliente_id", referencedColumnName = "cliente_id")

private Cliente cliente;

public BigDecimal getImporte() {
    return importe;
}

public void setImporte(BigDecimal importe) {
    this.importe = importe;
}

public Date getFecha() {
    return fecha;
}

public void setFecha(Date fecha) {
    this.fecha = fecha;
}

public int getCuotas() {
    return cuotas;
}

public void setCuotas(int cuotas) {
    this.cuotas = cuotas;
}

public Date getFechaAlta() {
    return fechaAlta;
}

public void setFechaAlta(Date fechaAlta) {
    this.fechaAlta = fechaAlta;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
    this.cliente.getPrestamos().add(this); //
}



    
}