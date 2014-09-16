package hello.repository;

import hello.entity.Task;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
	
	Task findByTitleAllIgnoringCase(String title);

}
