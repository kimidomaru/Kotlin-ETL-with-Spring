package restService.kotlinv1.repositories

import restService.kotlinv1.model.WorkdayTb
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface WorkdayRepository : JpaRepository<WorkdayTb, Int>
