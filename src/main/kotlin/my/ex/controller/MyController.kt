package my.ex.controller

import my.ex.service.MyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(
        private val myService: MyService
) {
    @GetMapping("/hello")
    fun hello(): ResponseEntity<String> {
        val message = myService.getMessage()
        return ResponseEntity.ok(message)
    }
}
