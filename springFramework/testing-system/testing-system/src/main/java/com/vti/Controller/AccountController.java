package com.vti.Controller;

import com.vti.From.AccountFrom;
import com.vti.From.AccountSearchFrom;
import com.vti.Service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigUtils;
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
    public ResponseEntity<?> findAll(AccountSearchFrom accountSearchFrom) {
        return new ResponseEntity<>(accountService.findAll(accountSearchFrom), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountFrom createAccountFrom) {
        accountService.createAccount(createAccountFrom);
        return new ResponseEntity<>("Create success!!", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Integer id) {
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable(name = "id") Integer id,
                                           @RequestBody AccountFrom accountFrom) {
        accountService.updateAccount(id, accountFrom);
        return new ResponseEntity<>("Update success", HttpStatus.NO_CONTENT);
    }
}
