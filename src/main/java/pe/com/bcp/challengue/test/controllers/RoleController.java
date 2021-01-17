package pe.com.bcp.challengue.test.controllers;

import pe.com.bcp.challengue.test.dto.RoleRequest;
import pe.com.bcp.challengue.test.entities.Role;
import pe.com.bcp.challengue.test.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {


    @Autowired
    RoleRepository roleRepository;
    @PostMapping("/save")
    @PermitAll
    public void save( RoleRequest roleRequest){
        Role roleEntity = new Role();
        BeanUtils.copyProperties(roleRequest, roleEntity);
        try{
        roleRepository.save(roleEntity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @GetMapping("findAll")
    @PermitAll
    public void findAll(){
        List< RoleRequest> listRolesResponse = new ArrayList<>();
        List<Role> listRoles = roleRepository.findAll();
        System.out.println("listRoles.size() "  + listRoles.size());
        BeanUtils.copyProperties(listRoles, listRolesResponse);
       listRolesResponse.stream().forEach((x)-> System.out.println(x.getName()));
    }

}
