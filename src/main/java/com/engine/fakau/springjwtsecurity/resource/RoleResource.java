package com.engine.fakau.springjwtsecurity.resource;

import com.engine.fakau.springjwtsecurity.repository.RoleRepository;
import com.engine.fakau.springjwtsecurity.security.jwt.JwtRequest;
import com.engine.fakau.springjwtsecurity.security.jwt.JwtResponse;
import com.engine.fakau.springjwtsecurity.sercice.dto.RoleDTO;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class RoleResource {

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/role")
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO roleDTO) throws Exception {
        return ResponseEntity.ok(roleService.create(roleDTO));
    }
    @PutMapping("/role")
    public ResponseEntity<RoleDTO> update(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.update(roleDTO));
    }
    @GetMapping("/role")
    public ResponseEntity<List<RoleDTO>> getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return ResponseEntity.ok(roleService.getAll());
    }
    @DeleteMapping("/role")
    public void delete(@RequestParam("id") final Long id){
        roleService.delete(id);
    }
}
