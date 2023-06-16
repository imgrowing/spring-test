package my.ex.domain

import io.kotest.matchers.nulls.shouldNotBeNull
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

// kotest의 FunSpec으로 DataJpaTest 를 수행한다. PersonRepository를 주입받아서 테스트를 진행한다.
@DataJpaTest
@ExtendWith(MockKExtension::class)
class PersonRepositoryTest(
        private val personRepository: PersonRepository
) : io.kotest.core.spec.style.FunSpec({

    test("PersonRepository 테스트") {

        val name = "홍길동1"
        val person = personRepository.findByName(name)

        person?.let {
            println("person = ${person}")
        }

        person.shouldNotBeNull()

    }

})
