package ru.mtuci.simpleapi.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Result extends AbstractBaseEntity{
    @NotBlank
    private String fname;
    @NotBlank
    private String lname;
    @NotNull
    private Date date;
    @NotBlank
    private String event;
    @NotNull
    private Integer distance;
    @NotNull
    private Time time;
}
