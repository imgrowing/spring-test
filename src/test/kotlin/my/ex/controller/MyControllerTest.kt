package my.ex.controller

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import my.ex.service.MyService
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [MyController::class])
class MyControllerTest(
        private val mockMvc: MockMvc,
        @MockkBean
        private val myService: MyService,
) : FunSpec({

    test("hello") {
        every { myService.getMessage() } returns "Hello, World!"

        mockMvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andReturn()
                .response
                .contentAsString shouldBe "Hello, World!"
    }

    test("hello2") {
        every { myService.getMessage() } returns "Hello, World!"

        mockMvc.get("/hello") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { string("Hello, World!") }
        }
    }

})
