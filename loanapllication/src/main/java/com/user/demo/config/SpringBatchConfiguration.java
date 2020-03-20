package com.user.demo.config;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.user.demo.model.User;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration {
	

	@Bean
    public Job job(JobBuilderFactory jobBuilderFactory,StepBuilderFactory stepBuilderFactory,
    		ItemReader<User> itemReader,
    		ItemProcessor<User,User> itemProcessor,ItemWriter<User> itemWriter) {
		
		Step step=stepBuilderFactory.get("ETL-file-load")
				.<User,User>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
				
   return jobBuilderFactory.get("ETL-Load")
		   .incrementer(new RunIdIncrementer())
		   .start(step)
		   .build();
				
	}

 
	
	
 

    @Bean
    public FlatFileItemReader<User> itemReader(@Value("${input}")org.springframework.core.io.Resource resource) {
        FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<User>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        
            return flatFileItemReader;
    }
        



        
        @Bean
        public LineMapper<User> lineMapper(){
        	
        DefaultLineMapper<User>	defaultLineMapper=new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        
    	 lineTokenizer.setDelimiter("'");
    	 lineTokenizer.setStrict(false);
    	 lineTokenizer.setNames(new String[] {"id","name","gender","salary","age","pan","adhar"});
    	 
    	  BeanWrapperFieldSetMapper<User> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
    	  
    	 fieldSetMapper.setTargetType(User.class);
    	 defaultLineMapper.setLineTokenizer(lineTokenizer);
    	defaultLineMapper.setFieldSetMapper(fieldSetMapper);
    	
    	 return defaultLineMapper;
        }

//@Bean
//public EmployeeWriter writer() {
//    return new EmployeeWriter();
//}
//
//
//
// @Bean
//    publicLineMapper<User> lineMapper(){
//    DefaultLineMapper<User>	defaultLineMapper=new DefaultLineMapper<>();
//    DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
//	 lineTokenizer.setDelimiter("'");
//	 lineTokenizer.setStrict(false);
//	 lineTokenizer.setNames("id","name","salary","age","gender",);
//	 defaultLineMapper.setLineTokenizer(lineTokenizer);
//	 BeanWrapperFieldSetMapper<User> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
//	 fieldSetMapper.setTargetType(User.class);
//	 defaultLineMapper.setLineTokenizer(lineTokenizer);
//	defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//	 return defaultLineMapper;
//    }
//    }
//
//    @Bean
//    public EmployeeWriter writer() {
//        return new EmployeeWriter();
//    }
//
// 
//
//    @Bean
//    public JpaItemWriter<User> jpaWriter() {
//        JpaItemWriter<User> jpa = new JpaItemWriter<>();
//        jpa.setEntityManagerFactory(entityManager);
//        return jpa;
//    }
//    
//    @Bean
//    public Job readEmployeeCSV() {
//        return jobBuilderFactory.get("readEmployeeCSV")
//        .incrementer(new RunIdIncrementer())
//        .start(step1())
//        .build();
//    }
//    
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1").<User,User> chunk(5)
//        .reader(reader())
//        .writer(writer())
//        .build();
//        
//    }
//      DelimitedLineTokenizer delimiter = new DelimitedLineTokenizer();
//      
//      String[] tokens = { "firstname", "lastname", "designation", "salary", "experience" };
//      delimiter.setDelimiter(",");
//      delimiter.setNames(tokens);
//      
//      DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();

 }

