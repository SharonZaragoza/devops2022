package mx.tecnm.piedad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mensajes")
public class Mensaje {
	
    @GetMapping("/hola")
	public String saludar () {
		return "¡Hola WS!";
	}
    
    @GetMapping("/eco")
    public String eco(@RequestParam String mensaje) {
    return mensaje + " " + mensaje + " " + mensaje;
    }
    
    @GetMapping("/saludo")
    public String saludarUsuario(@RequestParam String usuario, @RequestParam String mensaje) {
    return usuario + " " + mensaje;
    }
    @GetMapping("/mensaje/{numero}")
    public String elegirMensaje(@PathVariable int numero) {
    	String mensajes[] =new String [] {"Hoy depositan", "Arriba el América", "Ya es viernes"};
    	try {
    		return mensajes[numero];
    	} catch (Exception e) {
			return "Suerte para la proxima siga participando";
		}
    }
    
}
    



