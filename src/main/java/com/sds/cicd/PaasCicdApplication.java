package com.sds.cicd;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@SpringBootApplication    
public class PaasCicdApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaasCicdApplication.class, args);
//        test();
    }
    public static void test() {
        JenkinsServer jenkins = new JenkinsServer(URI.create("http://120.136.134.158:8080/"), "admin", "sds.1234");
        Map<String, Job> jobs = null;
        try {
            jobs = jenkins.getJobs();
            JobWithDetails job = jobs.get("job1").details();
            Build buildByNumber = job.getBuildByNumber(1);
            String outputText = null;
            BuildWithDetails details = null;
            details = buildByNumber.details();
            outputText = details.getConsoleOutputText();
            System.out.println(details.getConsoleOutputHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jobs);

    }
}
