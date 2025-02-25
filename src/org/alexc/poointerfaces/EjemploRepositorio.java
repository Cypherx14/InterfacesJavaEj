package org.alexc.poointerfaces;

import org.alexc.poointerfaces.modelo.Cliente;
import org.alexc.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        CrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Alex", "Coro"));
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Luz", "Martinez"));
        repo.crear(new Cliente("Marco", "Asencio"));


        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("Usando paginable");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1,3);
        paginable.forEach(System.out::println);

        System.out.println("Ordenar ASC");
        List<Cliente> ordenable = ((OrdenableRepositorio)repo).listar("apellido", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("**********");
        Cliente marcoAct = new Cliente("Marco", "Polo");
        marcoAct.setId(3);
        repo.editar(marcoAct);
        Cliente marco = repo.porId(3);
        System.out.println(marco);

        System.out.println("*****ORDENAR DESC******");
        List<Cliente> ordenableDesc = ((OrdenableRepositorio)repo).listar("apellido", Direccion.DESC);
        ordenableDesc.forEach(System.out::println);
        

    }
}
