package cn.wf.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId("id")
    private Long id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("email")
    private String email;
}