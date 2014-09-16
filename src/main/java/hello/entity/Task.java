package hello.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Task implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private Date dateCreated;
	private Date dateUpdated;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	protected Task() {
	}

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
		this.status = TaskStatus.TODO;
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.dateUpdated = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

}
