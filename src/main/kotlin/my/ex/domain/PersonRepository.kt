package my.ex.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {
    fun findByName(name: String): Person?
    fun findAllByOrderByAgeDesc(): List<Person>
}
