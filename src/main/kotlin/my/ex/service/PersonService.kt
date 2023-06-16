package my.ex.service

import my.ex.domain.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
        private val personRepository: PersonRepository
) {
    fun getPerson(name: String) = personRepository.findByName(name)

    fun getPersonList() = personRepository.findAllByOrderByAgeDesc()
}
