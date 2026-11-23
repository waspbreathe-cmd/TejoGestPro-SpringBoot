package com.tejogestpro.controlador;

import com.tejogestpro.modelo.Cliente;
import com.tejogestpro.repositorio.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador Spring MVC que atiende las peticiones web del modulo de Clientes
 * de TejoGest Pro (listar, registrar, editar y eliminar).
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Lista todos los clientes y prepara el objeto formulario para creacion.
     */
    @GetMapping
    public String listarClientes(Model model) {
        if (!model.containsAttribute("cliente")) {
            model.addAttribute("cliente", new Cliente());
        }
        model.addAttribute("listaClientes", clienteRepository.findAll());
        return "index";
    }

    /**
     * Guarda un cliente nuevo o actualiza uno existente validando los campos.
     */
    @PostMapping("/guardar")
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente,
                                 BindingResult result,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        // Si hay errores de validacion, vuelve a la vista mostrando mensajes por campo
        if (result.hasErrors()) {
            model.addAttribute("listaClientes", clienteRepository.findAll());
            return "index";
        }

        boolean esEdicion = (cliente.getIdCliente() != null);
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("mensajeExito",
                esEdicion ? "Cliente actualizado correctamente." : "Cliente registrado correctamente.");
        return "redirect:/clientes";
    }

    /**
     * Carga los datos de un cliente en el formulario para su edicion.
     */
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            redirectAttributes.addFlashAttribute("mensajeError", "El cliente solicitado no existe.");
            return "redirect:/clientes";
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("listaClientes", clienteRepository.findAll());
        return "index";
    }

    /**
     * Elimina un cliente de la base de datos por su identificador.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        clienteRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensajeExito", "Cliente eliminado correctamente.");
        return "redirect:/clientes";
    }
}