package my.ex.controller

import my.ex.domain.Person
import my.ex.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(
        private val personService: PersonService
) {
    @GetMapping("/person")
    fun getPerson(@RequestParam("name") name: String): Person? {
        return personService.getPerson(name)
    }

    @GetMapping("/person/list")
    fun getPersonList(): List<Person> {
        return personService.getPersonList()
    }
}
