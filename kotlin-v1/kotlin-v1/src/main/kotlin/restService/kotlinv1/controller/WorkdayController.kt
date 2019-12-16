package restService.kotlinv1.controller

import restService.kotlinv1.model.WorkdayTb
import restService.kotlinv1.repositories.WorkdayRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class WorkdayController(private val workdayRepository: WorkdayRepository) {

    @GetMapping("/wkd")
    fun getAllWorkdays(): List<WorkdayTb> =
            workdayRepository.findAll()


    @PostMapping("/wkd")
    fun createNewWorkday(@Valid @RequestBody workDay: WorkdayTb): WorkdayTb =
            workdayRepository.save(workDay)


    @GetMapping("/wkd/{id}")
    fun getWorkdayById(@PathVariable(value = "id") workDayId: Int): ResponseEntity<WorkdayTb> {
        return workdayRepository.findById(workDayId).map { workDay ->
            ResponseEntity.ok(workDay)
        }.orElse(ResponseEntity.notFound().build())
    }
/*
    @PutMapping("/articles/{id}")
    fun updateArticleById(@PathVariable(value = "id") workDayId: Int,
                          @Valid @RequestBody newWorkDay: Workday): ResponseEntity<Workday> {

        return workdayRepository.findById(workDayId).map { existingArticle ->
            val updatedArticle: Workday = existingArticle
                    .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(workdayRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/articles/{id}")
    fun deleteArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Void> {

        return workdayRepository.findById(articleId).map { article  ->
            workdayRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }*/
}