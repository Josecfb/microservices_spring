package es.edu.escuela_it.microservices.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@ApiModel(description = "System User")
public class UserDTO extends RepresentationModel<UserDTO>{

	@NonNull
	@NotNull
	@ApiModelProperty(notes = "Unique identifier of the User", example = "1",required = true, position = 0)
	private Integer id;
	
	@NonNull
	@NotBlank
	private String name;
	
	@NotNull
	@Size(min=6, max=20)
	private String lastName;
	
	@ToString.Exclude
	@Positive
	@Min(18)
	@Max(100)
	private int edad;
	
	@Email
	private String email;
	
	@AssertTrue
	private boolean active;
	
	@Past
	private LocalDate birdDate;
}
