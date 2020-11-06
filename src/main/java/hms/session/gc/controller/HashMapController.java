/*
 * (C) Copyright 2008-2020 hSenid Software International (Pvt) Limited.
 *
 * All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Software International (Pvt) Limited.
 *
 * hSenid Software International (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 */

package hms.session.gc.controller;

import hms.session.gc.service.HashMapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hash")
public class HashMapController {

    private final HashMapService hashMapService;

    public HashMapController(HashMapService hashMapService) {
        this.hashMapService = hashMapService;
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addHashMapp(@RequestParam BigInteger keySize) {
        Map<String, Object> responseContent = new HashMap<>();
        hashMapService.addHashMap(keySize);
        responseContent.put("isSuccess", true);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(responseContent, httpStatus);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> removehashMap() {
        Map<String, Object> responseContent = new HashMap<>();
        hashMapService.clearHashMap();
        responseContent.put("isSuccess", true);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(responseContent, httpStatus);
    }
}
