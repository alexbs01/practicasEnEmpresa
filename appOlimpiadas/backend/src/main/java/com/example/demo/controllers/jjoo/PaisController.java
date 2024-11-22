package com.example.demo.controllers.jjoo;

import com.example.demo.entitites.jjoo.Pais;
import com.example.demo.entitites.log.Log;
import com.example.demo.mapper.PaisMapper;
import com.example.demo.mapper.dto.PaisDTO;
import com.example.demo.mapper.dto.SedesDTO;
import com.example.demo.services.jjoo.PaisService;
import com.example.demo.services.kafka.KafkaProducerService;
import com.example.demo.services.log.LogService;
import io.reflectoring.api.PaisesApi;
import io.reflectoring.api.SedesApi;
import io.reflectoring.model.PaisesAddPostRequest;
import io.reflectoring.model.SedesInner;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PaisController implements PaisesApi, SedesApi {
    @Autowired
    private PaisService paisService;

    @Autowired
    private LogService logService;

    @Autowired
    private PaisMapper paisMapper;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @RequestMapping("/paises")
    public ResponseEntity<List<io.reflectoring.model.Pais>> paisesGet(@CookieValue(value = "user", defaultValue = "defaultUser") String user) {

        List<PaisDTO> paises = paisService.getAllPaises();

        // Registrar el log si el usuario está presente en la cookie
        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Get all paises");
            try {
                logService.save(log);
                kafkaProducerService.logUserLogin(user, "Get all paises");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }

        // Usar el mapper para convertir de PaisDTO a io.reflectoring.model.Pais
        List<io.reflectoring.model.Pais> result = paises.stream()
                .map(paisMapper::toReflectoringPais)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises/{id}")
    public ResponseEntity<io.reflectoring.model.Pais> paisesIdGet(@PathVariable Long id, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        PaisDTO pais = paisService.getPaisById(id);

        if(pais != null) {
            if (user != null && !user.isEmpty()) {
                Log log = new Log(user, LocalDateTime.now(), "Get pais by id");
                try {
                    logService.save(log);
                    kafkaProducerService.logUserLogin(user, "Get pais by id");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("No se encontró el usuario en la cookie");
            }

            io.reflectoring.model.Pais result = paisMapper.toReflectoringPais(pais);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<io.reflectoring.model.Pais> paisesUpdateIdPut(Long id, String user, PaisesAddPostRequest paisesAddPostRequest) {
        return null;
    }

    /*ResponseEntity<io.reflectoring.model.Pais> paisesAddPost(
            @Parameter(name = "user", description = "Cookie que contiene el nombre del usuario que realiza la solicitud", in = ParameterIn.COOKIE)
            @CookieValue(name = "user", required = false) String user,
            @Parameter(name = "PaisesAddPostRequest", description = "")
            @Valid
            @RequestBody(required = false) PaisesAddPostRequest paisesAddPostRequest
    ) {

    }*/
    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @PostMapping("paises/add")
    public ResponseEntity<io.reflectoring.model.Pais> paisesAddPost(
            @Parameter(name = "user", description = "Cookie que contiene el nombre del usuario que realiza la solicitud", in = ParameterIn.COOKIE)
            @CookieValue(name = "user", required = false) String user,
            @Parameter(name = "PaisesAddPostRequest")
            @Valid
            @RequestBody(required = false) PaisesAddPostRequest paisesAddPostRequest) {

        PaisDTO newPais = new PaisDTO();
        newPais.setNombrePais(paisesAddPostRequest.getNOMBREPAIS());
        newPais.setCodigoPais(paisesAddPostRequest.getCODIGOPAIS());
        newPais.setValorPais(paisesAddPostRequest.getVALORPAIS());

        PaisDTO savedPais = paisService.savePais(paisMapper.toPais(newPais));

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Pais added");
            try {
                logService.save(log);
                kafkaProducerService.logUserLogin(user, "Pais added");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }

        io.reflectoring.model.Pais result = paisMapper.toReflectoringPais(savedPais);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises/codigo/{codigo}")
    public ResponseEntity<io.reflectoring.model.Pais> paisesCodigoCodigoGet(@PathVariable String codigo, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        PaisDTO pais = paisService.findByCodigo(codigo);

        if (pais != null) {
            if (user != null && !user.isEmpty()) {
                Log log = new Log(user, LocalDateTime.now(), "Get pais by code");
                try {
                    logService.save(log);
                    kafkaProducerService.logUserLogin(user, "Get pais by code");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("No se encontró el usuario en la cookie");
            }

            io.reflectoring.model.Pais result = paisMapper.toReflectoringPais(pais);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            if (user != null && !user.isEmpty()) {
                Log log = new Log(user, LocalDateTime.now(), "Get pais by code");
                try {
                    logService.save(log);
                    kafkaProducerService.logUserLogin(user, "Get pais by code");
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
    public ResponseEntity<io.reflectoring.model.Pais> paisesUpdateIdPut(@PathVariable long id, @RequestBody Pais pais, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        PaisDTO savedPais = paisService.updatePais(id, pais);

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Pais updated");
            try {
                logService.save(log);
                kafkaProducerService.logUserLogin(user, "Pais updated");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }

        io.reflectoring.model.Pais result = new io.reflectoring.model.Pais();
        result.setIDPAIS(pais.getId());
        result.NOMBRE_PAIS(pais.getNombrePais());
        result.CODIGO_PAIS(pais.getCodigoPais());
        result.VALOR_PAIS(pais.getValorPais());

        if (savedPais != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("sedes")
    public ResponseEntity<List<SedesInner>> sedesGet(@CookieValue(value = "user", defaultValue = "defaultUser") String user) {
        List<SedesDTO> sedes = paisService.getSedesQuery();

        if (user != null && !user.isEmpty()) {
            Log log = new Log(user, LocalDateTime.now(), "Get sedes");
            try {
                logService.save(log);
                kafkaProducerService.logUserLogin(user, "Get sedes");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró el usuario en la cookie");
        }

        List<io.reflectoring.model.SedesInner> result = sedes.stream().map(paisMapper::toSedesInner).toList();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
