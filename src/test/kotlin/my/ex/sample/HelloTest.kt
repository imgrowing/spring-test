package my.ex.sample

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class HelloTest : FunSpec({

    context("test") {
        test("test") {
            val greeting = "Hello"
            greeting shouldBe "Hello"
        }
    }

})
