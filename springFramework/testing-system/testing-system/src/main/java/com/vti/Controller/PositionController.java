package com.vti.Controller;

import com.vti.Entity.Position;
import com.vti.From.PositionFrom;
import com.vti.From.PositionSearchFrom;
import com.vti.Service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/positions")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity<?> findAll(PositionSearchFrom positionSearchFrom){
        return new ResponseEntity<>(positionService.findAll(positionSearchFrom), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPosition(@RequestBody PositionFrom position){
        positionService.createPosition(position);
        return new ResponseEntity<>("Create success", HttpStatus.CREATED);
    }
}
