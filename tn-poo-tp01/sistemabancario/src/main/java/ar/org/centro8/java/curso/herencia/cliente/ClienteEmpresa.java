package ar.org.centro8.java.curso.herencia.cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString (callSuper = true)
public class ClienteEmpresa extends Cliente{
    private String nombreFantasia;
    private String cuit;

    //Constructor
    public ClienteEmpresa(int nroCliente, String nombreFantasia, String cuit) {
        super(nroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

}
