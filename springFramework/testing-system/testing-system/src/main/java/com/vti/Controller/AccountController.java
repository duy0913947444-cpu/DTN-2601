package com.vti.Controller;

import com.vti.Entity.Account;
import com.vti.Service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    //crud
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Integer id){
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable(name = "id") Integer id, @RequestBody Account account){
        return new ResponseEntity<>(accountService.updateAccount(id, account),HttpStatus.NO_CONTENT);
    }
}
