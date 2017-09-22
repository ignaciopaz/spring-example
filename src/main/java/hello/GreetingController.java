package hello;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
	private CustomerDao cd;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="s", required=false, defaultValue="Hello") String saludo,
    		@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("nombre", name);
        model.addAttribute("saludo", saludo);
        return "saludo";
    }
    
    @RequestMapping("/greetingall")
    public String greetingAll(@RequestParam(value="buscar", required=false) String buscar,
    						Model model) {
    	Collection<Customer> clientes = cd.buscarPorTodo(buscar.toLowerCase());
    	model.addAttribute("clientes", clientes);
    	return "saludatodos";
    }
    

}