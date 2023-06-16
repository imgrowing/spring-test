package my.ex.domain

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "person")
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "name")
    var name: String,

    @Column(name = "age")
    var age: Int,

    @Column(name = "birth_date")
    var birthDate: LocalDate,

    @Column(name = "created_at")
    var createdAt: LocalDateTime,
) {
    override fun toString(): String {
        return "Person(id=$id, name='$name', age=$age, birthDate=$birthDate, createdAt=$createdAt)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
