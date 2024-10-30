package com.example.demo.controllers.jjoo;

import com.example.demo.entitites.jjoo.Pais;
import com.example.demo.entitites.log.Log;
import com.example.demo.repository.jjoo.queries.NumeroSedesPorPaisDTO;
import com.example.demo.services.jjoo.PaisService;
import com.example.demo.services.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PaisController {
    @Autowired
    private PaisService paisService;

    @Autowired
    private LogService logService;

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises")
    public ResponseEntity<List<Pais>> getPais(@CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        List<Pais> paises = paisService.getAllPaises();

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Get all paises");
            try {
                logService.save(log);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }

        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }


    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        Pais pais = paisService.getPaisById(id);


        if(pais != null) {
            if (user != null && !user.isEmpty()) {
                Log log = new Log(user, LocalDateTime.now(), "Get pais by id");
                try {
                    logService.save(log);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("No se encontró el usuario en la cookie");
            }
            return ResponseEntity.status(HttpStatus.OK).body(pais);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @PostMapping("paises/add")
    public ResponseEntity<Pais> addPais(@RequestBody Pais pais, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        Pais savedPais = paisService.savePais(pais);

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Pais added");
            try {
                logService.save(log);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPais);
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises/codigo/{codigo}")
    public ResponseEntity<Pais> getPaisByCodigo(@PathVariable String codigo, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        Pais pais = paisService.findByCodigo(codigo);

        if (pais != null) {
            if (user != null && !user.isEmpty()) {
                Log log = new Log(user, LocalDateTime.now(), "Get pais by code");
                try {
                    logService.save(log);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("No se encontró el usuario en la cookie");
            }
            return ResponseEntity.status(HttpStatus.OK).body(pais);
        } else {
            if (user != null && !user.isEmpty()) {
                Log log = new Log(user, LocalDateTime.now(), "Get pais by code");
                try {
                    logService.save(log);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("No se encontró el usuario en la cookie");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @PutMapping("paises/update/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable long id, @RequestBody Pais pais, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        Pais savedPais = paisService.updatePais(id, pais);

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Pais updated");
            try {
                logService.save(log);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }

        if (savedPais != null) {
            return ResponseEntity.status(HttpStatus.OK).body(savedPais);
        }

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("sedes")
    public ResponseEntity<List<NumeroSedesPorPaisDTO>> getSedes(@CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        List<NumeroSedesPorPaisDTO> paises = paisService.getSedesQuery();

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Get sedes");
            try {
                logService.save(log);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }
        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }
}
