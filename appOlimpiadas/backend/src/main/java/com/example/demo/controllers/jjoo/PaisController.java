package com.example.demo.controllers.jjoo;

import com.example.demo.entitites.jjoo.Pais;
import com.example.demo.entitites.log.Log;
import com.example.demo.mapper.PaisMapper;
import com.example.demo.mapper.dto.PaisDTO;
import com.example.demo.repository.jjoo.queries.NumeroSedesPorPaisDTO;
import com.example.demo.services.jjoo.PaisService;
import com.example.demo.services.log.LogService;
import io.reflectoring.api.PaisesApi;
import io.reflectoring.api.SedesApi;
import io.reflectoring.model.PaisesAddPostRequest;
import io.reflectoring.model.SedesInner;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PaisController implements PaisesApi, SedesApi {
    @Autowired
    private PaisService paisService;

    @Autowired
    private LogService logService;

    @Autowired
    private PaisMapper paisMapper;

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @RequestMapping("/paises")
    public ResponseEntity<List<io.reflectoring.model.Pais>> paisesGet(@CookieValue(value = "user", defaultValue = "defaultUser") String user) {

        List<PaisDTO> paises = paisService.getAllPaises();

        // Registrar el log si el usuario está presente en la cookie
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

        // Usar el mapper para convertir de PaisDTO a io.reflectoring.model.Pais
        List<io.reflectoring.model.Pais> result = paises.stream()
                .map(paisMapper::toReflectoringPais)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises/{id}")
    public ResponseEntity<io.reflectoring.model.Pais> paisesIdGet(@PathVariable Long id, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
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

            io.reflectoring.model.Pais result = new io.reflectoring.model.Pais();
            result.setIDPAIS(pais.getId());
            result.NOMBRE_PAIS(pais.getNombrePais());
            result.CODIGO_PAIS(pais.getCodigoPais());
            result.VALOR_PAIS(pais.getValorPais());


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
            @Parameter(name = "PaisesAddPostRequest", description = "")
            @Valid
            @RequestBody(required = false) PaisesAddPostRequest paisesAddPostRequest) {
        System.out.println("AAA");
        Pais newPais = new Pais();
        newPais.setNombrePais(paisesAddPostRequest.getNOMBREPAIS());
        newPais.setCodigoPais(paisesAddPostRequest.getCODIGOPAIS());
        newPais.setValorPais(paisesAddPostRequest.getVALORPAIS().intValue());
        Pais savedPais = paisService.savePais(newPais);
        System.out.println("BBB");
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

        io.reflectoring.model.Pais result = new io.reflectoring.model.Pais();
        result.setIDPAIS(savedPais.getId());
        result.NOMBRE_PAIS(savedPais.getNombrePais());
        result.CODIGO_PAIS(savedPais.getCodigoPais());
        result.VALOR_PAIS(savedPais.getValorPais());

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
    @GetMapping("paises/codigo/{codigo}")
    public ResponseEntity<List<io.reflectoring.model.Pais>> paisesCodigoCodigoGet(@PathVariable String codigo, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
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

            io.reflectoring.model.Pais result = new io.reflectoring.model.Pais();
            result.setIDPAIS(pais.getId());
            result.NOMBRE_PAIS(pais.getNombrePais());
            result.CODIGO_PAIS(pais.getCodigoPais());
            result.VALOR_PAIS(pais.getValorPais());

            List resultList = new ArrayList();

            resultList.add(result);

            return ResponseEntity.status(HttpStatus.OK).body(resultList);
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
    public ResponseEntity<io.reflectoring.model.Pais> paisesUpdateIdPut(@PathVariable long id, @RequestBody Pais pais, @CookieValue(value = "user", defaultValue = "defaultUser") String user) {
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
        List<NumeroSedesPorPaisDTO> sedes = paisService.getSedesQuery();

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

        List<io.reflectoring.model.SedesInner> result = sedes.stream().map(x -> {
            io.reflectoring.model.SedesInner sedesInner = new io.reflectoring.model.SedesInner();
            sedesInner.setIDPAIS(x.getID_PAIS());
            sedesInner.setNOMBREPAIS(x.getNOMBRE_PAIS());
            sedesInner.setIDCIUDAD(x.getID_CIUDAD());
            sedesInner.setVALORCIUDAD(x.getVALOR_CIUDAD());
            sedesInner.setDESCRIPCIONTIPO(x.getDESCRIPCION_TIPO());
            sedesInner.setCOUNTSEDES(x.getCOUNT_SEDES());
            return sedesInner;
        }).toList();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
