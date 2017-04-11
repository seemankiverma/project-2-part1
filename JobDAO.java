package daos;

import java.util.List;

import models.Job;
import models.JobApplication;

public interface JobDAO {

	public boolean save(Job job); //posting a job

	public boolean update(Job job); //updating job
	
	public boolean update(JobApplication jobApplication);

	public Job get(int jobID);

	public JobApplication get(int jobID,int userID);
	
	public JobApplication getMyAppliedJobs(int userID);
	
	public List<Job> getAllVacantJobs();
	
	public List<Job> list();
	
	public boolean updateJobApplication(JobApplication jobApplication);
	
	public boolean applyForJob(JobApplication jobApplication);
	
	public JobApplication getJobApplication(int jobID);

}
