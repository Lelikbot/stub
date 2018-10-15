package xyz.kolokolov.stub.dao

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.springframework.stereotype.Service

@Service
class FileService {

    static String getParam(String paramName) {
        // TODO : добавить путь к конфигу с ответами
        def parse = new JsonSlurper().parse(new File("put you web-config-dev.json here"))
        def params = parse["parameters"]
        def find = params?.find { it.name == paramName }
        if (find == null) return "params with name ${paramName} not found"
        return JsonOutput.toJson(parameters: [
                name: find.name,
                path: find.path,
                type: find.type,
                values: find.values,
                groupValues: [code: "", value: ""]
        ])
    }
}
