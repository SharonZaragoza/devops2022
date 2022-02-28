package mx.tecnm.piedad.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.UsuariosJDBC;
//comentario para ejemplificar cambios en Git

@RestController
@RequestMapping("/api/mensajes")
public class Mensaje {
	
	@Autowired
	UsuariosJDBC repo;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> autenticar(@RequestParam String email, @RequestParam String pass){
	
	String token="";	
		if(repo.login(email, pass)==true) {
		return new ResponseEntity<>(token, HttpStatus.OK);
		}		
			else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
	}
	
	
	
	
	
	
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
    



