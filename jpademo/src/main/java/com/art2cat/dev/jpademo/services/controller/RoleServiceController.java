package com.art2cat.dev.jpademo.services.controller;

import com.art2cat.dev.jpademo.models.Role;
import com.art2cat.dev.jpademo.services.intf.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * com.art2cat.dev.jpademo.services.controller
 *
 * @author rorschach
 * @date 4/15/18
 */
@RestController
@RequestMapping("/role")
public class RoleServiceController {
    
    @Autowired
    private IRoleService roleService;
    
    @RequestMapping(value = "/insertRole", method = RequestMethod.POST)
    public ResponseEntity<?> insertRole(@Valid @RequestBody Role role, Errors errors) {
        String result;
        if (errors.hasErrors()) {
            // get all errors
            result = errors.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
            
            return ResponseEntity.badRequest().body(result);
        }
        int returnCode = roleService.insertRole(role);
        return ResponseEntity.ok(returnCode);
    }
    
    @RequestMapping(value = "/updateRole", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@Valid @RequestBody Role role, Errors errors) {
        String result;
        if (errors.hasErrors()) {
            // get all errors
            result = errors.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
            
            return ResponseEntity.badRequest().body(result);
        }
        int returnCode = roleService.updateRole(role);
        return ResponseEntity.ok(returnCode);
    }
    
    @RequestMapping(value = "/deleteRole", method = RequestMethod.DELETE)
    public int deleteRole(@RequestParam(value = "id") Integer id) {
        return roleService.deleteRole(id);
    }
    
    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public Role getRole(@RequestParam(value = "id") Integer id) {
        return roleService.getRole(id);
    }
    
    @RequestMapping(value = "/findRoles", method = RequestMethod.GET)
    public List<Role> findRoles(@RequestParam(value = "roleName") String roleName,
        @RequestParam(value = "start") int start, @RequestParam(value = "limit") int limit) {
        return roleService.findRoles(roleName, start, limit);
    }
}
