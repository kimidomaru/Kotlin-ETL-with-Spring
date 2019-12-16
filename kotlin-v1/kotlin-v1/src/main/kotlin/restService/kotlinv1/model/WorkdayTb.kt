package restService.kotlinv1.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class WorkdayTb(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int = 0,

        @get: NotBlank
        var tipoDate: String = "",

        @get: NotBlank
        var empregado: String = "",

        @get: NotBlank
        var pontos: String = ""
)