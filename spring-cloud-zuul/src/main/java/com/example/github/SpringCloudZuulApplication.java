package com.example.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * Hello world!
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(SpringCloudZuulApplication.class);
    }
}