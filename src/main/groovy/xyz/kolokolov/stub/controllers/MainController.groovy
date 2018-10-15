package xyz.kolokolov.stub.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import xyz.kolokolov.stub.dao.FileService

@RestController
@RequestMapping(value = "/1.0/parameter/query", produces = MediaType.APPLICATION_JSON_VALUE)
class MainController {

    @Autowired
    FileService service

    @RequestMapping(method = RequestMethod.POST)
    String getParameter(@RequestBody Map req) {
        def criteria = req["criteria"]
        return service.getParam(criteria[0].parameter as String)
    }
}
