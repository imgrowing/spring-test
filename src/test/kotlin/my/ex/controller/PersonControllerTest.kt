package my.ex.controller

import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.mockk
import my.ex.domain.Person
import my.ex.objectMapper
import my.ex.service.PersonService
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import org.springframework.util.LinkedMultiValueMap
import java.time.LocalDate
import java.time.LocalDateTime

class PersonControllerTest : FunSpec({

    val messageConverter = MappingJackson2HttpMessageConverter(objectMapper)

    val personService: PersonService = mockk()
    val controller = PersonController(personService)
    val mockMvc = standaloneSetup(controller)
        .setMessageConverters(messageConverter)
        .build()

    test("/person") {
        val person = Person(
            id = 1,
            name = "홍길동1",
            age = 20,
            birthDate = LocalDate.now(),
            createdAt = LocalDateTime.now()
        )
        every { personService.getPerson("홍길동1") } returns person

        mockMvc
            .get("/person") {
                accept = MediaType.APPLICATION_JSON
                params = LinkedMultiValueMap<String, String>().apply {
                    add("name", "홍길동1")
                }
            }
            .andDo {
                print()
            }
            .andExpect {
                status { isOk() }
                content {
                    json(person.toJson())
                }
            }
    }

})

fun <T> T.toJson(): String {
    return objectMapper.writeValueAsString(this)
}
