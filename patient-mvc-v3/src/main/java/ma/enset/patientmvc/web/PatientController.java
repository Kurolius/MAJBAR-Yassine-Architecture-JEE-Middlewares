package ma.enset.patientmvc.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import ma.enset.patientmvc.security.entities.AppRole;
import ma.enset.patientmvc.security.entities.AppUser;
import ma.enset.patientmvc.security.repositories.AppRoleRepository;
import ma.enset.patientmvc.security.repositories.AppUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Data @AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @GetMapping(path = "/user/index")
    public String patients(Model model,
                           //param d'url
                           @RequestParam(name="page", defaultValue = "0") int page,
                           @RequestParam(name="size", defaultValue = "5") int size,
                           @RequestParam(name="keyword", defaultValue = "") String keyword){
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user/patients")
    @ResponseBody
    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/admin/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatients";
    }

    @GetMapping("/user/profile")
    public String profile(Model model, String username){
        AppUser appUser = appUserRepository.findByUsername(username);
        List<AppRole> roles = new ArrayList<>();
        for (AppRole role: appUser.getAppRoles()) {
            roles.add(role);
        }
        model.addAttribute("roles",roles);
        model.addAttribute("user",appUser);
        return "profile";
    }

    @PostMapping("/admin/save")
    //@Valid ==> je dis à spring mvc une fois tu fais l'ajout d'un patient au BDD tu fais la validation
    //si jamais il y a des erreurs tu les stockes dans BindingResult
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "")String keyword){
        if (bindingResult.hasErrors())
            return "formPatients";
        patientRepository.save(patient);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editPatient")
    public String editPatient(Model model,Long id,
                              @RequestParam(defaultValue = "") String keyword,
                              @RequestParam(defaultValue = "0") int page){
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient==null) throw new RuntimeException("Patient introuvable!!!");
        model.addAttribute("patient",patient);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "editPatient";
    }

    @GetMapping("/user/listPatient")
    public String listPatient(Model model, Long id,
                              @RequestParam(defaultValue = "") String keyword,
                              @RequestParam(defaultValue = "0") int page){
        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "listPatient";
    }

    /*@GetMapping("/auth")
    public String login(){
        return "login";
    }*/
}
