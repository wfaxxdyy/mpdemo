package cn.wf.mpdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.wf.mpdemo.mapper")
public class MpdemoApplication {

    public static void main(String[] args) {
        System.out.println("hello!new branch!");
        SpringApplication.run(MpdemoApplication.class, args);
    }

}
