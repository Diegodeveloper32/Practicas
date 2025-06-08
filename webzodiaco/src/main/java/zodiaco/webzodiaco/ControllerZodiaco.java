package zodiaco.webzodiaco;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerZodiaco {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "index";
    }

    @PostMapping("/calcular")
    public String procesarFormulario(@RequestParam("anio") int anio, Model model) {
        String signo = obtenerSigno(anio);
        model.addAttribute("anio", anio);
        model.addAttribute("signo", signo);
        return "respuestass";
    }

    public String obtenerSigno(int anio) {
        String[] signos = {
                "Mono", "Gallo", "Perro", "Cerdo", "Rata", "Buey",
                "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Cabra"
        };
        int indice = anio % 12;
        return signos[indice];
    }
}
