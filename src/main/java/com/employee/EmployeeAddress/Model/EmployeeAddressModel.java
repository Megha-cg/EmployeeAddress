package com.employee.EmployeeAddress.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@JsonPropertyOrder({"id", "name","role", "addressOne", "addressTwo", "addressThree" })
@Entity
@Table(name = "employeedb")
@JsonRootName(value = "EmployeeAddress")
@JsonIgnoreProperties({ "id", "name" })
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class EmployeeAddressModel {
  
	    @Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
		int id;
	     // @JsonProperty("Name")
	    @Column(name = "name")
		public
		String name;
		@Column(name = "role")
		String role;
		@Column(name = "addressOne")
		String addressOne;
		@Column(name = "addressTwo")
		String addressTwo;
		@Column(name = "addressThree")
		String addressThree;
}